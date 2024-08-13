package com.videocustom.videocustom.application.usecases.video.retrieve.list;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.video.Video;
import com.videocustom.videocustom.application.domain.video.VideoStatus;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record VideoListUseCaseOutput(BaseId id, String name, String description,
    VideoStatus status, BaseId createdBy, BaseId projectId, String url, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static VideoListUseCaseOutput from(final Video video) {
        return new VideoListUseCaseOutput(video.getId(), video.getName(), video.getDescription(),
            video.getStatus(), video.getCreatedBy(), video.getProjectId(), video.getUrl(), video.getCreatedAt(), video.getUpdatedAt(), video.getDeletedAt());
    }
}
