package com.videocustom.infrastructure.persistence.repositories;

import com.videocustom.infrastructure.persistence.entities.ProjectJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJPARepository extends JpaRepository<ProjectJPAEntity, String> {

}
