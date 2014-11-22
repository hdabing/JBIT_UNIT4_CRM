package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Customer;

public class customerDaoImpl implements customerDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customer);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getCustomer(id));
		tr.commit();
	}

	@Override
	public void edit(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(customer);
		tr.commit();
	}

	@Override
	public Customer getCustomer(int id) {
		Session session=sessionFactory.openSession();
		return (Customer) session.get(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerlist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Customer>) query.list();
	}

}
