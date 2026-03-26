package projetos.springBoot.taskList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetos.springBoot.taskList.dto.TaskDTO;
import projetos.springBoot.taskList.entities.Task;
import projetos.springBoot.taskList.exceptions.ResourceNotFoundException;
import projetos.springBoot.taskList.service.TaskService;

@RestController
@RequestMapping(value="/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
		Task task = taskService.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
		
		TaskDTO dto = new TaskDTO(task);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> findAll(){
		List<Task> list= taskService.findAll();
		//transforma cada task da lista em taskdto:
		List<TaskDTO> dtoList = list.stream().map(TaskDTO::new).toList();
		return ResponseEntity.ok(dtoList);
	}
	
	
	//obs: requesbody pega o json da requisicao e transforma em objeto task
	@PostMapping 
	public ResponseEntity<Task> insert(@RequestBody Task task) { 
		Task saved =  taskService.insert(task); 
		return ResponseEntity.status(200).body(saved);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		taskService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//obs: pega o id da tarefa e o json atualizado
	@PutMapping("{id}")
	public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
		Task updated = taskService.update(id, task);
		return ResponseEntity.ok(updated);
	}
	
}
