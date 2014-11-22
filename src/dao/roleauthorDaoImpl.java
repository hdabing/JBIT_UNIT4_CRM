package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Roleauthor;

public class roleauthorDaoImpl implements roleauthorDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Roleauthor roleauthor) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(roleauthor);
		tr.commit();
	}

	@Override
	public void del(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(this.getRoleauthor(id));
		tr.commit();
	}

	@Override
	public void edit(Roleauthor roleauthor) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(roleauthor);
		tr.commit();
	}

	@Override
	public Roleauthor getRoleauthor(int id) {
		Session session=sessionFactory.openSession();
		return (Roleauthor) session.get(Roleauthor.class, id);
	}
	
	/**
	 * 根据角色id及权限id来获取角色权限
	 * @param roleid
	 * @param authorid
	 * @return
	 */
	public Roleauthor getRoleauthor(int roleid,int authorid){
		String hql="From Roleauthor where roleid="+roleid+" and authorid="+authorid;
		Session session=sessionFactory.openSession();
		return (Roleauthor) session.createQuery(hql).list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roleauthor> getRoleauthorlist(String hql) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		return (List<Roleauthor>) query.list();
	}

	/**
	 * 更新角色权限
	 * @param roleauthor
	 */
	public void updateRoleauthor(Roleauthor roleauthor){
		String hql="From Roleauthor where roleid="+
				roleauthor.getRoleid()+" and authorid="+roleauthor.getAuthorid();
		Roleauthor rl=this.getRoleauthorlist(hql).get(0);
		rl.setIsdel(0);
		this.edit(rl);
	}
}
