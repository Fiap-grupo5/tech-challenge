package com.videocustom.application.usecases.project.create;


import com.videocustom.application.domain.project.Project;
import com.videocustom.application.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectCreateUseCase extends ProjectCreateUseCase {

    private final ProjectRepository projectRepository;

    public ProjectCreateUseCaseOutput execute(ProjectCreateUseCaseInput input) {
        final var newProject = Project.newProject(input.name(), input.description(), input.status(), input.active());
        final Project project = projectRepository.create(newProject);
        return ProjectCreateUseCaseOutput.from(project);
    }

}
