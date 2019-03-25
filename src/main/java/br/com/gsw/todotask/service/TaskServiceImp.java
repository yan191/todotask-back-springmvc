package br.com.gsw.todotask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gsw.todotask.dao.TaskDao;
import br.com.gsw.todotask.model.Task;

@Service
@Transactional
public class TaskServiceImp implements TaskService {
	
	@Autowired
	private TaskDao taskDao;
	
	@Transactional
	   @Override
	   public int save(Task task) {
	      return taskDao.save(task);
	   }

	   @Override
	   public Task get(int id) {
	      return taskDao.get(id);
	   }

	   @Override
	   public List<Task> list() {
	      return taskDao.list();
	   }

	   @Transactional
	   @Override
	   public void update(int id, Task task) {
	      taskDao.update(id, task);
	   }

	   @Transactional
	   @Override
	   public void delete(int id) {
	      taskDao.delete(id);
	   }
	
}
