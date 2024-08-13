package com.videocustom.videocustom.application.usecases.video.delete;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.VideoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultVideoDeleteUseCase extends VideoDeleteUseCase {

    private final VideoRepository videoRepository;

    @Override
    public void execute(final String input) {
        final var videoId = BaseId.from(input);
        videoRepository.deleteById(videoId);
    }

}
