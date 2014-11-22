package dao;

import java.util.List;

import entity.Customerlevel;

/**
 * 客户等级接口
 * @author 陈捷
 *
 */
public interface customerlevelDao {
	
	/**
	 * 添加客户等级
	 * @param customerlevel 客户等级类型
	 */
	public void add(Customerlevel customerlevel);
	
	/**
	 * 删除客户等级
	 * @param id 客户等级id
	 */
	public void del(int id);
	
	/**
	 * 修改客户等级表
	 * @param customerlevel 客户等级类型
	 */
	public void edit(Customerlevel customerlevel);
	
	/**
	 * 获取客户等级
	 * @param id 客户等级id
	 * @return 客户等级类型
	 */
	public Customerlevel getCustomerlevel(int id);
	
	/**
	 * 获取客户等级列表
	 * @param hql Hibernate查询语句
	 * @return List客户等级列表
	 */
	public List<Customerlevel> getCustomerlevellist(String hql);
}
