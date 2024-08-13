package com.videocustom.videocustom.application.usecases.request.retrieve.list;

import java.util.List;

import com.videocustom.videocustom.application.repositories.RequestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRequestListUseCase extends RequestListUseCase {

    private final RequestRepository requestRepository;

    @Override
    public List<RequestListUseCaseOutput> execute() {
        return requestRepository.findAll().stream()
                .map(RequestListUseCaseOutput::from)
                .toList();
    }

}
