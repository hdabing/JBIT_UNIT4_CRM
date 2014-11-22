package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Orders;

public class ordersDaoImpl implements ordersDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Orders orders) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(orders);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getOrders(id));
		tr.commit();
	}

	@Override
	public void edit(Orders orders) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(orders);
		tr.commit();
	}

	@Override
	public Orders getOrders(int id) {
		Session session=sessionFactory.openSession();
		String hql="From Orders where id="+id;
		Query query=session.createQuery(hql);
		return (Orders) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrderslist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Orders>) query.list();
	}

	/**
	 * 查询订单总额
	 * @return List类型的客户购买金额汇总数组
	 */
	@SuppressWarnings("rawtypes")
	public List queryOrdersAmount(){
		Session session=sessionFactory.openSession();
		String hql="select b.name,sum(amount) from orders a left join customer b on a.customerid=b.id group by b.name";
		return session.createSQLQuery(hql).list();
	}
	
	/**
	 * 查询订单总额
	 * @return List类型的客户购买金额汇总数组
	 */
	@SuppressWarnings("rawtypes")
	public List queryOrdersAmount(String hql){
		Session session=sessionFactory.openSession();
		return session.createSQLQuery(hql).list();
	}
}
