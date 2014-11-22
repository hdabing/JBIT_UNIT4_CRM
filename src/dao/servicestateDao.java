package dao;

import java.util.List;

import entity.Servicestate;

/**
 * 服务状态接口
 * @author Administrator
 *
 */
public interface servicestateDao {
	/**
	 * 添加服务状态
	 * @param servicestate 服务状态类型
	 */
	public void add(Servicestate servicestate);
	
	/**
	 * 删除服务状态
	 * @param id 服务状态id
	 */
	public void del(int id);
	
	/**
	 * 修改服务状态
	 * @param servicestate 服务状态类型
	 */
	public void edit(Servicestate servicestate);
	
	/**
	 * 获取服务状态
	 * @param id 服务状态id
	 * @return 服务状态类型
	 */
	public Servicestate getServicestate(int id);
	
	/**
	 * 获取服务状态列表
	 * @param hql Hibernate查询语句
	 * @return List服务状态列表
	 */
	public List<Servicestate> getServicestatelist(String hql);
}
