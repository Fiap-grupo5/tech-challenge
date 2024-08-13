package com.videocustom.videocustom.application.usecases.video.retrieve.get;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.VideoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultVideoGetByIdUseCase extends VideoGetByIdUseCase {

    private final VideoRepository videoRepository;

    @Override
    public VideoGetByIdUseCaseOutput execute(String input) {
        final var videoId = BaseId.from(input);

        return videoRepository.findById(videoId)
                .map(VideoGetByIdUseCaseOutput::from)
                .orElseThrow(() -> new NotFoundException("Video with ID %s not found.".formatted(videoId)));
    }

}
