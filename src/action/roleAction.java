package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.struts.ActionSupport;

import com.opensymphony.xwork2.ActionContext;

import service.roleService;
import utils.pageBean;
import entity.Role;
import entity.Roleauthor;

public class roleAction extends ActionSupport {
	private Role role;
	private roleService roleservice;
	private int id;
	private int page;
	private int pagesize;
	private pageBean pagebean;
	
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
	
	
	public roleService getRoleservice() {
		return roleservice;
	}

	public void setRoleservice(roleService roleservice) {
		this.roleservice = roleservice;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private roleService getRoleService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		return (roleService) ac.getBean("roleservice");
	}
	
	/**
	 * 设置request对象
	 * @param objectName
	 * @param obj
	 */
	private void setRequestAttribute(String objectName,Object obj){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute(objectName, obj);
	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 显示角色列表
	 * @return
	 */
	public String listRole() {
		this.setRequestAttribute("listrole", this.getRoleService().getRolelist());
		return "SUCCESS";
	}
	
	/**
	 * 删除角色
	 * @return
	 */
	public String delRole(){
		this.getRoleService().delRole(role.getId());
		return "SUCCESS";
	}
	
	/**
	 * 添加角色权限
	 * @return
	 */
	public String addRole(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listauthor",this.getRoleService().listAuthor());
		return "SUCCESS";
	}
	
	/**
	 * 确认添加角色
	 * @return
	 */
	public String addRoleOK(){
		roleservice=this.getRoleService();
		this.getRoleService().addRole(role);
		this.getRoleService().addRoleAuthorAll();
		int maxRoleid=roleservice.getMaxRoleId();
		HttpServletRequest request=ServletActionContext.getRequest();
		String[] authors=request.getParameterValues("author");
		if(authors!=null){
			for(int i=0;i<authors.length;i++){
				Roleauthor roleauthor=new Roleauthor();
				roleauthor.setRoleid(maxRoleid);
				roleauthor.setAuthorid(Integer.valueOf(authors[i]));
				roleservice.addRoleAuthorUpdate(roleauthor);
			}
		}
		
		return "SUCCESS";
	}
	
	/**
	 * 显示编辑权限界面
	 * @return
	 */
	public String editRole(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listroleauthor",this.getRoleService().listRoleauthor(id));
		return "SUCCESS";
	}
	
	public String editRoleOK(){
		roleservice=this.getRoleService();
		int roleid=role.getId();
		//超级管理员的权限不能修改
		if(roleid!=1){
			this.roleservice.editRole(role);
			HttpServletRequest request=ServletActionContext.getRequest();
			String[] authors=request.getParameterValues("author");
			
			//先把之前的权限清除，然后利用authors[]数组来读取有勾选的权限
			for(int i=1;i<=26;i++){
				Roleauthor roleauthor=new Roleauthor();
				roleauthor.setRoleid(roleid);
				roleauthor.setAuthorid(i);
				roleauthor.setIsdel(1);
				roleservice.updateRoleAuthor(roleauthor);
			}
			if(authors!=null){
				for(int i=0;i<authors.length;i++){
					Roleauthor roleauthor=new Roleauthor();
					roleauthor.setRoleid(roleid);
					roleauthor.setAuthorid(Integer.valueOf(authors[i]));
					roleauthor.setIsdel(0);
					roleservice.updateRoleAuthor(roleauthor);
				}
			}
		}
		return "SUCCESS";
	}
	
	/**
	 * 分页查询角色
	 * @return
	 */
	public String queryListrole(){
		this.init();
		String hql="From Role where isdel=0 order by id";
		pagebean=this.getRoleService().queryListrole(hql, page, pagesize);
		pagebean.setAction("queryListrole");
		this.setRequestAttribute("listrole", pagebean.getList());
		
		return "SUCCESS";
	}
	
	
	/**
	 * 根据查询条件查询角色
	 * @return
	 */
	public String queryRolebyform(){
		this.init();
		String hql="From Role where isdel=0 ";
		if(role.getName()!=null && role.getName().length()>0){
			hql+=" and name like '%"+role.getName()+"%' ";
		}
		if(role.getId()!=0){
			hql+=" and id="+role.getId();
		}
		role.setId(0);//清除roleid，避免污染
		hql+=" order by id";
		pagebean=this.getRoleService().queryListrole(hql, page, pagesize);
		pagebean.setAction("queryRolebyform");
		this.setRequestAttribute("listrole", pagebean.getList());
		
		return "SUCCESS";
	}
}
