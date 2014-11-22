package dao;

import java.util.List;

import entity.Product;

/**
 * 商品信息接口
 * @author 陈捷
 *
 */
public interface productDao {
	public void add(Product product);
	public void del(int id);
	public void edit(Product product);
	
	/**
	 * 获取商品信息
	 * @param id 商品id
	 * @return 商品信息类型
	 */
	public Product getProduct(int id);
	
	/**
	 * 获取商品信息列表
	 * @param hql Hibernate查询语句
	 * @return 商品信息列表
	 */
	public List<Product> getProductlist(String hql);
}
