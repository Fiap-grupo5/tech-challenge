package com.videocustom.videocustom.application.usecases.request.update;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.RequestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRequestUpdateUseCase extends RequestUpdateUseCase {

    private final RequestRepository requestRepository;

    @Override
    public RequestUpdateUseCaseOutput execute(RequestUpdateUseCaseInput input) {
        final var requestId = BaseId.from(input.id());

        final var request = requestRepository.findById(requestId)
                .orElseThrow(() -> new NotFoundException("Request with ID %s not found.".formatted(requestId)));

        request.update(input.description(), input.videoId(), input.time(), input.requestBy());
        this.requestRepository.update(request);

        return RequestUpdateUseCaseOutput.from(request);
    }

}
