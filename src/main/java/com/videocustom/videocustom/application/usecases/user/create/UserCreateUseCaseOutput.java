package com.videocustom.videocustom.application.usecases.user.create;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.user.User;

public record UserCreateUseCaseOutput(BaseId id, String name, String email,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static UserCreateUseCaseOutput from(final User user) {
        return new UserCreateUseCaseOutput(user.getId(), user.getName(), user.getEmail(),
            user.getCreatedAt(), user.getUpdatedAt(), user.getDeletedAt());
    }
}
