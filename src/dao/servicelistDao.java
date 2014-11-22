package dao;

import java.util.List;

import entity.Servicelist;

/**
 * 服务明细接口
 * @author 陈捷
 *
 */
public interface servicelistDao {
	/**
	 * 添加服务明细
	 * @param servicelist 服务明细类型
	 */
	public void add(Servicelist servicelist);
	
	/**
	 * 删除服务明细
	 * @param id 服务明细id
	 */
	public void del(int id);
	
	/**
	 * 修改服务明细
	 * @param servicelist 服务明细类型
	 */
	public void edit(Servicelist servicelist);
	
	/**
	 * 获取服务明细单条记录
	 * @param id 服务明细id
	 * @return 服务明细单条记录
	 */
	public Servicelist getServicelist(int id);
	
	/**
	 * 获取服务明细列表
	 * @param hql Hibernate查询语句
	 * @return 服务明细列表
	 */
	public List<Servicelist> getServicelistlist(String hql);
}
