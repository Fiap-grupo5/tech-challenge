package com.videocustom.videocustom.application.usecases.invite.create;

import com.videocustom.videocustom.application.domain.invite.Invite;
import com.videocustom.videocustom.application.repositories.InviteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultInviteCreateUseCase extends InviteCreateUseCase {

    private final InviteRepository inviteRepository;

    @Override
    public InviteCreateUseCaseOutput execute(InviteCreateUseCaseInput input) {
        final var newInvite = Invite.newInvite(input.guestId(), input.projectId(), input.inviteBy());
        final var invite = inviteRepository.create(newInvite);
        return InviteCreateUseCaseOutput.from(invite);
    }

}
