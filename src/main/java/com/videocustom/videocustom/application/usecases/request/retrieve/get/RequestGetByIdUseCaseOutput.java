package com.videocustom.videocustom.application.usecases.request.retrieve.get;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.request.Request;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record RequestGetByIdUseCaseOutput(BaseId id, String description,
    BaseId videoId, Integer time, BaseId requestBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static RequestGetByIdUseCaseOutput from(Request request) {
        return new RequestGetByIdUseCaseOutput(request.getId(), request.getDescription(),
            request.getVideoId(), request.getTime(), request.getRequestBy(), request.getCreatedAt(), request.getUpdatedAt(), request.getDeletedAt());
    }
}
