package com.videocustom.videocustom.application.usecases.invite.retrieve.list;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.invite.Invite;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record InviteListUseCaseOutput(BaseId id, BaseId guestId, BaseId projectId,
    BaseId inviteBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

    public static InviteListUseCaseOutput from(Invite invite) {
        return new InviteListUseCaseOutput(invite.getId(), invite.getGuestId(),
        invite.getProjectId(), invite.getInviteBy(), invite.getCreatedAt(), invite.getUpdatedAt(), invite.getDeletedAt());
    }
}
