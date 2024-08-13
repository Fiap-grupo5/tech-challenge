package com.videocustom.application.usecases.video.create;

import com.videocustom.application.domain.project.Project;
import com.videocustom.application.domain.video.Video;
import com.videocustom.application.repositories.ProjectRepository;
import com.videocustom.application.usecases.project.create.ProjectCreateUseCaseInput;
import com.videocustom.application.usecases.project.create.ProjectCreateUseCaseOutput;
import com.videocustom.infrastructure.persistence.VideoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultVideoCreateUseCase extends CreateVideoUseCase{

    private final ProjectRepository projectRepository;

   public CreateVideoUseCaseOutput execute(CreateVideoUseCaseInput input) {
        final var newProject = Project.newProject(input.name(), input.description(), input.status(), input.active());
        final Project project = projectRepository.create(newProject);
        return CreateVideoUseCaseOutput.from(project);
    }
    }
    
