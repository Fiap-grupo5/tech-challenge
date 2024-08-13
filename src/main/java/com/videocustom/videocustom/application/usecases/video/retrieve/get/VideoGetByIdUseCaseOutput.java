package com.videocustom.videocustom.application.usecases.video.retrieve.get;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.video.Video;
import com.videocustom.videocustom.application.domain.video.VideoStatus;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record VideoGetByIdUseCaseOutput(BaseId id, String name, String description,
    VideoStatus status, BaseId createdBy, BaseId projectId, String url, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static VideoGetByIdUseCaseOutput from(Video video) {
        return new VideoGetByIdUseCaseOutput(video.getId(), video.getName(), video.getDescription(),
            video.getStatus(), video.getCreatedBy(), video.getProjectId(), video.getUrl(), video.getCreatedAt(), video.getUpdatedAt(), video.getDeletedAt());
    }
}