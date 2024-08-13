package com.videocustom.infrastructure.repositories;

import com.videocustom.application.domain.pagination.Page;
import com.videocustom.application.domain.project.Project;
import com.videocustom.application.domain.project.ProjectId;
import com.videocustom.application.repositories.ProjectRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImpl implements ProjectRepository  {


    @Override
    @Transactional
    public Project create(Project eProject) {
        return null;
    }

    @Override
    public Project update(Project eProject) {
        return null;
    }

    @Override
    public Optional<Project> findById(ProjectId anId) {
        return Optional.empty();
    }

    @Override
    public List<Project> findAll(Page page) {
        return null;
    }

    @Override
    public void deleteById(ProjectId anId) {

    }
}
