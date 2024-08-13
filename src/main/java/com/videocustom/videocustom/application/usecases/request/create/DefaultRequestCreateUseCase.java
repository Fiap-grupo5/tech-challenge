package com.videocustom.videocustom.application.usecases.request.create;

import com.videocustom.videocustom.application.domain.request.Request;
import com.videocustom.videocustom.application.repositories.RequestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRequestCreateUseCase extends RequestCreateUseCase {

    private final RequestRepository requestRepository;

    @Override
    public RequestCreateUseCaseOutput execute(RequestCreateUseCaseInput input) {
        final var newRequest = Request.newRequest(input.description(), input.videoId(), input.time(), input.requestBy());
        final var request = requestRepository.create(newRequest);
        return RequestCreateUseCaseOutput.from(request);
    }

}
