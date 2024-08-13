package com.videocustom.videocustom.application.usecases.invite.create;

import com.videocustom.videocustom.application.domain.base.BaseId;

public record InviteCreateUseCaseInput(BaseId guestId, BaseId projectId, BaseId inviteBy) {

}
