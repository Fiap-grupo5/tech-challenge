package com.videocustom.application.usecases.project.delete;

import com.videocustom.application.domain.project.ProjectId;
import com.videocustom.application.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectDeleteUseCase extends ProjectDeleteUseCase {

    private final ProjectRepository projectRepository;

    @Override
    public void execute(final String input) {
        final var projectId = ProjectId.from(input);
        projectRepository.deleteById(projectId);
    }

}
