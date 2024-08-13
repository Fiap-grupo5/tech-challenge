package com.videocustom.videocustom.application.usecases.login;

import com.videocustom.videocustom.application.domain.user.User;

import java.time.Instant;

public record LoginUseCaseOutput(
        String id,
        String name,
        String email,
        boolean isGuest,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt
) {
    public static LoginUseCaseOutput from(User user) {
        return new LoginUseCaseOutput(
                user.getId().value(),
                user.getName(),
                user.getEmail(),
                false,
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getDeletedAt()
        );
    }
}
