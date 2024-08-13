package com.videocustom.videocustom.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videocustom.videocustom.infrastructure.persistence.entities.RequestJPAEntity;

public interface RequestJPARepository extends JpaRepository<RequestJPAEntity, String> {

}
