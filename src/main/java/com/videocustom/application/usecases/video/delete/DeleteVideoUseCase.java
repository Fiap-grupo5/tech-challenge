package com.videocustom.application.usecases.video.delete;

import com.videocustom.application.domain.video.Video;
import com.videocustom.infrastructure.persistence.VideoRepository;

import java.util.UUID;

public class DeleteVideoUseCase {
    private final VideoRepository videoRepository;

    public DeleteVideoUseCase(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public void deleteVideo(UUID id) {
        Video video = videoRepository.findById(id);
        video.markAsDeleted();
        videoRepository.save(video);
    }
}

