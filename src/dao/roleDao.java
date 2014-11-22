package dao;

import java.util.List;

import entity.Role;

/**
 * 角色接口
 * @author 陈捷
 *
 */
public interface roleDao {
	/**
	 * 添加角色
	 * @param role 角色类型
	 */
	public void add(Role role);
	
	/**
	 * 删除角色
	 * @param id 角色id
	 */
	public void del(int id);
	
	/**
	 * 修改角色
	 * @param role 角色类型
	 */
	public void edit(Role role);
	
	/**
	 * 获取角色
	 * @param id 角色id
	 * @return 角色类型
	 */
	public Role getRole(int id);
	
	/**
	 * 获取角色列表
	 * @param hql Hibernate查询语句
	 * @return List角色列表
	 */
	public List<Role> getRolelist(String hql);
}
