package com.videocustom.videocustom.application.usecases.guest.update;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.guest.Guest;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record GuestUpdateUseCaseOutput(BaseId id, String name, String email,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static GuestUpdateUseCaseOutput from(final Guest guest) {
        return new GuestUpdateUseCaseOutput(guest.getId(), guest.getName(), guest.getEmail(),
            guest.getCreatedAt(), guest.getUpdatedAt(), guest.getDeletedAt());
    }
}