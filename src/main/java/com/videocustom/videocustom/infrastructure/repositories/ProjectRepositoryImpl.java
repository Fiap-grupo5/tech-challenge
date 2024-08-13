package com.videocustom.videocustom.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.project.Project;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.ProjectRepository;
import com.videocustom.videocustom.infrastructure.persistence.entities.ProjectJPAEntity;
import com.videocustom.videocustom.infrastructure.persistence.repositories.ProjectJPARepository;
import com.videocustom.videocustom.infrastructure.persistence.repositories.UserJPARepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepository {

    private final ProjectJPARepository projectJPARepository;
    private final UserJPARepository userJPARepository;

    @Override
    @Transactional
    public Project create(final Project aProject) {
        return save(aProject);
    }

    @Override
    public List<Project> findAll() {
        return projectJPARepository.findAll().stream().map(ProjectJPAEntity::toProject).toList();
    }

    @Override
    public Optional<Project> findById(final BaseId anId) {
        return projectJPARepository.findById(anId.value()).map(ProjectJPAEntity::toProject);
    }

    @Override
    @Transactional
    public void deleteById(final BaseId anId) {
        projectJPARepository.deleteById(anId.value());
    }

    @Override
    @Transactional
    public Project update(final Project aProject) {
        return save(aProject);
    }

    private Project save(final Project project) {
        var userJPA = userJPARepository.findById(project.getCreatedBy().value())
        .orElseThrow(() -> new RuntimeException("User not found."));
        return projectJPARepository.save(ProjectJPAEntity.of(project, userJPA)).toProject();
    }

}
