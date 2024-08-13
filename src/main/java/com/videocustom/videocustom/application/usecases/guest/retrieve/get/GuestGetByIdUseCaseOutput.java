package com.videocustom.videocustom.application.usecases.guest.retrieve.get;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.guest.Guest;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record GuestGetByIdUseCaseOutput(BaseId id, String name, String email,
        Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static GuestGetByIdUseCaseOutput from(Guest guest) {
        return new GuestGetByIdUseCaseOutput(guest.getId(), guest.getName(), guest.getEmail(),
            guest.getCreatedAt(), guest.getUpdatedAt(), guest.getDeletedAt());
    }
}
