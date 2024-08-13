package com.videocustom.videocustom.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.request.Request;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.RequestRepository;
import com.videocustom.videocustom.infrastructure.persistence.entities.RequestJPAEntity;
import com.videocustom.videocustom.infrastructure.persistence.repositories.RequestJPARepository;
import com.videocustom.videocustom.infrastructure.persistence.repositories.VideoJPARepository;
import com.videocustom.videocustom.infrastructure.persistence.repositories.GuestJPARepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequestRepositoryImpl implements RequestRepository {

    private final RequestJPARepository requestJPARepository;
    private final VideoJPARepository videoJPARepository;
    private final GuestJPARepository guestJPARepository;

    @Override
    @Transactional
    public Request create(final Request aRequest) {
        return save(aRequest);
    }

    @Override
    public List<Request> findAll() {
        return requestJPARepository.findAll().stream().map(RequestJPAEntity::toRequest).toList();
    }

    @Override
    public Optional<Request> findById(final BaseId anId) {
        return requestJPARepository.findById(anId.value()).map(RequestJPAEntity::toRequest);
    }

    @Override
    @Transactional
    public void deleteById(final BaseId anId) {
        requestJPARepository.deleteById(anId.value());
    }

    @Override
    @Transactional
    public Request update(final Request aRequest) {
        return save(aRequest);
    }

    private Request save(final Request request) {
        var videoJPA = videoJPARepository.findById(request.getVideoId().value())
        .orElseThrow(() -> new RuntimeException("Video not found."));
        var guestJPA = guestJPARepository.findById(request.getRequestBy().value())
        .orElseThrow(() -> new RuntimeException("Guest not found."));
        return requestJPARepository.save(RequestJPAEntity.of(request, videoJPA, guestJPA)).toRequest();
    }

}
