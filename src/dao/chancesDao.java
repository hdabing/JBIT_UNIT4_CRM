package dao;

import java.util.List;

import entity.Chances;

/**
 * 销售机会接口
 * @author 陈捷
 *
 */
public interface chancesDao {
	/**
	 * 添加销售机会
	 * @param chances 销售机会类型
	 */
	public void add(Chances chances);
	/**
	 * 删除销售机会
	 * @param id 销售机会id
	 */
	public void del(int id);
	/**
	 * 修改销售机会
	 * @param chances 销售机会类型
	 */
	public void edit(Chances chances);
	
	/**
	 * 获取销售机会类型
	 * @param id 销售机会id
	 * @return 销售机会类型
	 */
	public Chances getChances(int id);
	/**
	 * 获取销售机会列表
	 * @param hql Hibernate查询语句
	 * @return 销售机会列表
	 */
	public List<Chances> getChanceslist(String hql);
	
	/**
	 * 开发成功
	 * @param id
	 */
	public void successChances(int id);
	
	/**
	 * 开发失败
	 * @param id
	 */
	public void failChances(int id);
	
	/**
	 * 分页查找
	 * @param hql Hibernate查询语句
	 * @param offiset 当前记录位置
	 * @param pagesize 分页大小
	 * @return 按分页大小查找出来的记录集
	 */
	@SuppressWarnings("rawtypes")
	public List queryForPage(String hql,int offset,int pagesize);
	
	/**
	 * 获取总记录数
	 * @param hql
	 * @return
	 */
	public int getTotalResult(String hql);
	
	
}
