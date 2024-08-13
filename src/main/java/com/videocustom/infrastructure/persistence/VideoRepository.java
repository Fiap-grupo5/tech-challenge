package com.videocustom.infrastructure.persistence;

import java.util.UUID;

import com.videocustom.application.domain.video.Video;

public interface VideoRepository {
    void save(Video video);
    Video findById(UUID id);
}

