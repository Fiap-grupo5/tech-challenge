package com.videocustom.videocustom.application.usecases.video.update;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.VideoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultVideoUpdateUseCase extends VideoUpdateUseCase {

    private final VideoRepository videoRepository;

    @Override
    public VideoUpdateUseCaseOutput execute(VideoUpdateUseCaseInput input) {
        final var videoId = BaseId.from(input.id());

        final var video = videoRepository.findById(videoId)
                .orElseThrow(() -> new NotFoundException("Project with ID %s not found.".formatted(videoId)));

        video.update(input.name(), input.description(), input.status(), input.createdBy(), input.projectId(), input.url());
        this.videoRepository.update(video);

        return VideoUpdateUseCaseOutput.from(video);
    }

}
