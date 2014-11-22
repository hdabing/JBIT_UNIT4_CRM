package dao;

import java.util.List;

import entity.Roleauthor;

/**
 * 角色权限接口
 * @author 陈捷
 *
 */
public interface roleauthorDao {
	/**
	 * 添加角色权限
	 * @param roleauthor 角色权限类型
	 */
	public void add(Roleauthor roleauthor);
	
	/**
	 * 删除角色权限
	 * @param id 角色权限id
	 */
	public void del(int id);
	
	/**
	 * 修改角色权限
	 * @param roleauthor 角色权限类型
	 */
	public void edit(Roleauthor roleauthor);
	
	/**
	 * 获取角色权限单条记录
	 * @param id 角色权限id
	 * @return 角色权限单条记录
	 */
	public Roleauthor getRoleauthor(int id);
	
	/**
	 * 获取角色权限列表
	 * @param hql Hibernate查询语句
	 * @return 角色权限列表
	 */
	public List<Roleauthor> getRoleauthorlist(String hql);
}
