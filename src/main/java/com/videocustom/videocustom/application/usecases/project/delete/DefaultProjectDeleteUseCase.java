package com.videocustom.videocustom.application.usecases.project.delete;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectDeleteUseCase extends ProjectDeleteUseCase {

    private final ProjectRepository projectRepository;

    @Override
    public void execute(final String input) {
        final var projectId = BaseId.from(input);
        projectRepository.deleteById(projectId);
    }

}
