package com.bos.action.sysadmin;

import com.bos.action.BaseAction;
import com.bos.domain.Module;
import com.bos.service.DeptService;
import com.bos.service.ModuleService;
import com.bos.utils.Page;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * ModuleAction
 * Created by 隔壁老王 on 2017/7/11.
 */
@Controller
@Scope("prototype")
public class ModuleAction extends BaseAction implements ModelDriven<Module> {
    @Autowired
    private ModuleService moduleService;

    @Autowired
    private DeptService deptService;


    private Module model=new Module();

    @Override
    public Module getModel() {
        return model;
    }
//分页查询需要用到page类
    private Page<Module> page=new Page<Module>();

    public Page<Module> getPage() {
        return page;
    }

    public void setPage(Page<Module> page) {
        this.page = page;
    }

    public String list() throws Exception{

        page = moduleService.findPage("from Module order by orderNo",this.page,Module.class,null);
        //得到的page需要压入栈顶,可以提取公用的方法
        //this.pushStack(page);"from Module", this.page, Module.class, null

        //设置分页的URL地址
        page.setUrl("moduleAction_list");
        //得到的page需要压入栈顶,可以提取公用的方法
        this.pushStack(page);
        return "list";
    }



    //通过id查询信息
    public String toview() throws Exception{
       // String id = (String) ServletActionContext.getRequest().getAttribute("id");
        model = moduleService.get(Module.class, model.getId());
        this.pushStack(model);
        return "view";

    }

    //跳转到添加页面的方法
    public  String  tocreate() throws Exception{
        //页面中有一个下拉框,需要查询所有的已经启用的部门信息
       // List<Module> Modules = ModuleService.find("from Module where state = 1", Module.class, null);
       // List<Dept> deptList = deptService.find("from Dept where state = 1",Dept.class, null);
        //把获得数据压入栈顶
        //ActionContext.getContext().put("ModuleList",Modules);
        /*this.pushContext("deptList",deptList);
        this.pushContext("ModuleList",Modules);*/

        return "tocreate";
    }
    //添加员工的方法
    public String insert() throws Exception{
        moduleService.saveOrUpdate(model);
        return  "reList";
    }

    //跳转到修改页面的方法
    public String toupdate() throws Exception{
        model = moduleService.get(Module.class, model.getId());
        this.pushStack(model);
        //List<Dept> deptList = deptService.find("from Dept where state = 1",Dept.class, null);
        //Modules.remove(model);
        //this.pushContext("deptList",deptList);

        return "toupdate";
    }

    //修改用户信息的方法
    public String update() throws Exception{
        //可以使用快照区来修改信息
        //System.out.println(model);
        moduleService.save(model);
        return "reList";
    }


    //从页面传过来的信息是string类型的,并且不是一个

    //删除
    public String delete() throws Exception{
       String[] ids = model.getId().split(",");
       //遍历删除
        for (String id : ids) {
            moduleService.deleteById(Module.class,id);

        }
               // ModuleService.delete(Module.class,ids);
      /*  //现在所有的id都封装到了String数组中
        ModuleService.delete(Module.class,ids);*/

        return "reList";
    }
}
