package com.videocustom.videocustom.application.usecases.request.update;

import com.videocustom.videocustom.application.domain.base.BaseId;

public record RequestUpdateUseCaseInput(String id, String description, BaseId videoId, Integer time, BaseId requestBy) {

}
