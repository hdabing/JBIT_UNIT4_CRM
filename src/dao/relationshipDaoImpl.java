package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Relationship;

public class relationshipDaoImpl implements relationshipDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Relationship relationship) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(relationship);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getRelationship(id));
		tr.commit();
	}

	@Override
	public void edit(Relationship relationship) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(relationship);
		tr.commit();
	}

	@Override
	public Relationship getRelationship(int id) {
		Session session=sessionFactory.openSession();
		return (Relationship) session.get(Relationship.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Relationship> getRelationshiplist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Relationship>) query.list();
	}

}
