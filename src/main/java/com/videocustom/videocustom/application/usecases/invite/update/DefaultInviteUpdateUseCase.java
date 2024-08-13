package com.videocustom.videocustom.application.usecases.invite.update;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.InviteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultInviteUpdateUseCase extends InviteUpdateUseCase {

    private final InviteRepository inviteRepository;

    @Override
    public InviteUpdateUseCaseOutput execute(InviteUpdateUseCaseInput input) {
        final var inviteId = BaseId.from(input.id());

        final var invite = inviteRepository.findById(inviteId)
                .orElseThrow(() -> new NotFoundException("Request with ID %s not found.".formatted(inviteId)));

        invite.update(input.guestId(), input.projectId(), input.inviteBy());
        this.inviteRepository.update(invite);

        return InviteUpdateUseCaseOutput.from(invite);
    }

}
