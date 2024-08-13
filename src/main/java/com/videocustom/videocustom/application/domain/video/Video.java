package com.videocustom.videocustom.application.domain.video;

import java.time.Instant;
import java.util.Objects;

import com.videocustom.videocustom.application.domain.base.BaseId;

import lombok.Getter;

@Getter
public class Video {
    private BaseId id;
    private String name;
    private String description;
    private BaseId projectId;
    private String url;
    private VideoStatus status;
    private BaseId createdBy;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Video(final BaseId id, final String name, final String description, 
            final BaseId projectId, final String url, final VideoStatus status, final BaseId createdBy,
            final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.createdBy = Objects.requireNonNull(createdBy, "id cannot be null");
        this.projectId = Objects.requireNonNull(projectId, "id cannot be null");
        this.name = name;
        this.description = description;
        this.status = status;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Video newVideo(final String name, final String description, final BaseId projectId, final String url, final BaseId createdBy) {
        final var id = BaseId.generate();
        final var now = Instant.now();
        return new Video(id, name, description, projectId, url, VideoStatus.CREATED, createdBy, now, now, null);
    }

    public static Video with(final BaseId id, final String name, final String description, final BaseId projectId, final String url,
            final VideoStatus status, final BaseId createdBy, final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        return new Video(id, name, description, projectId, url, status, createdBy, createdAt, updatedAt, deletedAt);
    }

    public Video update(final String name, final String description, final VideoStatus status, final BaseId createdBy, final BaseId projectId, final String url) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.projectId = projectId;
        this.url = url;
        this.updatedAt = Instant.now();
        return this;
    }
}
