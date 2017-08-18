package com.bos.shiro;

import com.bos.utils.Encrypt;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Created by LaoWang on 2017/7/24.
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    //密码比较,token代表了页面输入的username与password,info代表从数据库查询的加密的username与password
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken token1= (UsernamePasswordToken) token;
        String username = token1.getUsername();

        //将用户输入的密码进行J加密
        char[] password = token1.getPassword();

        Object pwd = Encrypt.md5(new String(password), username);
        //取出数据库中加密后的密码
        Object credentials = info.getCredentials();
        return this.equals(credentials,pwd);
    }
}
