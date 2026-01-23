package com.app.task.dto;

import com.app.task.model.StatutTask;

import jakarta.validation.constraints.NotNull;

public class TaskStatusUpdateRequest {

    @NotNull(message = "Le statut est obligatoire")
    private StatutTask statut;

    // Getters and Setters

}
