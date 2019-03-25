package br.com.gsw.todotask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gsw.todotask.model.Task;
import br.com.gsw.todotask.service.TaskService;


@RestController
@CrossOrigin
public class TaskController {
	
	   @Autowired
	   private TaskService taskService;

	   /*---Add new task---*/
	   @PostMapping("/task")
	   public ResponseEntity<?> save(@RequestBody Task task) {
	      int id = taskService.save(task);
	      return ResponseEntity.ok().body("Nova tarefa criada com ID:" + id);
	   }

	   /*---Get a task by id---*/
	   @GetMapping("/task/{id}")
	   public ResponseEntity<Task> get(@PathVariable("id") int id) {
	      Task task = taskService.get(id);
	      return ResponseEntity.ok().body(task);
	   }

	   /*---get all tasks---*/
	   @GetMapping("/task")
	   public ResponseEntity<List<Task>> list() {
	      List<Task> tasks = taskService.list();
	      return ResponseEntity.ok().body(tasks);
	   }

	   /*---Update a task by id---*/
	   @PutMapping("/task/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Task task) {
	      taskService.update(id, task);
	      return ResponseEntity.ok().body("Tarefa atualizada com sucesso.");
	   }

	   /*---Delete a task by id---*/
	   @DeleteMapping("/task/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") int id) {
	      taskService.delete(id);
	      return ResponseEntity.ok().body("Tarefa deletada com sucesso.");
	   }
}
