package com.videocustom.videocustom.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videocustom.videocustom.infrastructure.persistence.entities.ProjectJPAEntity;

public interface ProjectJPARepository extends JpaRepository<ProjectJPAEntity, String> {

}
