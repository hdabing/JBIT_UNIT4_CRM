package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Orderlist;

public class orderlistDaoImpl implements orderlistDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Orderlist orderlist) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(orderlist);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getOrderlist(id));
		tr.commit();
	}

	@Override
	public void edit(Orderlist orderlist) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(orderlist);
		tr.commit();
	}

	@Override
	public Orderlist getOrderlist(int id) {
		Session session=sessionFactory.openSession();
		return (Orderlist) session.get(Orderlist.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orderlist> getOrderlistlist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Orderlist>) query.list();
	}

}
