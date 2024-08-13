package com.videocustom.application.repositories;

import java.util.List;
import java.util.Optional;

//import com.sonnesen.productsapi.application.domain.category.Project;
//import com.sonnesen.productsapi.application.domain.category.ProjectId;
import com.videocustom.application.domain.pagination.Page;
import com.videocustom.application.domain.pagination.Pagination;
import com.videocustom.application.domain.project.Project;
import com.videocustom.application.domain.project.ProjectId;

public interface ProjectRepository {

    Project create(Project aCategory);

    Project update(Project aCategory);

    Optional<Project> findById(ProjectId anId);

    Pagination<Project> findAll(Page page);

    void deleteById(ProjectId anId);

}