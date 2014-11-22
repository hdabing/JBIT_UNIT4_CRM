package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Chances;

public class chancesDaoImpl implements chancesDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Chances chances) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(chances);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getChances(id));
		tr.commit();
	}

	@Override
	public void edit(Chances chances) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(chances);
		tr.commit();
	}

	@Override
	public Chances getChances(int id) {
		Session session=sessionFactory.openSession();
		String hql="From Chances where id="+id;
		Query query=session.createQuery(hql);
		return (Chances) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chances> getChanceslist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		
		return (List<Chances>) query.list();
	}

	@Override
	public void successChances(int id) {
		Session session=sessionFactory.openSession();
		Chances chances=(Chances) session.get(Chances.class, id);
		Transaction tr=session.beginTransaction();
		chances.setState(3);
		tr.commit();
	}

	@Override
	public void failChances(int id) {
		Session session=sessionFactory.openSession();
		Chances chances=(Chances) session.get(Chances.class, id);
		Transaction tr=session.beginTransaction();
		chances.setState(4);
		tr.commit();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List queryForPage(String hql, int offset, int pagesize) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return query.list();
	}

	@Override
	public int getTotalResult(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		
		return query.list().size();
	}

}
