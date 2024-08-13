package com.videocustom.videocustom.application.usecases.project.retrieve.list;

import java.util.List;

import com.videocustom.videocustom.application.repositories.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectListUseCase extends ProjectListUseCase {

    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectListUseCaseOutput> execute() {
        return projectRepository.findAll().stream()
                .map(ProjectListUseCaseOutput::from)
                .toList();
    }

}
