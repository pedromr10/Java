package projetos.springBoot.taskList.dto;

import projetos.springBoot.taskList.entities.Task;
import projetos.springBoot.taskList.entities.enums.StatusTarefa;

public class TaskDTO {
	private Long id;
	private String titulo;
	private String descricao;
	private StatusTarefa status;
	
	public TaskDTO() {}
	
	public TaskDTO(Long id, String titulo, String descricao, StatusTarefa status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
	}
	
	//construtor para conversao de task para dto
	public TaskDTO(Task task) {
		this.id = task.getId();
		this.titulo = task.getTitulo();
		this.descricao = task.getDescricao();
		this.status = task.getStatus();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public StatusTarefa getStatus() {
		return status;
	}
	
}

//obs: a dto serve para evitar a exposicao de entidades do banco, padronizacao de resposta, evolucao da api, desacoplamento da api do banco