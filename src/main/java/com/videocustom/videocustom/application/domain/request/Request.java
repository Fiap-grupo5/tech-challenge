package com.videocustom.videocustom.application.domain.request;

import java.time.Instant;
import java.util.Objects;

import com.videocustom.videocustom.application.domain.base.BaseId;

import lombok.Getter;

@Getter
public class Request {
    private BaseId id;
    private String description;
    private BaseId videoId;
    private Integer time;
    private BaseId requestBy;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Request(final BaseId id, final String description, final BaseId videoId, 
            final Integer time, final BaseId requestBy, final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.videoId = Objects.requireNonNull(videoId, "id cannot be null");
        this.requestBy = Objects.requireNonNull(requestBy, "id cannot be null");
        this.time = time;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Request newRequest(final String description, final BaseId videoId, final Integer time, final BaseId requestBy) {
        final var id = BaseId.generate();
        final var now = Instant.now();
        return new Request(id, description, videoId, time, requestBy, now, now, null);
    }

    public static Request with(final BaseId id, final String description, final BaseId videoId, final Integer time, final BaseId requestBy,
            final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        return new Request(id, description, videoId, time, requestBy, createdAt, updatedAt, deletedAt);
    }

    public Request update(final String description, final BaseId videoId, final Integer time, final BaseId requestBy) {
        this.description = description;
        this.videoId = videoId;
        this.time = time;
        this.requestBy = requestBy;
        this.updatedAt = Instant.now();
        return this;
    }
}
