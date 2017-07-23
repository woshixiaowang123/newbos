package com.bos.action.sysadmin;

import com.bos.action.BaseAction;
import com.bos.domain.Dept;
import com.bos.service.DeptService;
import com.bos.utils.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * deptAction
 * Created by 隔壁老王 on 2017/7/11.
 */
@Controller
@Scope("prototype")
public class DeptAction extends BaseAction implements ModelDriven<Dept> {
    @Autowired
    private  DeptService deptService;


    private Dept model=new Dept();

    @Override
    public Dept getModel() {
        return model;
    }
//分页查询需要用到page类
    private Page<Dept> page=new Page<Dept>();

    public Page<Dept> getPage() {
        return page;
    }

    public void setPage(Page<Dept> page) {
        this.page = page;
    }

    public String list() throws Exception{

        page = deptService.findPage("from Dept order by orderno desc", this.page, Dept.class, null);
        //得到的page需要压入栈顶,可以提取公用的方法
        //this.pushStack(page);

        //设置分页的URL地址
        page.setUrl("deptAction_list");
        //得到的page需要压入栈顶,可以提取公用的方法
        this.pushStack(page);
        return "list";
    }



    //t通过id查询信息
    public String toview() throws Exception{
       // String id = (String) ServletActionContext.getRequest().getAttribute("id");
        model = deptService.get(Dept.class, model.getId());
        this.pushStack(model);
        return "view";

    }

    //跳转到添加页面的方法
    public  String  tocreate() throws Exception{
        //页面中有一个下拉框,需要查询所有的已经启用的部门信息
        List<Dept> depts = deptService.find("from Dept where state = 1", Dept.class, null);
        //把获得数据压入栈顶
        //ActionContext.getContext().put("deptList",depts);
        this.pushContext("deptList",depts);

        return "tocreate";
    }
    //添加部门的方法
    public String insert() throws Exception{
        deptService.saveOrUpdate(model);
        return  "reList";
    }

    //跳转到修改页面的方法
    public String toupdate() throws Exception{
        model = deptService.get(Dept.class, model.getId());
        this.pushStack(model);
        List<Dept> depts = deptService.find("from Dept where state = 1", Dept.class, null);
        depts.remove(model);
        this.pushContext("deptList",depts);

        return "toupdate";
    }

    //修改用户信息的方法
    public String update() throws Exception{
        deptService.saveOrUpdate(model);
        return "reList";
    }


    //从页面传过来的信息是string类型的,并且不是一个

    //删除
    public String delete() throws Exception{
       String[] ids = model.getId().split(",");
       //遍历删除
        for (String id : ids) {
            deptService.deleteById(Dept.class,id);

        }
               // deptService.delete(Dept.class,ids);
      /*  //现在所有的id都封装到了String数组中
        deptService.delete(Dept.class,ids);*/

        return "reList";
    }
}
