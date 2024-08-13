package com.videocustom.videocustom.application.usecases.request.delete;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.RequestRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRequestDeleteUseCase extends RequestDeleteUseCase {

    private final RequestRepository requestRepository;

    @Override
    public void execute(final String input) {
        final var requestId = BaseId.from(input);
        requestRepository.deleteById(requestId);
    }

}
