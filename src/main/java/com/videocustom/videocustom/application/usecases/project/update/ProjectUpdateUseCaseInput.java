package com.videocustom.videocustom.application.usecases.project.update;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.project.ProjectStatus;

public record ProjectUpdateUseCaseInput(String id, String name, String description, ProjectStatus status, BaseId createdBy) {

}
