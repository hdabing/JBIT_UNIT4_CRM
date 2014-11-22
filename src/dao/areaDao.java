package dao;

import java.util.List;

import entity.Area;

/**
 * 地区接口
 * 
 * @author 陈捷
 * 
 */
public interface areaDao {
	/**
	 * 添加地区
	 * 
	 * @param Area 地区类型
	 */
	public void add(Area area);

	/**
	 * 删除地区
	 * 
	 * @param id 要删除的id号
	 */
	public void del(int id);

	/**
	 * 修改地区
	 * 
	 * @param Area 地区类型
	 */
	public void edit(Area area);

	/**
	 * 获取地区
	 * 
	 * @param id 地区的id号
	 * @return Area 地区类型
	 */
	public Area getArea(int id);

	/**
	 * 获取地区列表
	 * 
	 * @param hql Hibernate查询语句
	 * @return 地区列表
	 */
	public List<Area> getArealist(String hql);
}
