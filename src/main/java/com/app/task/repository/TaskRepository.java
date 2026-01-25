package com.app.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.task.model.StatutTask;
import com.app.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page <Task> findByStatut(Pageable pageable, StatutTask statut);

}
