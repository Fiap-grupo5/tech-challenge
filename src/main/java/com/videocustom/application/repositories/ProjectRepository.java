package com.videocustom.application.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.application.domain.pagination.Page;
import com.videocustom.application.domain.pagination.Pagination;
import com.videocustom.application.domain.project.Project;
import com.videocustom.application.domain.project.ProjectId;

public interface ProjectRepository {

    Project create(Project aProject);

    Project update(Project aProject);

    Optional<Project> findById(ProjectId anId);

    Pagination<Project> findAll(Page page);

    void deleteById(ProjectId anId);

}