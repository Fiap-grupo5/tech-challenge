package com.videocustom.videocustom.application.usecases.project.retrieve.get;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.project.Project;
import com.videocustom.videocustom.application.domain.project.ProjectStatus;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record ProjectGetByIdUseCaseOutput(BaseId id, String name, String description,
        ProjectStatus status, BaseId createdBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static ProjectGetByIdUseCaseOutput from(Project project) {
        return new ProjectGetByIdUseCaseOutput(project.getId(), project.getName(), project.getDescription(),
            project.getStatus(), project.getCreatedBy(), project.getCreatedAt(), project.getUpdatedAt(), project.getDeletedAt());
    }
}
