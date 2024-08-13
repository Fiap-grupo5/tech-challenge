package com.videocustom.videocustom.application.usecases.guest.create;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.guest.Guest;

public record GuestCreateUseCaseOutput(BaseId id, String name, String email,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static GuestCreateUseCaseOutput from(final Guest guest) {
        return new GuestCreateUseCaseOutput(guest.getId(), guest.getName(), guest.getEmail(),
            guest.getCreatedAt(), guest.getUpdatedAt(), guest.getDeletedAt());
    }
}
