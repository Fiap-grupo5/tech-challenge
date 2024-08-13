package com.videocustom.videocustom.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.video.Video;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.VideoRepository;
import com.videocustom.videocustom.infrastructure.persistence.entities.VideoJPAEntity;
import com.videocustom.videocustom.infrastructure.persistence.repositories.VideoJPARepository;
import com.videocustom.videocustom.infrastructure.persistence.repositories.ProjectJPARepository;
import com.videocustom.videocustom.infrastructure.persistence.repositories.UserJPARepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VideoRepositoryImpl implements VideoRepository {

    private final VideoJPARepository videoJPARepository;
    private final ProjectJPARepository projectJPARepository;
    private final UserJPARepository userJPARepository;

    @Override
    @Transactional
    public Video create(final Video aVideo) {
        return save(aVideo);
    }

    @Override
    public List<Video> findAll() {
        return videoJPARepository.findAll().stream().map(VideoJPAEntity::toVideo).toList();
    }

    @Override
    public Optional<Video> findById(final BaseId anId) {
        return videoJPARepository.findById(anId.value()).map(VideoJPAEntity::toVideo);
    }

    @Override
    @Transactional
    public void deleteById(final BaseId anId) {
        videoJPARepository.deleteById(anId.value());
    }

    @Override
    @Transactional
    public Video update(final Video aVideo) {
        return save(aVideo);
    }

    private Video save(final Video video) {
        var userJPA = userJPARepository.findById(video.getCreatedBy().value())
        .orElseThrow(() -> new RuntimeException("User not found."));
        var projectJPA = projectJPARepository.findById(video.getProjectId().value())
        .orElseThrow(() -> new RuntimeException("Project not found."));
        return videoJPARepository.save(VideoJPAEntity.of(video, userJPA, projectJPA)).toVideo();
    }

}
