package com.bos.action.sysadmin;

import com.bos.action.BaseAction;
import com.bos.domain.Dept;
import com.bos.domain.Module;
import com.bos.domain.Role;
import com.bos.domain.Role;
import com.bos.service.DeptService;
import com.bos.service.ModuleService;
import com.bos.service.RoleService;
import com.bos.utils.Page;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JsonConfig;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private ModuleService moduleService;


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

    //跳转到到权限分配页面
    public String tomodule(){
        //并通过id查询角色
        Role role = roleService.get(Role.class, model.getId());
        this.pushStack(role);
        List<Module> moduleList = moduleService.find("from Module", Module.class, null);
        this.pushContext("moduleList",moduleList);


        return "tomodule";
    }

    //json异步请求
   public void roleModuleJsonStr(){
        Role role = roleService.get(Role.class, model.getId());
        Set<Module> modules = role.getModules();



   /*     JsonConfig jsonConfig=new JsonConfig();
        String[] arr1=new String[]{"roles","remark","orderNo","createDept","createBy","parentName","updateTime","updateBy","createTime","quoteNum","cwhich","belong","cpermission","layerNum","ico","curl","ctype","state","isLeaf"};
        jsonConfig.setExcludes(arr1);
        //JSONArray jsonArray=JSONArray;
        JSONArray jsonArray =JSONArray.fromObject(modules,jsonConfig);


        String json=jsonArray.toString().replaceAll("parentId","pId");*/


        /////////

       List<Module> moduleList = moduleService.find("from Module", Module.class, null);
       int size = moduleList.size();

       StringBuilder sb = new StringBuilder();
       sb.append("[");

       for(Module module :moduleList){
           size--;
           sb.append("{\"id\":\"").append(module.getId());
           sb.append("\",\"pId\":\"").append(module.getParentId());
           sb.append("\",\"name\":\"").append(module.getName());
           sb.append("\",\"checked\":\"");
           if(modules.contains(module)){
               sb.append("true");
           }else{
               sb.append("false");
           }
           sb.append("\"}");

           if(size>0){
               sb.append(",");
           }
       }



       sb.append("]");

        ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
        try {
            ServletActionContext.getResponse().getWriter().print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 为了使用 zTree树，就要组织好zTree树所使用的json数据
     * json数据结构如下：
     * [{"id":"模块的id","pId":"父模块id","name":"模块名","checked":"true|false"},{"id":"模块的id","pId":"父模块id","name":"模块名","checked":"true|false"}]
     *
     * 常用的json插件有哪些？
     * json-lib    fastjson     struts-json-plugin-xxx.jar,手动拼接
     *
     * 如何输出?
     * 借助于response对象输出数据
     */
   /* public String roleModuleJsonStr() throws Exception{
        //1.根据角色id,得到角色对象
        Role role = roleService.get(Role.class, model.getId());

        //2.通过对象导航方式，加载出当前角色的模块列表
        Set<Module> moduleSet = role.getModules();

        //3.加载出所有的模块列表
        List<Module> moduleList = moduleService.find("from Module", Module.class, null);
        int size=moduleList.size();
        //4.组织json串
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(Module module :moduleList){
            size--;
            sb.append("{\"id\":\"").append(module.getId());
            sb.append("\",\"pId\":\"").append(module.getParentId());
            sb.append("\",\"name\":\"").append(module.getName());
            sb.append("\",\"checked\":\"");
            if(moduleSet.contains(module)){
                sb.append("true");
            }else{
                sb.append("false");
            }
            sb.append("\"}");

            if(size>0){
                sb.append(",");
            }
        }



        sb.append("]");

        //5.得到response对象
        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        //6.使用 response对象输出json串
        response.getWriter().write(sb.toString());
        //7.返回NONE
        return NONE;

    }*/

   private String moduleIds;

    public void setModuleIds(String moduleIds) {
        this.moduleIds = moduleIds;
    }

    //保存修改的权限
    public String module(){
        String[] split = moduleIds.split(",");
       roleService.change(split,model.getId());

        return "reList";
    }
}
