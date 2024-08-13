package com.videocustom.videocustom.application.usecases.user.retrieve.get;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record UserGetByIdUseCaseOutput(BaseId id, String name, String email,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static UserGetByIdUseCaseOutput from(User user) {
        return new UserGetByIdUseCaseOutput(user.getId(), user.getName(), user.getEmail(),
            user.getCreatedAt(), user.getUpdatedAt(), user.getDeletedAt());
    }
}
