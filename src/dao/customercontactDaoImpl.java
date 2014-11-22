package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Customercontact;

public class customercontactDaoImpl implements customercontactDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Customercontact customercontact) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customercontact);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Customercontact customercontact=this.getCustomercontact(id);
		customercontact.setIsdel(1);
		session.update(customercontact);
		tr.commit();
	}

	@Override
	public void edit(Customercontact customercontact) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(customercontact);
		tr.commit();
	}

	@Override
	public Customercontact getCustomercontact(int id) {
		Session session=sessionFactory.openSession();
		return (Customercontact) session.get(Customercontact.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customercontact> getCustomercontactlist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Customercontact>) query.list();
	}

}
