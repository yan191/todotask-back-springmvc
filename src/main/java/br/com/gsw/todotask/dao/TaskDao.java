package br.com.gsw.todotask.dao;

import java.util.List;

import br.com.gsw.todotask.model.Task;

public interface TaskDao {
	
	int save(Task task);
	
	Task get(int id);
	
	List<Task> list();
	
	void update(int id, Task task);
	
	void delete(int id);
	
}
