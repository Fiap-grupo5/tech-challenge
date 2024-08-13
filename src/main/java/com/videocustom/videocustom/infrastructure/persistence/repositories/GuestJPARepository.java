package com.videocustom.videocustom.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videocustom.videocustom.infrastructure.persistence.entities.GuestJPAEntity;

public interface GuestJPARepository extends JpaRepository<GuestJPAEntity, String> {

}
