package com.videocustom.videocustom.application.usecases.guest.update;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.GuestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultGuestUpdateUseCase extends GuestUpdateUseCase {

    private final GuestRepository guestRepository;

    @Override
    public GuestUpdateUseCaseOutput execute(GuestUpdateUseCaseInput input) {
        final var guestId = BaseId.from(input.id());

        final var guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new NotFoundException("Guest with ID %s not found.".formatted(guestId)));

        guest.update(input.name(), input.email(), input.password());
        this.guestRepository.update(guest);

        return GuestUpdateUseCaseOutput.from(guest);
    }

}
