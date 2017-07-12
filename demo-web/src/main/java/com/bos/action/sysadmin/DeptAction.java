package com.bos.action.sysadmin;

import com.bos.action.BaseAction;
import com.bos.domain.Dept;
import com.bos.service.DeptService;
import com.bos.utils.Page;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * deptAction
 * Created by 隔壁老王 on 2017/7/11.
 */
@Controller
@Scope("prototype")
public class DeptAction extends BaseAction implements ModelDriven<Dept> {
    @Autowired
    private  DeptService deptService;


    private Dept dept=new Dept();

    @Override
    public Dept getModel() {
        return dept;
    }
//分页查询需要用到page类
    private Page<Dept> page=new Page<Dept>();

    public Page<Dept> getPage() {
        return page;
    }

    public void setPage(Page<Dept> page) {
        this.page = page;
    }

    public String list(){

        page = deptService.findPage("from Dept", this.page, Dept.class, null);
        //得到的page需要压入栈顶,可以提取公用的方法
        this.pushStack(page);

        //设置分页的URL地址
        page.setUrl("deptAction_list");
        return "list";
    }
}
