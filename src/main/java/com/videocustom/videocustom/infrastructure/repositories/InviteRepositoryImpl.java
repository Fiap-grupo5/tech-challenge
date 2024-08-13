package com.videocustom.videocustom.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.invite.Invite;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.InviteRepository;
import com.videocustom.videocustom.infrastructure.persistence.entities.InviteJPAEntity;
import com.videocustom.videocustom.infrastructure.persistence.repositories.InviteJPARepository;
import com.videocustom.videocustom.infrastructure.persistence.repositories.GuestJPARepository;
import com.videocustom.videocustom.infrastructure.persistence.repositories.ProjectJPARepository;
import com.videocustom.videocustom.infrastructure.persistence.repositories.UserJPARepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InviteRepositoryImpl implements InviteRepository {

    private final InviteJPARepository inviteJPARepository;
    private final GuestJPARepository guestJPARepository;
    private final ProjectJPARepository projectJPARepository;
    private final UserJPARepository userJPARepository;

    @Override
    @Transactional
    public Invite create(final Invite aInvite) {
        return save(aInvite);
    }

    @Override
    public List<Invite> findAll() {
        return inviteJPARepository.findAll().stream().map(InviteJPAEntity::toInvite).toList();
    }

    @Override
    public Optional<Invite> findById(final BaseId anId) {
        return inviteJPARepository.findById(anId.value()).map(InviteJPAEntity::toInvite);
    }

    @Override
    @Transactional
    public void deleteById(final BaseId anId) {
        inviteJPARepository.deleteById(anId.value());
    }

    @Override
    @Transactional
    public Invite update(final Invite aInvite) {
        return save(aInvite);
    }

    private Invite save(final Invite invite) {
        var guestJPA = guestJPARepository.findById(invite.getGuestId().value())
        .orElseThrow(() -> new RuntimeException("Guest not found."));
        var projectJPA = projectJPARepository.findById(invite.getProjectId().value())
        .orElseThrow(() -> new RuntimeException("Project not found."));
        var userJPA = userJPARepository.findById(invite.getInviteBy().value())
        .orElseThrow(() -> new RuntimeException("User not found."));
        return inviteJPARepository.save(InviteJPAEntity.of(invite, guestJPA, projectJPA, userJPA)).toInvite();
    }

}
