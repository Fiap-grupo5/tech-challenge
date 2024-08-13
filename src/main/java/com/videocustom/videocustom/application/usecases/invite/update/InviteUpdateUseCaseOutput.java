package com.videocustom.videocustom.application.usecases.invite.update;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.invite.Invite;
import com.videocustom.videocustom.application.domain.base.BaseId;

public record InviteUpdateUseCaseOutput(BaseId id, BaseId guestId, BaseId projectId,
BaseId inviteBy, Instant createdAt, Instant updatedAt, Instant deletedAt) {

public static InviteUpdateUseCaseOutput from(final Invite invite) {
    return new InviteUpdateUseCaseOutput(invite.getId(), invite.getGuestId(),
        invite.getProjectId(), invite.getInviteBy(), invite.getCreatedAt(), invite.getUpdatedAt(), invite.getDeletedAt());
}
}
