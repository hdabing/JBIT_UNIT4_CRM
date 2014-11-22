package dao;

import java.util.List;

import entity.Customercontact;

/**
 * 客户联系人接口
 * @author 陈捷
 *
 */
public interface customercontactDao {
	/**
	 * 添加客户联系人
	 * @param customercontact 客户联系人类型
	 */
	public void add(Customercontact customercontact);
	
	/**
	 * 删除客户联系人 
	 * @param id 客户联系人id
	 */
	public void del(int id);
	
	/**
	 * 修改客户联系人
	 * @param customercontact 客户联系人类型
	 */
	public void edit(Customercontact customercontact);
	
	/**
	 * 获取客户联系人
	 * @param id 客户联系人id
	 * @return 客户联系人类型
	 */
	public Customercontact getCustomercontact(int id);
	
	/**
	 * 获取客户联系人列表
	 * @param hql Hibernate查询语句
	 * @return List客户联系人列表
	 */
	public List<Customercontact> getCustomercontactlist(String hql);
}
