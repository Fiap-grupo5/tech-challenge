package com.videocustom.videocustom.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videocustom.videocustom.infrastructure.persistence.entities.UserJPAEntity;

public interface UserJPARepository extends JpaRepository<UserJPAEntity, String> {

}
