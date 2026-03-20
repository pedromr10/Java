package projetos.springBoot.taskList.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetos.springBoot.taskList.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
