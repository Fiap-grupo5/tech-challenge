package com.videocustom.videocustom.application.usecases.project.create;

import com.videocustom.videocustom.application.domain.base.BaseId;

public record ProjectCreateUseCaseInput(String name, String description, BaseId createdBy) {

}
