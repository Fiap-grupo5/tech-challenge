package com.videocustom.videocustom.application.usecases.project.create;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.project.Project;
import com.videocustom.videocustom.application.domain.project.ProjectStatus;

public record ProjectCreateUseCaseOutput(BaseId id, String name, String description, ProjectStatus status, BaseId createdBy,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static ProjectCreateUseCaseOutput from(final Project project) {
        return new ProjectCreateUseCaseOutput(project.getId(), project.getName(), project.getDescription(),
            project.getStatus(), project.getCreatedBy(), project.getCreatedAt(), project.getUpdatedAt(), project.getDeletedAt());
    }
}
