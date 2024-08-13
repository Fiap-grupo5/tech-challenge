package com.videocustom.videocustom.application.usecases.video.create;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.video.Video;
import com.videocustom.videocustom.application.domain.video.VideoStatus;

public record VideoCreateUseCaseOutput(BaseId id, String name, String description, VideoStatus status, BaseId createdBy,
    BaseId projectId, String url, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static VideoCreateUseCaseOutput from(final Video video) {
        return new VideoCreateUseCaseOutput(video.getId(), video.getName(), video.getDescription(),
            video.getStatus(), video.getCreatedBy(), video.getProjectId(), video.getUrl(), video.getCreatedAt(), video.getUpdatedAt(), video.getDeletedAt());
    }
}
