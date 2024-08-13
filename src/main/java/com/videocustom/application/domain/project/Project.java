package com.videocustom.application.domain.project;

import java.time.Instant;
import java.util.Objects;

public class Project {

    private ProjectId id;
    private String name;
    private String description;
    private String status;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;
    private boolean active;

    private Project(final ProjectId id, final String name, final String description, final String status, final boolean active,
                    final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.name = name;
        this.description = description;
        this.status = status;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Project newProject(final String name, final String description, final String status, final boolean active) {
        final var id = ProjectId.generate();
        final var now = Instant.now();
        final var deletedAt = active ? null : now;
        return new Project(id, name, description, status, active, now, now, deletedAt);
    }
    public static Project with(final ProjectId id, final String name, final String description, final String status,
                                final boolean isActive, final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        return new Project(id, name, description, status, isActive, createdAt, updatedAt, deletedAt);
    }
    public Project update(final String name, final String description, final String status, final boolean active) {
        if (active) {
            activate();
        } else {
            deactivate();
        }
        this.name = name;
        this.description = description;
        this.status = status;
        this.updatedAt = Instant.now();
        return this;
    }

    public Project activate() {
        this.active = true;
        this.deletedAt = null;
        this.updatedAt = Instant.now();
        return this;
    }

    public Project deactivate() {
        if (this.deletedAt == null) {
            this.deletedAt = Instant.now();
        }
        this.active = false;
        this.updatedAt = Instant.now();
        return this;
    }



}
