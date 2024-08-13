package com.videocustom.application.usecases.project.retrieve.list;

import com.videocustom.application.domain.project.Project;
import com.videocustom.application.domain.project.ProjectId;

import java.time.Instant;

public record ProjectListUseCaseOutput(ProjectId id, String name, String description, String status, boolean active,
                                       Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static ProjectListUseCaseOutput from(final Project project) {
        return new ProjectListUseCaseOutput(project.getId(), project.getName(), project.getDescription(),
                project.getStatus(), project.isActive(), project.getCreatedAt(), project.getUpdatedAt(), project.getDeletedAt());
    }
}
