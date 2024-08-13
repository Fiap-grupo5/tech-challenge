package com.videocustom.videocustom.application.usecases.invite.retrieve.get;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.invite.Invite;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record InviteGetByIdUseCaseOutput(BaseId id, BaseId guestId, BaseId projectId,
BaseId inviteBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static InviteGetByIdUseCaseOutput from(Invite invite) {
        return new InviteGetByIdUseCaseOutput(invite.getId(), invite.getGuestId(),
        invite.getProjectId(), invite.getInviteBy(), invite.getCreatedAt(), invite.getUpdatedAt(), invite.getDeletedAt());
    }
}
