package com.videocustom.videocustom.application.usecases.user.update;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record UserUpdateUseCaseOutput(BaseId id, String name, String email,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static UserUpdateUseCaseOutput from(final User user) {
        return new UserUpdateUseCaseOutput(user.getId(), user.getName(), user.getEmail(),
            user.getCreatedAt(), user.getUpdatedAt(), user.getDeletedAt());
    }
}
