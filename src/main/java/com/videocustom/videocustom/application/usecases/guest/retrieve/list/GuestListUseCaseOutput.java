package com.videocustom.videocustom.application.usecases.guest.retrieve.list;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.guest.Guest;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record GuestListUseCaseOutput(BaseId id, String name, String email,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static GuestListUseCaseOutput from(final Guest guest) {
        return new GuestListUseCaseOutput(guest.getId(), guest.getName(), guest.getEmail(),
            guest.getCreatedAt(), guest.getUpdatedAt(), guest.getDeletedAt());
    }
}
