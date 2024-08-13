package com.videocustom.application.usecases.project.update;

import com.videocustom.application.domain.project.Project;
import com.videocustom.application.domain.project.ProjectId;

import java.time.Instant;

public record ProjectUpdateUseCaseOutput(ProjectId id, String name, String description, String status, boolean isActive,
                                         Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static ProjectUpdateUseCaseOutput from(final Project project) {
        return new ProjectUpdateUseCaseOutput(project.getId(), project.getName(), project.getDescription(),
                project.getStatus(), project.isActive(), project.getCreatedAt(), project.getUpdatedAt(), project.getDeletedAt());
    }
}
