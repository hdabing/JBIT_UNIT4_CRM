package dao;

import java.util.List;

import entity.Orders;

/**
 * 历史订单接口
 * @author 陈捷
 *
 */
public interface ordersDao {
	public void add(Orders orders);
	public void del(int id);
	public void edit(Orders orders);
	
	/**
	 * 获取历史订单主表
	 * @param id 历史订单主表id
	 * @return 历史订单类型
	 */
	public Orders getOrders(int id);
	
	/**
	 * 获取历史订单主表列表
	 * @param hql Hibernate查询语句
	 * @return List历史订单主表列表
	 */
	public List<Orders> getOrderslist(String hql);
}
