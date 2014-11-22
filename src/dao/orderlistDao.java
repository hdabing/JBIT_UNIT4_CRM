package dao;

import java.util.List;

import entity.Orderlist;

/**
 * 历史订单子表接口
 * @author 陈捷
 *
 */
public interface orderlistDao {
	/**
	 * 
	 * @param orderlist 订单
	 */
	public void add(Orderlist orderlist);
	
	/**
	 * 
	 * @param id
	 */
	public void del(int id);
	
	/**
	 * 
	 * @param orderlist
	 */
	public void edit(Orderlist orderlist);
	
	/**
	 * 获取订单列表子表类型
	 * @param id 订单列表子表id
	 * @return 订单列表子表类型
	 */
	public Orderlist getOrderlist(int id);
	
	/**
	 * 获取订单列表子表列表
	 * @param hql Hibernate查询语句
	 * @return List订单列表子表列表
	 */
	public List<Orderlist> getOrderlistlist(String hql);
}
