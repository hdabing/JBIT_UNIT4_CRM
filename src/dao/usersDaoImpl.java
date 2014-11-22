package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Users;

public class usersDaoImpl extends HibernateDaoSupport implements usersDao {
	
	@Override
	public void add(Users users) {
		this.getHibernateTemplate().save(users);
	}

	@Override
	public void del(int id) {
		Users users=this.getUsers(id);
		users.setIsdel(1);
		this.edit(users);
	}

	@Override
	public void edit(Users users) {
		this.getHibernateTemplate().update(users);
	}

	@Override
	public Users getUsers(int id) {
		String hql="From Users where id="+id;
		Query query=this.getSessionFactory().openSession().createQuery(hql);
		return (Users) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUserslist(String hql) {
		return (List<Users>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public Users getUsers(Users user) {
		String hql="From Users where username='"+user.getUsername()
				+"' and password='"+user.getPassword()+"'";
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Query query=session.createQuery(hql);
		return (Users) query.list().get(0);
	}

	/**
	 * 用于分页查询用户
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryListusers(String hql){
		Session session=this.getSession();
		return session.createQuery(hql).list();
	}
}
