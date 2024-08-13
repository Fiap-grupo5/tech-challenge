package com.videocustom.videocustom.application.usecases.project.update;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectUpdateUseCase extends ProjectUpdateUseCase {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectUpdateUseCaseOutput execute(ProjectUpdateUseCaseInput input) {
        final var projectId = BaseId.from(input.id());

        final var project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NotFoundException("Project with ID %s not found.".formatted(projectId)));

        project.update(input.name(), input.description(), input.status(), input.createdBy());
        this.projectRepository.update(project);

        return ProjectUpdateUseCaseOutput.from(project);
    }

}
