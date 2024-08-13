package com.videocustom.videocustom.application.usecases.project.retrieve.get;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectGetByIdUseCase extends ProjectGetByIdUseCase {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectGetByIdUseCaseOutput execute(String input) {
        final var projectId = BaseId.from(input);

        return projectRepository.findById(projectId)
                .map(ProjectGetByIdUseCaseOutput::from)
                .orElseThrow(() -> new NotFoundException("Project with ID %s not found.".formatted(projectId)));
    }

}
