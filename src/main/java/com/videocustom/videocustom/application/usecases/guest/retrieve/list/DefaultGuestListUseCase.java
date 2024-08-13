package com.videocustom.videocustom.application.usecases.guest.retrieve.list;

import java.util.List;

import com.videocustom.videocustom.application.repositories.GuestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultGuestListUseCase extends GuestListUseCase {

    private final GuestRepository guestRepository;

    @Override
    public List<GuestListUseCaseOutput> execute() {
        return guestRepository.findAll().stream()
                .map(GuestListUseCaseOutput::from)
                .toList();
    }

}
