package com.app.task.service;

import com.app.task.model.StatutTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.app.task.model.Task;

public interface TaskService {
    Task creer(Task task);

    Page<Task> lister(Pageable pageable);

    Page <Task> rechercherParStatut(StatutTask statut, Pageable pageable);

    Task changerStatut(Long id, StatutTask statut);

    void supprimer(Long id);

}
