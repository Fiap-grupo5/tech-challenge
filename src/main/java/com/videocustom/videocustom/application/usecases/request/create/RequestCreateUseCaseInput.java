package com.videocustom.videocustom.application.usecases.request.create;

import com.videocustom.videocustom.application.domain.base.BaseId;

public record RequestCreateUseCaseInput(String description, BaseId videoId, Integer time, BaseId requestBy) {

}
