package com.videocustom.videocustom.application.usecases.guest.delete;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.GuestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultGuestDeleteUseCase extends GuestDeleteUseCase {

    private final GuestRepository guestRepository;

    @Override
    public void execute(final String input) {
        final var guestId = BaseId.from(input);
        guestRepository.deleteById(guestId);
    }

}
