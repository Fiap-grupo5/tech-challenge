package com.videocustom.application.domain.video;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Video {
    private static VideoId id;
    private static String name;
    private String description;
    // private UUID projectId;
    private String url;
    private VideoStatus status;
    private UUID createdBy;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;
    private boolean active;

    public Video(final VideoId id, final String name, final String description, String url, VideoStatus status, UUID createdBy, Instant createdAt, Instant updatedAt, Instant deletedAt, final boolean active) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.name = name;
        this.description = description;
        this.url = url;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Video newVideo(final VideoId id, final UUID createdBy, final String name, final String description, final String url, final VideoStatus status, final boolean active){
        final var now = Instant.now();
        final var deletedAt = active ? null : now;
        return new Video(new VideoId(null), createdBy, name, description, url, status, active, now, now, deletedAt);
    }

    public static Video with(final VideoId id, final UUID createdBy, final String name, final String description, final String url, final String status,
                                final boolean isActive, final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        return new Video(id, createdBy, name, description, url, status, isActive, createdAt, updatedAt, deletedAt);
    }

    public Video update(String name, String description, String url, VideoStatus status, final boolean active){
        if (active) {
            activate();
        } else {
            desactivate();
        }
        this.name = name;
        this.description = description;
        this.status = status;
        this.updatedAt = Instant.now();
        return this;
    }

    public Video activate() {
        this.active = true;
        this.deletedAt = null;
        this.updatedAt = Instant.now();
        return this;
    }

    public Video desactivate() {
        if (this.deletedAt == null) {
            this.deletedAt = Instant.now();
        }
        this.active = false;
        this.updatedAt = Instant.now();
        return this;
    }

    public VideoId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public VideoStatus getStatus() {
        return status;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStatus(VideoStatus status) {
        this.status = status;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
