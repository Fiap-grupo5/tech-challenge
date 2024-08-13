package com.videocustom.videocustom.application.usecases.project.retrieve.list;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.project.Project;
import com.videocustom.videocustom.application.domain.project.ProjectStatus;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record ProjectListUseCaseOutput(BaseId id, String name, String description,
        ProjectStatus status, BaseId createdBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static ProjectListUseCaseOutput from(final Project project) {
        return new ProjectListUseCaseOutput(project.getId(), project.getName(), project.getDescription(),
            project.getStatus(), project.getCreatedBy(), project.getCreatedAt(), project.getUpdatedAt(), project.getDeletedAt());
    }
}
