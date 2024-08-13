package com.videocustom.videocustom.application.usecases.guest.create;

import com.videocustom.videocustom.application.domain.guest.Guest;
import com.videocustom.videocustom.application.repositories.GuestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultGuestCreateUseCase extends GuestCreateUseCase {

    private final GuestRepository guestRepository;

    @Override
    public GuestCreateUseCaseOutput execute(GuestCreateUseCaseInput input) {
        final var newGuest = Guest.newGuest(input.name(), input.email(), input.password());
        final var guest = guestRepository.create(newGuest);
        return GuestCreateUseCaseOutput.from(guest);
    }

}
