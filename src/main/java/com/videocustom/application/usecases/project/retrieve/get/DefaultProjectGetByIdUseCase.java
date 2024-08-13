package com.videocustom.application.usecases.project.retrieve.get;

import com.videocustom.application.domain.project.ProjectId;
import com.videocustom.application.exceptions.NotFoundException;
import com.videocustom.application.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectGetByIdUseCase extends ProjectyGetByIdUseCase {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectGetByIdUseCaseOutput execute(String input) {
        final var projectId = ProjectId.from(input);

        return projectRepository.findById(projectId)
                .map(ProjectGetByIdUseCaseOutput::from)
                .orElseThrow(() -> new NotFoundException("Project with ID %s not found.".formatted(projectId)));
    }

}
