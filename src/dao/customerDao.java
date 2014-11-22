package dao;

import java.util.List;

import entity.Customer;

/**
 * 客户接口
 * @author 陈捷
 *
 */
public interface customerDao {
	/**
	 * 添加客户
	 * @param customer 客户类型
	 */
	public void add(Customer customer);
	
	/**
	 * 删除客户
	 * @param id 指定要删除的客户id
	 */
	public void del(int id);
	
	/**
	 * 修改客户
	 * @param customer 客户类型
	 */
	public void edit(Customer customer);
	
	/**
	 * 获取客户
	 * @param id 客户id
	 * @return 客户类型
	 */
	public Customer getCustomer(int id);
	
	/**
	 * 获取客户列表
	 * @param hql Hibernate查询语句
	 * @return List客户列表
	 */
	public List<Customer> getCustomerlist(String hql);
}
