package com.videocustom.videocustom.application.usecases.invite.update;

import com.videocustom.videocustom.application.domain.base.BaseId;

public record InviteUpdateUseCaseInput(String id, BaseId guestId, BaseId projectId, BaseId inviteBy) {

}
