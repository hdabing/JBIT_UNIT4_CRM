package dao;

import java.util.List;

import entity.Customerlost;

/**
 * 客户流失接口
 * @author 陈捷
 *
 */
public interface customerlostDao {
	/**
	 * 添加客户流失信息
	 * @param customerlost 客户流失类型
	 */
	public void add(Customerlost customerlost);
	
	/**
	 * 删除客户流失信息
	 * @param id 客户流失信息id
	 */
	public void del(int id);
	
	/**
	 * 修改客户流失信息
	 * @param customerlost 客户流失类型
	 */
	public void edit(Customerlost customerlost);
	
	/**
	 * 获取客户流失类型
	 * @param id 客户流失id
	 * @return 客户流失类型
	 */
	public Customerlost getCustomerlost(int id);
	
	/**
	 * 获取客户流失列表
	 * @param hql Hibernate查询语句
	 * @return List客户流失列表
	 */
	public List<Customerlost> getCustomerlostlist(String hql);
}
