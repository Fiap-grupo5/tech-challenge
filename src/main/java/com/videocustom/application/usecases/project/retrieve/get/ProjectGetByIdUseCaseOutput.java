package com.videocustom.application.usecases.project.retrieve.get;

import com.videocustom.application.domain.project.Project;
import com.videocustom.application.domain.project.ProjectId;

import java.time.Instant;

public record ProjectGetByIdUseCaseOutput(ProjectId id, String name, String description, String status, boolean isActive,
                                          Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static ProjectGetByIdUseCaseOutput from(Project project) {
        return new ProjectGetByIdUseCaseOutput(project.getId(), project.getName(), project.getDescription(),
                project.getStatus(), project.isActive(), project.getCreatedAt(), project.getUpdatedAt(),
                project.getDeletedAt());
    }
}
