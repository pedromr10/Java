package projetos.springBoot.taskList.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import projetos.springBoot.taskList.entities.Task;
import projetos.springBoot.taskList.entities.enums.StatusTarefa;
import projetos.springBoot.taskList.repository.TaskRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//criando a tarefa
		Task t1 = new Task(null, "Limpar a casa", "Devo deixar a casa brilhando", StatusTarefa.PENDENTE);
		Task t2 = new Task(null, "Dar remedio pra Jiji", "Dar o remedio pra Jiji de barriga as 22", StatusTarefa.CONCLUIDA);
		
		//salvando a tarefa
		taskRepository.saveAll(Arrays.asList(t1, t2));
	}

}
