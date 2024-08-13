package com.videocustom.infrastructure.persistence;


import com.videocustom.infrastructure.persistence.VideoRepository;
import com.videocustom.application.domain.video.Video;

import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

public class JpaVideoRepository implements VideoRepository {
    private final Map<UUID, Video> database = new HashMap<>();

    @Override
    public void save(Video video) {
        database.put(video.getId(), video);
    }

    @Override
    public Video findById(UUID id) {
        return database.get(id);
    }
}

