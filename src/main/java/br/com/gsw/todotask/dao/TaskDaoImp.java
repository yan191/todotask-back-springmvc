package br.com.gsw.todotask.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.gsw.todotask.model.Task;

@Repository
public class TaskDaoImp implements TaskDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public int save(Task task) {
		sessionFactory.getCurrentSession().save(task);
		return task.getId();
	}

	@Override
	public Task get(int id) {
		return sessionFactory.getCurrentSession().get(Task.class, id);
	}

	@Override
	public List<Task> list() {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Task> cq = cb.createQuery(Task.class);
	    Root<Task> root = cq.from(Task.class);
	    cq.select(root);
	    Query<Task> query = session.createQuery(cq);
	    return query.getResultList();
	}

	@Override
	public void update(int id, Task task) {
		Session session = sessionFactory.getCurrentSession();
	    Task task2 = session.byId(Task.class).load(id);
	    task2.setTitulo(task.getTitulo());
	    task2.setStatus(task.isStatus());;
	    session.flush();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
	    Task book = session.byId(Task.class).load(id);
	    session.delete(book);
	}

}
