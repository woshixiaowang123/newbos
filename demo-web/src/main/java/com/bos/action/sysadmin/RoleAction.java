package com.bos.action.sysadmin;

import com.bos.action.BaseAction;
import com.bos.domain.Dept;
import com.bos.domain.Role;
import com.bos.domain.Role;
import com.bos.service.DeptService;
import com.bos.service.RoleService;
import com.bos.utils.Page;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * RoleAction
 * Created by 隔壁老王 on 2017/7/11.
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction implements ModelDriven<Role> {
    @Autowired
    private RoleService roleService;

    @Autowired
    private DeptService deptService;


    private Role model=new Role();

    @Override
    public Role getModel() {
        return model;
    }
//分页查询需要用到page类
    private Page<Role> page=new Page<Role>();

    public Page<Role> getPage() {
        return page;
    }

    public void setPage(Page<Role> page) {
        this.page = page;
    }

    public String list() throws Exception{

        page = roleService.findPage("from Role order by orderNo",this.page,Role.class,null);
        //得到的page需要压入栈顶,可以提取公用的方法
        //this.pushStack(page);"from Role", this.page, Role.class, null

        //设置分页的URL地址
        page.setUrl("roleAction_list");
        //得到的page需要压入栈顶,可以提取公用的方法
        this.pushStack(page);
        return "list";
    }



    //通过id查询信息
    public String toview() throws Exception{
       // String id = (String) ServletActionContext.getRequest().getAttribute("id");
        model = roleService.get(Role.class, model.getId());
        this.pushStack(model);
        return "view";

    }

    //跳转到添加页面的方法
    public  String  tocreate() throws Exception{
        //页面中有一个下拉框,需要查询所有的已经启用的部门信息
       // List<Role> Roles = roleService.find("from Role where state = 1", Role.class, null);
       // List<Dept> deptList = deptService.find("from Dept where state = 1",Dept.class, null);
        //把获得数据压入栈顶
        //ActionContext.getContext().put("RoleList",Roles);
        /*this.pushContext("deptList",deptList);
        this.pushContext("roleList",Roles);*/

        return "tocreate";
    }
    //添加员工的方法
    public String insert() throws Exception{
        roleService.saveOrUpdate(model);
        return  "reList";
    }

    //跳转到修改页面的方法
    public String toupdate() throws Exception{
        model = roleService.get(Role.class, model.getId());
        this.pushStack(model);
        //List<Dept> deptList = deptService.find("from Dept where state = 1",Dept.class, null);
        //Roles.remove(model);
        //this.pushContext("deptList",deptList);

        return "toupdate";
    }

    //修改用户信息的方法
    public String update() throws Exception{
        //可以使用快照区来修改信息
        //System.out.println(model);
        roleService.save(model);
        return "reList";
    }


    //从页面传过来的信息是string类型的,并且不是一个

    //删除
    public String delete() throws Exception{
       String[] ids = model.getId().split(",");
       //遍历删除
        for (String id : ids) {
            roleService.deleteById(Role.class,id);

        }
               // RoleService.delete(Role.class,ids);
      /*  //现在所有的id都封装到了String数组中
        RoleService.delete(Role.class,ids);*/

        return "reList";
    }
}
