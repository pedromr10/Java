package projetos.springBoot.taskList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetos.springBoot.taskList.entities.Task;
import projetos.springBoot.taskList.service.TaskService;

@RestController
@RequestMapping(value="/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<Task> findAll(){
		return taskService.findAll();
	}
	
	@GetMapping("/{id}")
	public Task findById(@PathVariable Long id) {
		return taskService.findById(id);
	}
	
	
	//obs: requesbody pega o json da requisicao e transforma em objeto task
	@PostMapping 
	public Task insert(@RequestBody Task task) { 
		return taskService.insert(task); 
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		taskService.delete(id);
	}
	
	//obs: pega o id da tarefa e o json atualizado
	@PutMapping("{id}")
	public Task update(@PathVariable Long id, @RequestBody Task task) {
		return taskService.update(id, task);
	}
	
}
