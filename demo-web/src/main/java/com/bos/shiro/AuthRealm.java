package com.bos.shiro;

import com.bos.domain.Module;
import com.bos.domain.Role;
import com.bos.domain.User;
import com.bos.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.struts2.components.If;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by LaoWang on 2017/7/24.
 */
public class AuthRealm extends AuthorizingRealm{

@Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        User user= (User) pc.fromRealm(this.getName()).iterator().next();//根据realm的名称查找对应的realm
        Set<Role> roles = user.getRoles();//获得对应用户的角色
        List<String> list= new ArrayList<String>();
        for (Role role : roles) {
            //遍历角色
            Set<Module> modules = role.getModules();//获得对应的权限
            for (Module module : modules) {
                    list.add(module.getName());
            }
        }

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(list);
        return info;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //首先从数据库中查询

        //比较
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String username = token1.getUsername();
        //从数据库中查询
        if(username!=null){
            String hql= "from User where userName = ?";
            List<User> users = userService.find(hql,User.class, new String[]{username});
            if (users!=null && users.size()>0) {
                User user = users.get(0);
                AuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
                return info;//此时返回后就立即进去比较器进行比较
            }
        }


        return null;
    }
}
