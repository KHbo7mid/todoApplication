package org.bo7mid.todoapp.Repository;

import org.bo7mid.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
