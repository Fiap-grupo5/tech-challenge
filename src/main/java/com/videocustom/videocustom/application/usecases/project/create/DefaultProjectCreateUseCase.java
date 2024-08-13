package com.videocustom.videocustom.application.usecases.project.create;

import com.videocustom.videocustom.application.domain.project.Project;
import com.videocustom.videocustom.application.repositories.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectCreateUseCase extends ProjectCreateUseCase {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectCreateUseCaseOutput execute(ProjectCreateUseCaseInput input) {
        final var newProject = Project.newProject(input.name(), input.description(), input.createdBy());
        final var project = projectRepository.create(newProject);
        return ProjectCreateUseCaseOutput.from(project);
    }

}
