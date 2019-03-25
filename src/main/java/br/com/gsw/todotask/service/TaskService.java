package br.com.gsw.todotask.service;

import java.util.List;

import br.com.gsw.todotask.model.Task;


public interface TaskService {
	
	int save(Task task);
	Task get(int id);
	List<Task> list();
	void update(int id, Task task);
	void delete(int id);
	
}
