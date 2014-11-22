package dao;

import java.util.List;

import entity.Chancesplan;

/**
 * 销售计划接口
 * @author 陈捷
 *
 */
public interface chancesplanDao {
	/**
	 * 添加销售计划
	 * @param chancesplan 销售计划类型
	 */
	public void add(Chancesplan chancesplan);
	/**
	 * 删除销售计划
	 * @param id 销售计划id
	 */
	public void del(int id);
	/**
	 * 修改销售计划
	 * @param chancesplan 销售计划类型
	 */
	public void edit(Chancesplan chancesplan);
	/**
	 * 获取销售计划类型
	 * @param id 销售计划id
	 * @return 销售计划类型
	 */
	public Chancesplan getChancesplan(int id);
	/**
	 * 获取销售计划列表
	 * @param hql Hibernate查询语句
	 * @return 销售计划列表
	 */
	public List<Chancesplan> getChancesplanlist(String hql);
}
