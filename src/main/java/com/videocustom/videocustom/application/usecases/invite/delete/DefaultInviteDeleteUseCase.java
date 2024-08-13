package com.videocustom.videocustom.application.usecases.invite.delete;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.InviteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultInviteDeleteUseCase extends InviteDeleteUseCase {

    private final InviteRepository inviteRepository;

    @Override
    public void execute(final String input) {
        final var inviteId = BaseId.from(input);
        inviteRepository.deleteById(inviteId);
    }

}
