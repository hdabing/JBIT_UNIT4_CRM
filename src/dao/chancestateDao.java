package dao;

import java.util.List;

import entity.Chancestate;

/**
 * 计划状态接口
 * @author 陈捷
 *
 */
public interface chancestateDao {
	
	/**
	 * 添加计划状态
	 * @param chancestate 计划状态类型
	 */
	public void add(Chancestate chancestate);
	
	/**
	 * 删除计划状态
	 * @param id 计划状态id
	 */
	public void del(int id);
	
	/**
	 * 修改计划状态
	 * @param chancestate 计划状态类型
	 */
	public void edit(Chancestate chancestate);
	
	/**
	 * 获取计划状态
	 * @param id 计划状态id
	 * @return
	 */
	public Chancestate getChancestate(int id);
	
	/**
	 * 获取计划状态列表
	 * @param hql Hibernate查询语句
	 * @return List计划状态列表
	 */
	public List<Chancestate> getChancestatelist(String hql);
	
}
