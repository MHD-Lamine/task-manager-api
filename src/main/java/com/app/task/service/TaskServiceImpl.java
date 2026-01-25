package com.app.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.task.exception.TaskNotFoundException;
import com.app.task.model.StatutTask;
import com.app.task.model.Task;
import com.app.task.repository.TaskRepository;

public class TaskServiceImpl  implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task creer(Task task) {
        return repository.save(task);
    }

    @Override
    public Page<Task> lister(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Task> rechercherParStatut(StatutTask statut, Pageable pageable) {
        return repository.findByStatut(pageable, statut);
    }

    @Override
    public Task changerStatut(Long id, StatutTask statut) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.setStatut(statut);
        return repository.save(task);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        repository.deleteById(id);
    }

}
