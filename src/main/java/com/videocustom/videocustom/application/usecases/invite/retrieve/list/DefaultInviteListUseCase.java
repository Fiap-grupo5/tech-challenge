package com.videocustom.videocustom.application.usecases.invite.retrieve.list;

import java.util.List;

import com.videocustom.videocustom.application.repositories.InviteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultInviteListUseCase extends InviteListUseCase {

    private final InviteRepository inviteRepository;

    @Override
    public List<InviteListUseCaseOutput> execute() {
        return inviteRepository.findAll().stream()
                .map(InviteListUseCaseOutput::from)
                .toList();
    }

}
