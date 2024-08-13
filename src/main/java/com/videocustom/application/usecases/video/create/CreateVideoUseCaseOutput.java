package com.videocustom.application.usecases.video.create;

import java.time.Instant;
import java.util.UUID;
import com.videocustom.application.domain.video.Video;
import com.videocustom.application.domain.video.VideoId;

public record CreateVideoUseCaseOutput (VideoId id, UUID createdBy, String name, String description, String status, boolean active,
Instant createdAt, Instant updatedAt, Instant deletedAt) {

public static CreateVideoUseCaseOutput from(final Video video) {
return new CreateVideoUseCaseOutput(video.getId(), video.getCreatedBy(), video.getName(), video.getDescription(),
video.getStatus(), video.isActive(), video.getCreatedAt(), video.getUpdatedAt(), video.getDeletedAt());
}
}
