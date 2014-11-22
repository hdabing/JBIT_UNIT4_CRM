package dao;

import java.util.List;

import entity.Service;

/**
 * 服务类型接口
 * @author 陈捷
 *
 */
public interface serviceDao {
	/**
	 * 添加服务类型
	 * @param service 服务类型
	 */
	public void add(Service service);
	
	/**
	 * 删除服务类型
	 * @param id 服务id
	 */
	public void del(int id);
	
	/**
	 * 修改服务类型
	 * @param service 服务类型
	 */
	public void edit(Service service);
	
	/**
	 * 获取服务类型单条记录
	 * @param id 服务id
	 * @return 服务类型单条记录
	 */
	public Service getService(int id);
	
	/**
	 * 获取服务类型列表
	 * @param hql Hibernate查询语句
	 * @return LIst服务类型列表
	 */
	public List<Service> getServicelist(String hql);
}
