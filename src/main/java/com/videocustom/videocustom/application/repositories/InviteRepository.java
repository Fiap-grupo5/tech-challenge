package com.videocustom.videocustom.application.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.invite.Invite;

public interface InviteRepository {

    Invite create(Invite aInvite);

    Invite update(Invite aInvite);

    Optional<Invite> findById(BaseId anId);

    List<Invite> findAll();

    void deleteById(BaseId anId);

}
