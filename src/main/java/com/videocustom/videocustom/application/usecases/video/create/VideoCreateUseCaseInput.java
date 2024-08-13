package com.videocustom.videocustom.application.usecases.video.create;

import com.videocustom.videocustom.application.domain.base.BaseId;

public record VideoCreateUseCaseInput(String name, String description, BaseId createdBy, BaseId projectId, String url) {

}
