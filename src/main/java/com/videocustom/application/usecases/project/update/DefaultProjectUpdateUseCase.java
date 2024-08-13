package com.videocustom.application.usecases.project.update;

import com.videocustom.application.domain.project.ProjectId;
import com.videocustom.application.exceptions.NotFoundException;
import com.videocustom.application.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectUpdateUseCase extends ProjectUpdateUseCase {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectUpdateUseCaseOutput execute(ProjectUpdateUseCaseInput input) {
        final var projectId = ProjectId.from(input.id());

        final var project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NotFoundException("Project with ID %s not found.".formatted(projectId)));

        project.update(input.name(), input.description(), input.status(), input.isActive());
        this.projectRepository.update(project);

        return ProjectUpdateUseCaseOutput.from(project);
    }

}
