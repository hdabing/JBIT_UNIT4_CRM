package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Chancestate;

public class chancestateDaoImpl implements chancestateDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Chancestate chancestate) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(chancestate);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getChancestate(id));
		tr.commit();
	}

	@Override
	public void edit(Chancestate chancestate) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(chancestate);
		tr.commit();
	}

	@Override
	public Chancestate getChancestate(int id) {
		Session session=sessionFactory.openSession();
		return (Chancestate) session.get(Chancestate.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chancestate> getChancestatelist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Chancestate>) query.list();
	}

}
