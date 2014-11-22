package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entity.Customerlost;

public class customerlostDaoImpl implements customerlostDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Customerlost customerlost) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customerlost);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getCustomerlost(id));
		tr.commit();
	}

	@Override
	public void edit(Customerlost customerlost) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(customerlost);
		tr.commit();
	}

	@Override
	public Customerlost getCustomerlost(int id) {
		Session session=sessionFactory.openSession();
		String hql="From Customerlost where id="+id;
		Query query=session.createQuery(hql);
		return (Customerlost) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customerlost> getCustomerlostlist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Customerlost>) query.list();
	}

}
