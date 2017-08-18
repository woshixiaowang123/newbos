package com.bos.action;


import com.bos.domain.User;
import com.bos.utils.SysConstant;
import com.bos.utils.UtilFuns;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;



	//SSH传统登录方式
	public String login() throws Exception {
		
//		if(true){
//			String msg = "登录错误，请重新填写用户名密码!";
//			this.addActionError(msg);
//			throw new Exception(msg);
//		}
//		User user = new User(username, password);
//		User login = userService.login(user);
//		if (login != null) {
//			ActionContext.getContext().getValueStack().push(user);
//			session.put(SysConstant.CURRENT_USER_INFO, login);	//记录session
//			return SUCCESS;
//		}

//		return "login";
		Boolean b=UtilFuns.isEmpty(username);

		if(UtilFuns.isEmpty(username)&&UtilFuns.isEmpty(password)){
			request.put("errorInfo","对不起,用户名或者密码不能为空!");
			return "login";
		}


		try {
		//1,获得subject对象
		Subject subject= SecurityUtils.getSubject();

		//调用登陆方法
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		subject.login(token);//当走这一行代码是程序跳入authrealm方法的认证方法

			//登陆成功时从shiro中取得当前用户的信息
			User user= (User) subject.getPrincipal();
			//将用户存入session中
			//ServletActionContext.getRequest().getSession();
			session.put(SysConstant.CURRENT_USER_INFO,user);

		}catch (Exception e){
			e.printStackTrace();
			request.put("errorInfo","对不起,用户名或者密码错误!");
			return "login";

		}
		return "success";

	}
	
	
	//退出
	public String logout(){
		session.remove(SysConstant.CURRENT_USER_INFO);		//删除session
		
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

