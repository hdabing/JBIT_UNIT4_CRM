package service;

import java.util.List;

import utils.pageBean;

import dao.authorDaoImpl;
import dao.roleDaoImpl;
import dao.roleauthorDaoImpl;
import entity.Author;
import entity.Role;
import entity.Roleauthor;

public class roleService {
	private roleDaoImpl roledaoimpl;
	private authorDaoImpl authordaoimpl;
	private roleauthorDaoImpl roleauthordaoimpl;
	
	
	public roleauthorDaoImpl getRoleauthordaoimpl() {
		return roleauthordaoimpl;
	}

	public void setRoleauthordaoimpl(roleauthorDaoImpl roleauthordaoimpl) {
		this.roleauthordaoimpl = roleauthordaoimpl;
	}

	public authorDaoImpl getAuthordaoimpl() {
		return authordaoimpl;
	}

	public void setAuthordaoimpl(authorDaoImpl authordaoimpl) {
		this.authordaoimpl = authordaoimpl;
	}

	public roleDaoImpl getRoledaoimpl() {
		return roledaoimpl;
	}

	public void setRoledaoimpl(roleDaoImpl roledaoimpl) {
		this.roledaoimpl = roledaoimpl;
	}

	/**
	 * 获取角色列表
	 * @return 角色列表
	 */
	public List<Role> getRolelist(){
		String hql="From Role where isdel=0 order by id";
		return (List<Role>) roledaoimpl.getRolelist(hql);
	}
	
	/**
	 * 根据id获取角色类
	 * @param id 角色id
	 * @return 角色类型
	 */
	public Role getRole(int id){
		return (Role) roledaoimpl.getRole(id);
	}
	
	/**
	 * 删除角色
	 * @param id 角色id
	 */
	public void delRole(int id){
		roledaoimpl.del(id);
	}
	
	/**
	 * 获取权限列表
	 * @return
	 */
	public List<Author> listAuthor(){
		String hql="From Author order by id";
		return authordaoimpl.getAuthorlist(hql);
	}
	
	/**
	 * 添加角色
	 * @param role
	 */
	public void addRole(Role role){
		role.setIsdel(0);
		roledaoimpl.add(role);
	}
	
	/**
	 * 修改角色
	 * @param role
	 */
	public void editRole(Role role){
		role.setIsdel(0);
		roledaoimpl.edit(role);
	}
	/**
	 * 初始化添加角色权限，批量添加角色权限到角色权限表
	 */
	public void addRoleAuthorAll(){
		String hql="From Role where id in(select max(id) from Role)";
		Role role=roledaoimpl.getRolelist(hql).get(0);
		
		for(int i=1;i<=26;i++){
			Roleauthor roleauthor=new Roleauthor();
			roleauthor.setRoleid(role.getId());
			roleauthor.setAuthorid(i);
			roleauthor.setIsdel(1);
			roleauthordaoimpl.add(roleauthor);
		}
	}
	
	/**
	 * 初始化角色权限后，修改权限isdel
	 */
	public void addRoleAuthorUpdate(Roleauthor roleauthor){
		roleauthordaoimpl.updateRoleauthor(roleauthor);
	}
	
	/**
	 * 修改角色权限
	 * @param roleauthor
	 */
	public void updateRoleAuthor(Roleauthor roleauthor){
		Roleauthor tmproleauthor=roleauthordaoimpl.getRoleauthor(roleauthor.getRoleid(), roleauthor.getAuthorid());
		tmproleauthor.setIsdel(roleauthor.getIsdel());
		roleauthordaoimpl.edit(tmproleauthor);
	}
	
	/**
	 * 获取新增的角色id
	 * @return
	 */
	public int getMaxRoleId(){
		String hql="From Role where id in(select max(id) from Role)";
		Role role=roledaoimpl.getRolelist(hql).get(0);
		return role.getId();
	}
	
	public List<Roleauthor> listRoleauthor(int id){
		String hql="From Roleauthor where roleid="+id+" order by authorid";
		return roleauthordaoimpl.getRoleauthorlist(hql);
	}
	
	/**
	 * 分页查询角色信息
	 * @param hql
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public pageBean queryListrole(String hql,int currentPage,int pageSize){
		List list=roledaoimpl.queryListrole(hql);
		int totalResult=list.size();
		int totalPage=pageBean.getTotalPage(pageSize, totalResult);
		currentPage=pageBean.getCurrentPage(currentPage);
		
		pageBean pagebean=new pageBean();
		pagebean.setTotalPage(totalPage);
		pagebean.setTotalResult(totalResult);
		pagebean.setPageSize(pageSize);
		pagebean.setCurrentPage(currentPage);
		pagebean.init();
		pagebean.setList(pagebean.getAnyResult(list));
		
		return pagebean;
	}
}
