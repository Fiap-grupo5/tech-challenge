package com.videocustom.videocustom.application.usecases.video.retrieve.list;

import java.util.List;

import com.videocustom.videocustom.application.repositories.VideoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultVideoListUseCase extends VideoListUseCase {

    private final VideoRepository videoRepository;

    @Override
    public List<VideoListUseCaseOutput> execute() {
        return videoRepository.findAll().stream()
                .map(VideoListUseCaseOutput::from)
                .toList();
    }

}
