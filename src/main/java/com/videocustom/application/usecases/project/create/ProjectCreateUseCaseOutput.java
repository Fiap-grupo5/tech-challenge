package com.videocustom.application.usecases.project.create;

import com.videocustom.application.domain.project.Project;
import com.videocustom.application.domain.project.ProjectId;

import java.time.Instant;

public record ProjectCreateUseCaseOutput(ProjectId id, String name, String description, String status, boolean active,
                                         Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static ProjectCreateUseCaseOutput from(final Project project) {
        return new ProjectCreateUseCaseOutput(project.getId(), project.getName(), project.getDescription(),
                project.getStatus(), project.isActive(), project.getCreatedAt(), project.getUpdatedAt(), project.getDeletedAt());
    }
}
