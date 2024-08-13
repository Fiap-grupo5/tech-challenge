package com.videocustom.application.usecases.project.retrieve.list;


import com.videocustom.application.domain.pagination.Page;
import com.videocustom.application.domain.pagination.Pagination;
import com.videocustom.application.repositories.ProjectRepository;
import com.videocustom.application.usecases.project.retrieve.list.ProjectListUseCase;
import com.videocustom.application.usecases.project.retrieve.list.ProjectListUseCaseOutput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProjectListUseCase extends ProjectListUseCase {

    private final ProjectRepository projectRepository;

    @Override
    public Pagination<ProjectListUseCaseOutput> execute(final Page page) {
        return projectRepository.findAll(page).mapItems(ProjectListUseCaseOutput::from);
    }

}
