package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Customerlevel;

public class customerlevelDaoImpl implements customerlevelDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(Customerlevel customerlevel) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customerlevel);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Customerlevel customerlevel=this.getCustomerlevel(id);
		customerlevel.setIsdel(1);
		this.edit(customerlevel);
	}

	@Override
	public void edit(Customerlevel customerlevel) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(customerlevel);
		tr.commit();
	}

	@Override
	public Customerlevel getCustomerlevel(int id) {
		String hql="From Customerlevel where id="+id;
		return (Customerlevel) this.getCustomerlevellist(hql).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customerlevel> getCustomerlevellist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Customerlevel>) query.list();
	}

	/**
	 * 查询客户等级类型
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryCustomerlevel(){
		//String hql="select * from customer";
		String hql="select b.name,count(1) from customer a" +
				" left join customerlevel b " +
				"on a.levelid=b.id " +
				"where a.isdel=0 " +
				"group by b.name";
		Session session=sessionFactory.openSession();
		return session.createSQLQuery(hql).list();
	}
	
	/**
	 *  用户分页查询客户等级使用
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryCustomerlevel(String hql){
		Session session=sessionFactory.openSession();
		return session.createQuery(hql).list();
	}
}
