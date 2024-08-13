package com.videocustom.videocustom.application.usecases.invite.create;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.invite.Invite;

public record InviteCreateUseCaseOutput(BaseId id, BaseId guestId, BaseId projectId,
    BaseId inviteBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static InviteCreateUseCaseOutput from(final Invite invite) {
        return new InviteCreateUseCaseOutput(invite.getId(), invite.getGuestId(),
            invite.getProjectId(), invite.getInviteBy(), invite.getCreatedAt(), invite.getUpdatedAt(), invite.getDeletedAt());
    }
}
