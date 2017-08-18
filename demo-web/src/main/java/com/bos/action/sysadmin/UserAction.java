package com.bos.action.sysadmin;

import com.bos.action.BaseAction;
import com.bos.domain.Dept;
import com.bos.domain.Role;
import com.bos.domain.User;
import com.bos.service.DeptService;
import com.bos.service.RoleService;
import com.bos.service.UserService;
import com.bos.service.UserService;
import com.bos.utils.Page;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 * UserAction
 * Created by 隔壁老王 on 2017/7/11.
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction implements ModelDriven<User> {
    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private RoleService roleService;


    private User model=new User();

    @Override
    public User getModel() {
        return model;
    }
//分页查询需要用到page类
    private Page<User> page=new Page<User>();

    public Page<User> getPage() {
        return page;
    }

    public void setPage(Page<User> page) {
        this.page = page;
    }

    public String list() throws Exception{

        page = userService.findPage("from User",this.page,User.class,null);
        //得到的page需要压入栈顶,可以提取公用的方法
        //this.pushStack(page);"from User", this.page, User.class, null

        //设置分页的URL地址
        page.setUrl("userAction_list");
        //得到的page需要压入栈顶,可以提取公用的方法
        this.pushStack(page);
        return "list";
    }



    //通过id查询信息
    public String toview() throws Exception{
       // String id = (String) ServletActionContext.getRequest().getAttribute("id");
        model = userService.get(User.class, model.getId());
        this.pushStack(model);
        return "view";

    }

    //跳转到添加页面的方法
    public  String  tocreate() throws Exception{
        //页面中有一个下拉框,需要查询所有的已经启用的部门信息
        List<User> users = userService.find("from User where state = 1", User.class, null);
        List<Dept> deptList = deptService.find("from Dept where state = 1",Dept.class, null);
        //把获得数据压入栈顶
        //ActionContext.getContext().put("UserList",Users);
        this.pushContext("deptList",deptList);
        this.pushContext("userList",users);

        return "tocreate";
    }
    //添加员工的方法
    public String insert() throws Exception{
        userService.saveOrUpdate(model);
        return  "reList";
    }

    //跳转到修改页面的方法
    public String toupdate() throws Exception{
        model = userService.get(User.class, model.getId());
        this.pushStack(model);
        List<Dept> deptList = deptService.find("from Dept where state = 1",Dept.class, null);
        //Users.remove(model);
        this.pushContext("deptList",deptList);

        return "toupdate";
    }

    //修改用户信息的方法
    public String update() throws Exception{
        //可以使用快照区来修改信息
        //System.out.println(model);
        userService.save(model);
        return "reList";
    }


    //从页面传过来的信息是string类型的,并且不是一个

    //删除
    public String delete() throws Exception{
       String[] ids = model.getId().split(",");
       //遍历删除
        for (String id : ids) {
            userService.deleteById(User.class,id);

        }
               // UserService.delete(User.class,ids);
      /*  //现在所有的id都封装到了String数组中
        UserService.delete(User.class,ids);*/

        return "reList";
    }


    //分配角色
    public String torole() throws Exception{

        //需要查询出所有的角色
        List<Role> roleList = roleService.find("from Role order by orderNo", Role.class, null);
        //把list压入栈顶
        this.pushContext("roleList",roleList);
        User user = userService.get(User.class, model.getId());
        this.pushStack(user);
        StringBuilder stringBuilder=new StringBuilder();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            stringBuilder.append(role.getName()).append(",");
        }
        //把stringbuilder压入栈顶
        this.pushContext("userRoleStr",stringBuilder.toString());


        return "torole";
    }
        private String[] roleIds;

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    //增加用户的角色
    public String role(){
        userService.addRole(model.getId(),roleIds);
        return "reList";
    }
}
