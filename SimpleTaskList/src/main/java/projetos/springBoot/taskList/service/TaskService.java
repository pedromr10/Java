package projetos.springBoot.taskList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetos.springBoot.taskList.dto.TaskDTO;
import projetos.springBoot.taskList.entities.Task;
import projetos.springBoot.taskList.exceptions.ResourceNotFoundException;
import projetos.springBoot.taskList.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	//retorna todos as tarefas:
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
	
	//retorna apenas a tarefa com determinado id:
	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}
	
	//insere uma task:
	public Task insert(Task task) {
		return taskRepository.save(task);
	}
	
	//atualiza uma task:
	public Task update(Long id, Task task) {
		Task entity = taskRepository.findById(id).orElseThrow();
		
		entity.setTitulo(task.getTitulo());
		entity.setDescricao(task.getDescricao());
		entity.setStatus(task.getStatus());
		
		return taskRepository.save(entity);
	}
	
	//atualiza task com DTO:
	public Task update(Long id, TaskDTO dto) {
		Task entity = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task não encontrada com id: " + id));;
		
		entity.setTitulo(dto.getTitulo());
		entity.setDescricao(dto.getDescricao());
		entity.setStatus(dto.getStatus());
		
		return taskRepository.save(entity);
	}
	
	public void delete(Long id) {

	    if (!taskRepository.existsById(id)) {
	        throw new ResourceNotFoundException("Task não encontrada com id: " + id);
	    }

	    taskRepository.deleteById(id);
	}
}
