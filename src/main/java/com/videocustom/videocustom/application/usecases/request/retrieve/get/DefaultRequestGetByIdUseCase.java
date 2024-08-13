package com.videocustom.videocustom.application.usecases.request.retrieve.get;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.RequestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRequestGetByIdUseCase extends RequestGetByIdUseCase {

    private final RequestRepository requestRepository;

    @Override
    public RequestGetByIdUseCaseOutput execute(String input) {
        final var requestId = BaseId.from(input);

        return requestRepository.findById(requestId)
                .map(RequestGetByIdUseCaseOutput::from)
                .orElseThrow(() -> new NotFoundException("Request with ID %s not found.".formatted(requestId)));
    }

}
