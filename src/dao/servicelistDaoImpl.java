package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entity.Servicelist;

public class servicelistDaoImpl implements servicelistDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Servicelist servicelist) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(servicelist);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getServicelist(id));
		tr.commit();
	}

	@Override
	public void edit(Servicelist servicelist) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(servicelist);
		tr.commit();
	}

	@Override
	public Servicelist getServicelist(int id) {
		Session session=sessionFactory.openSession();
		String hql="From Servicelist where id="+id;
		Query query=session.createQuery(hql);
		return (Servicelist) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servicelist> getServicelistlist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Servicelist>) query.list();
	}

	
}
