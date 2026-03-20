package projetos.springBoot.taskList.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import projetos.springBoot.taskList.entities.enums.StatusTarefa;

@Entity
@Table(name = "tb_tarefa")
public class Task implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Long id;
	private String titulo;
	private String descricao;
	@Enumerated(EnumType.STRING) //salva no banco como string, mais facil que ordem
	private StatusTarefa status;
	
	public Task() {}

	public Task(Long id, String titulo, String descricao, StatusTarefa status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}
}
