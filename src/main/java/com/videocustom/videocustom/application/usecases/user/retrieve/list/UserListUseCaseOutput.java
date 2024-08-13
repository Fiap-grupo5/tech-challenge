package com.videocustom.videocustom.application.usecases.user.retrieve.list;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record UserListUseCaseOutput(BaseId id, String name, String email,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static UserListUseCaseOutput from(final User user) {
        return new UserListUseCaseOutput(user.getId(), user.getName(), user.getEmail(),
            user.getCreatedAt(), user.getUpdatedAt(), user.getDeletedAt());
    }
}
