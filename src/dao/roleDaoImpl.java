package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entity.Role;

public class roleDaoImpl implements roleDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Role role) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(role);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Role role=this.getRole(id);
		role.setIsdel(1);
		this.edit(role);
	}

	@Override
	public void edit(Role role) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(role);
		tr.commit();
	}

	@Override
	public Role getRole(int id) {
		String hql="From Role where id="+id;
		return (Role) this.getRolelist(hql).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRolelist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Role>) query.list();
	}

	/**
	 * 用于分页查询角色
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryListrole(String hql){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return query.list();
	}
}
