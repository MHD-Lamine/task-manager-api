package com.app.task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskCreateResquest {

    @NotBlank(message = "Le titre est obligatoire")
    @Size(min = 3, max = 100, message = "Le titre ne doit pas depasser 100 caracteres")
    private String title;
    private String description;

    @NotNull(message = "La priorite est obligatoire")
    private String priorite;

    // Getters and Setters

}
