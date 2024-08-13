package com.videocustom.videocustom.application.usecases.video.update;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.video.VideoStatus;

public record VideoUpdateUseCaseInput(String id, String name, String description, VideoStatus status, BaseId createdBy, BaseId projectId, String url) {

}
