package com.videocustom.videocustom.application.usecases.project.update;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.project.Project;
import com.videocustom.videocustom.application.domain.project.ProjectStatus;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record ProjectUpdateUseCaseOutput(BaseId id, String name, String description,
        ProjectStatus status, BaseId createdBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static ProjectUpdateUseCaseOutput from(final Project project) {
        return new ProjectUpdateUseCaseOutput(project.getId(), project.getName(), project.getDescription(),
            project.getStatus(), project.getCreatedBy(), project.getCreatedAt(), project.getUpdatedAt(), project.getDeletedAt());
    }
}
