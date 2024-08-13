package com.videocustom.videocustom.application.usecases.request.create;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.request.Request;

public record RequestCreateUseCaseOutput(BaseId id, String description, BaseId videoId, Integer time,
    BaseId requestBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static RequestCreateUseCaseOutput from(final Request request) {
        return new RequestCreateUseCaseOutput(request.getId(), request.getDescription(),
            request.getVideoId(), request.getTime(), request.getRequestBy(), request.getCreatedAt(), request.getUpdatedAt(), request.getDeletedAt());
    }
}
