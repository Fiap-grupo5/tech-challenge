package com.videocustom.videocustom.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videocustom.videocustom.infrastructure.persistence.entities.VideoJPAEntity;

public interface VideoJPARepository extends JpaRepository<VideoJPAEntity, String> {

}
