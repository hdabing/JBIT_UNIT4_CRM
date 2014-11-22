package dao;

import java.util.List;

import entity.Author;

/**
 * 权限接口
 * 
 * @author 陈捷
 * 
 */
public interface authorDao {
	/**
	 * 添加权限
	 * 
	 * @param author 权限类型
	 */
	public void add(Author author);

	/**
	 * 删除权限
	 * 
	 * @param id 指定要删除的权限id号
	 */
	public void del(int id);

	/**
	 * 修改权限
	 * 
	 * @param author 权限类型
	 * 
	 */
	public void edit(Author author);

	/**
	 * 获取权限类型
	 * 
	 * @param id 权限id号
	 * @return author权限类型
	 */
	public Author getAuthor(int id);

	/**
	 * 获取权限列表
	 * 
	 * @param hql Hibernate查询语句
	 * @return 权限类型列表
	 */
	public List<Author> getAuthorlist(String hql);
}
