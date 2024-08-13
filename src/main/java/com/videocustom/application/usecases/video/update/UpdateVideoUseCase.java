package com.videocustom.application.usecases.video.update;

import com.videocustom.application.domain.video.Video;
import com.videocustom.application.domain.video.VideoStatus;
import com.videocustom.infrastructure.persistence.VideoRepository;

import java.util.UUID;

public class UpdateVideoUseCase {
    private final VideoRepository videoRepository;

    public UpdateVideoUseCase(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video updateVideo(UUID id, String name, String description, String url, VideoStatus status) {
        Video video = videoRepository.findById(id);
        video.update(name, description, url, status);
        videoRepository.save(video);
        return video;
    }
}

