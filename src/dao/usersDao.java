package dao;

import java.util.List;

import entity.Users;

/**
 * 用户接口
 * @author 陈捷
 *
 */
public interface usersDao {
	
	/**
	 * 添加用户
	 * @param users 用户类型
	 */
	public void add(Users users);
	
	/**
	 * 删除用户
	 * @param id 用户id
	 */
	public void del(int id);
	
	/**
	 * 修改用户
	 * @param users 用户类型
	 */
	public void edit(Users users);
	
	/**
	 * 根据id获取用户
	 * @param id 用户id
	 * @return 用户类型
	 */
	public Users getUsers(int id);
	
	/**
	 * 根据用户名密码获取用户
	 * @param user 用户类型
	 * @return 用户类型
	 */
	public Users getUsers(Users user);
	
	/**
	 * 获取用户列表
	 * @param hql Hibernate查询语句
	 * @return List用户列表
	 */
	public List<Users> getUserslist(String hql);
}
