package dao;

import java.util.List;

import entity.Relationship;

/**
 * 交往记录接口
 * @author 陈捷
 *
 */
public interface relationshipDao {
	/**
	 * 添加交往记录
	 * @param relationship 交往记录类型
	 */
	public void add(Relationship relationship);
	
	/**
	 * 删除交往记录
	 * @param id 交往记录id
	 */
	public void del(int id);
	
	/**
	 * 修改交往记录
	 * @param relationship 交往记录类型
	 */
	public void edit(Relationship relationship);
	
	/**
	 * 获取交往记录类型
	 * @param id 交往记录id
	 * @return 交往记录类型
	 */
	public Relationship getRelationship(int id);
	
	/**
	 * 获取交往记录类型列表
	 * @param hql Hibernate查询语句
	 * @return 交往记录类型列表
	 */
	public List<Relationship> getRelationshiplist(String hql);
}
