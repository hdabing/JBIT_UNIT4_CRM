package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import service.roleService;
import service.userService;
import utils.pageBean;

import com.opensymphony.xwork2.ActionContext;

import entity.Role;
import entity.Roleauthor;
import entity.Users;

/**
 * 用户动作类
 * @author 陈捷
 *
 */
public class usersAction extends ActionSupport{
	private Users user;
	private Users formuser;
	public roleService roleservice;
	private int page;
	private int pagesize;
	private pageBean pagebean;
	public String uname;
	public int uid;
	
	/**
	 * 初始化分页信息
	 */
	public void init(){
		if(ActionContext.getContext().getSession().get("pagesize")==null){
			ActionContext.getContext().getSession().put("pagesize", 5);
		}
		if(pagesize!=0){
			ActionContext.getContext().getSession().put("pagesize", pagesize);
		}
		pagesize=(Integer) ActionContext.getContext().getSession().get("pagesize");
	}
	
	public Users getFormuser() {
		return formuser;
	}

	public void setFormuser(Users formuser) {
		this.formuser = formuser;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public pageBean getPagebean() {
		return pagebean;
	}

	public void setPagebean(pageBean pagebean) {
		this.pagebean = pagebean;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	private userService getUserService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		return (userService) ac.getBean("userservice");
	}
	
	private roleService getRoleService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		return (roleService) ac.getBean("roleservice");
	}
	
	private void setRequestAttribute(String objectName,Object obj){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute(objectName, obj);
	}
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	/**
	 * 检测登录
	 * @return 成功返回SUCCESS,否则返回INPUT
	 */
	public String login(){
		
		userService userservice=this.getUserService();
		if(userservice.checkLogin(user)){
			user=userservice.getUser(user);
			List<Roleauthor> listroleauthor=this.getRoleService().listRoleauthor(user.getRoleid());
			ActionContext.getContext().getSession().put("user", user);
			ActionContext.getContext().getSession().put("role", user.getRole());
			ActionContext.getContext().getSession().put("pagesize", 5);//初始化分页大小
			ActionContext.getContext().getSession().put("listroleauthor", listroleauthor);
			//将角色的权限值转换为json格式的字符串，然后传递给客户端
			String str_json=this.getUserService().RoleauthorToJSON(listroleauthor);
			ActionContext.getContext().getSession().put("str_json", str_json);
			return "SUCCESS";
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("ERROR", "登录验证失败，请重新登录！");
		return "INPUT";
	}
	
	/**
	 * 用户列表
	 */
	public String listUser(){
		userService userservice=this.getUserService();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listusers", userservice.getUserslist());
		return "SUCCESS";
	}
	
	/**
	 * 添加用户页面
	 */
	public String addUser(){
		this.setRequestAttribute("listrole", (List<Role>) this.getRoleService().getRolelist());
		return "SUCCESS";
	}
	
	/**
	 * 添加用户
	 */
	public String addUserOK(){
		this.getUserService().addUser(user);
		return "SUCCESS";
	}
	
	/**
	 * 删除用户
	 */
	public String delUser(){
		//超级管理员不能删除 
		if(user.getId()!=1){
			this.getUserService().delUser(user.getId());
		}
		return "SUCCESS";
	}
	
	/**
	 * 修改用户页面 
	 */
	public String editUser(){
		this.setRequestAttribute("user", this.getUserService().getUser(user.getId()));
		this.setRequestAttribute("listrole", this.getRoleService().getRolelist());
		return "SUCCESS";
	}
	
	/**
	 * 修改用户
	 */
	public String editUserOK(){
		Users tmpuser=(Users) ServletActionContext.getContext().getSession().get("user");
		//只有超级管理员才能修改自己的密码
		if(tmpuser!=null){
			if(user.getId()==1){
				if(tmpuser.getId()==user.getId()){
					user.setRoleid(1);
					this.getUserService().editUser(user);
				}
			}else{
				this.getUserService().editUser(user);
			}
		}
		
		return "SUCCESS";
	}
	
	/**
	 * 用户列表
	 */
	public String queryListusers(){
		this.init();
		userService userservice=this.getUserService();
		String hql="From Users where isdel=0 order by id";
		pagebean=userservice.queryListusers(hql, page, pagesize);
		pagebean.setAction("queryListusers");
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listusers",pagebean.getList());
		
		return "SUCCESS";
	}
	
	/**
	 * 查询用户
	 * @return
	 */
	public String queryUsersbyform(){
		this.init();
		String hql="From Users where isdel=0 ";
		
		if(uname!=null && uname.length()>0){
			ServletActionContext.getContext().getSession().put("uname", uname);
			hql+=" and username like '%"+uname+"%' ";
		}else if(ServletActionContext.getContext().getSession().get("uname")!=null){
			hql+=" and username like '%"+ServletActionContext.getContext().getSession().get("uname")+"%'";
		}
		
		if(uid!=0){
			hql+=" and id="+uid;
		}

		uid=0;//清除id信息，避免二次污染
		userService userservice=this.getUserService();
		pagebean=userservice.queryListusers(hql, page, pagesize);
		pagebean.setAction("queryUsersbyform");
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listusers",pagebean.getList());
		
		return "SUCCESS";
	}
	
	/**
	 * 用户注销
	 * @return
	 */
	public String logOut(){
		ActionContext.getContext().getSession().remove("user");
		
		return "SUCCESS";
	}
	
}
