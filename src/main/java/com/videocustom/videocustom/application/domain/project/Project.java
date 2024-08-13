package com.videocustom.videocustom.application.domain.project;

import java.time.Instant;
import java.util.Objects;

import com.videocustom.videocustom.application.domain.base.BaseId;

import lombok.Getter;

@Getter
public class Project {
    private BaseId id;
    private String name;
    private String description;
    private ProjectStatus status;
    private BaseId createdBy;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Project(final BaseId id, final String name, final String description, final ProjectStatus status, final BaseId createdBy,
            final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.createdBy = Objects.requireNonNull(createdBy, "id cannot be null");
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Project newProject(final String name, final String description, final BaseId createdBy) {
        final var id = BaseId.generate();
        final var now = Instant.now();
        return new Project(id, name, description, ProjectStatus.CREATED, createdBy, now, now, null);
    }

    public static Project with(final BaseId id, final String name, final String description,
            final ProjectStatus status, final BaseId createdBy, final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        return new Project(id, name, description, status, createdBy, createdAt, updatedAt, deletedAt);
    }

    public Project update(final String name, final String description, final ProjectStatus status, final BaseId createdBy) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.updatedAt = Instant.now();
        return this;
    }
}
