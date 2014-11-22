package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entity.Servicestate;

public class servicestateDaoImpl implements servicestateDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Servicestate servicestate) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(servicestate);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Servicestate servicestate=this.getServicestate(id);
		servicestate.setIsdel(1);
		this.edit(servicestate);
	}

	@Override
	public void edit(Servicestate servicestate) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(servicestate);
		tr.commit();
	}

	@Override
	public Servicestate getServicestate(int id) {
		String hql="From Servicestate where id="+id;
		return (Servicestate) this.getServicestatelist(hql).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servicestate> getServicestatelist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Servicestate>) query.list();
	}

}
