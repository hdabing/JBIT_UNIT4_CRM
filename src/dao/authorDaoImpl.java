package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Author;

public class authorDaoImpl implements authorDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Author author) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(author);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Author author=this.getAuthor(id);
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(author);
		tr.commit();
	}

	@Override
	public void edit(Author author) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(author);
		tr.commit();
	}

	@Override
	public Author getAuthor(int id) {
		Session session=sessionFactory.openSession();
		String hql="From Author where id=:id";
		Query query=session.createQuery(hql);
		query.setInteger("id", id);
		
		return (Author) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAuthorlist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		
		return (List<Author>) query.list();
	}

}
