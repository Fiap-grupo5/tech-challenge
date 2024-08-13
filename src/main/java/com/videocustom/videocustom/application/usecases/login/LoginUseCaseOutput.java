package com.videocustom.videocustom.application.usecases.login;

import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.domain.guest.Guest;

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

    public static LoginUseCaseOutput from(Guest guest) {
        return new LoginUseCaseOutput(
                guest.getId().value(),
                guest.getName(),
                guest.getEmail(),
                true,
                guest.getCreatedAt(),
                guest.getUpdatedAt(),
                guest.getDeletedAt()
        );
    }
}