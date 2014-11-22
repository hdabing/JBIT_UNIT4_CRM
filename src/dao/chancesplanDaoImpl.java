package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Chancesplan;

public class chancesplanDaoImpl implements chancesplanDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Chancesplan chancesplan) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(chancesplan);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getChancesplan(id));
		tr.commit();
	}

	@Override
	public void edit(Chancesplan chancesplan) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(chancesplan);
		tr.commit();
	}

	@Override
	public Chancesplan getChancesplan(int id) {
		Session session=sessionFactory.openSession();
		return (Chancesplan) session.get(Chancesplan.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chancesplan> getChancesplanlist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		
		return (List<Chancesplan>) query.list();
	}

}
