package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entity.Service;

public class serviceDaoImpl implements serviceDao{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Service service) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(service);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Service service=this.getService(id);
		service.setIsdel(1);
		this.edit(service);
	}

	@Override
	public void edit(Service service) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(service);
		tr.commit();
	}

	@Override
	public Service getService(int id) {
		Session session=sessionFactory.openSession();
		String hql="From Service where id="+id;
		Query query=session.createQuery(hql);
		return (Service) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> getServicelist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Service>) query.list();
	}

	/**
	 * 查询统计服务数量
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List countService(){
		String hql="select b.name,count(serviceid) from servicelist a" +
				" left join service b" +
				" on a.serviceid=b.id" +
				" group by b.name";
		Session session=sessionFactory.openSession();
		return session.createSQLQuery(hql).list();
	}
	
	/**
	 * 分页查询服务统计数量
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List countService(String hql){
		Session session=sessionFactory.openSession();
		return session.createSQLQuery(hql).list();
	}
	
	/**
	 * 分页查询服务类型
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryService(String hql){
		Session session=sessionFactory.openSession();
		return session.createSQLQuery(hql).list();
	}
}
