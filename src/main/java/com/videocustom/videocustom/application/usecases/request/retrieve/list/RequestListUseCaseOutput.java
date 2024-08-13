package com.videocustom.videocustom.application.usecases.request.retrieve.list;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.request.Request;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record RequestListUseCaseOutput(BaseId id, String description,
    BaseId videoId, Integer time, BaseId requestBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static RequestListUseCaseOutput from(final Request request) {
        return new RequestListUseCaseOutput(request.getId(), request.getDescription(),
            request.getVideoId(), request.getTime(), request.getRequestBy(), request.getCreatedAt(), request.getUpdatedAt(), request.getDeletedAt());
    }
}
