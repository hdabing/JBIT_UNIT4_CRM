package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Product;

public class productDaoImpl implements productDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(product);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getProduct(id));
		tr.commit();
	}

	@Override
	public void edit(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(product);
		tr.commit();
	}

	@Override
	public Product getProduct(int id) {
		Session session=sessionFactory.openSession();
		return (Product) session.get(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductlist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Product>) query.list();
	}

	/**
	 * 用于分页查询商品信息
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryListproduct(String hql){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return query.list();
	}
}
