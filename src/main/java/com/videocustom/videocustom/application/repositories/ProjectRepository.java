package com.videocustom.videocustom.application.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.project.Project;

public interface ProjectRepository {

    Project create(Project aProject);

    Project update(Project aProject);

    Optional<Project> findById(BaseId anId);

    List<Project> findAll();

    void deleteById(BaseId anId);

}
