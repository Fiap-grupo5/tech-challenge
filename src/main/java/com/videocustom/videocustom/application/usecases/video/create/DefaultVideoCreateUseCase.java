package com.videocustom.videocustom.application.usecases.video.create;

import com.videocustom.videocustom.application.domain.video.Video;
import com.videocustom.videocustom.application.repositories.VideoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultVideoCreateUseCase extends VideoCreateUseCase {

    private final VideoRepository videoRepository;

    @Override
    public VideoCreateUseCaseOutput execute(VideoCreateUseCaseInput input) {
        final var newVideo = Video.newVideo(input.name(), input.description(), input.projectId(), input.url(), input.createdBy());
        final var video = videoRepository.create(newVideo);
        return VideoCreateUseCaseOutput.from(video);
    }

}
