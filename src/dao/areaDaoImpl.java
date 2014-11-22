package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Area;

public class areaDaoImpl implements areaDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Area area) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(area);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Area area=this.getArea(id);
		area.setIsdel(1);
		this.edit(area);
	}

	@Override
	public void edit(Area area) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(area);
		tr.commit();
	}

	@Override
	public Area getArea(int id) {
		Session session=sessionFactory.openSession();
		String hql="From Area where id=:id";
		Query query=session.createQuery(hql);
		query.setInteger("id", id);
		
		return (Area) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> getArealist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Area>) query.list();
	}

	/**
	 * 用于分页查询地区
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryListarea(String hql){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return query.list();
	}
}
