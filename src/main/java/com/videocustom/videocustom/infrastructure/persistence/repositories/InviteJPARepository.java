package com.videocustom.videocustom.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videocustom.videocustom.infrastructure.persistence.entities.InviteJPAEntity;

public interface InviteJPARepository extends JpaRepository<InviteJPAEntity, String> {

}
