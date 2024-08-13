package com.videocustom.videocustom.application.usecases.invite.retrieve.get;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.InviteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultInviteGetByIdUseCase extends InviteGetByIdUseCase {

    private final InviteRepository inviteRepository;

    @Override
    public InviteGetByIdUseCaseOutput execute(String input) {
        final var inviteId = BaseId.from(input);

        return inviteRepository.findById(inviteId)
                .map(InviteGetByIdUseCaseOutput::from)
                .orElseThrow(() -> new NotFoundException("Invite with ID %s not found.".formatted(inviteId)));
    }

}
