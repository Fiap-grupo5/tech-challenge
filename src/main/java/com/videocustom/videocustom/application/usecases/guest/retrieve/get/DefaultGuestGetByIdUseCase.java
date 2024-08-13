package com.videocustom.videocustom.application.usecases.guest.retrieve.get;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.GuestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultGuestGetByIdUseCase extends GuestGetByIdUseCase {

    private final GuestRepository guestRepository;

    @Override
    public GuestGetByIdUseCaseOutput execute(String input) {
        final var guestId = BaseId.from(input);

        return guestRepository.findById(guestId)
                .map(GuestGetByIdUseCaseOutput::from)
                .orElseThrow(() -> new NotFoundException("Guest with ID %s not found.".formatted(guestId)));
    }

}
