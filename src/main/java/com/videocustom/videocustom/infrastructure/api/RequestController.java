package com.videocustom.videocustom.infrastructure.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.videocustom.request.api.RequestApi;
import com.videocustom.request.model.RequestDTO;
import com.videocustom.request.model.CreateRequestDTO;
import com.videocustom.request.model.UpdateRequestDTO;
import com.videocustom.videocustom.application.usecases.request.create.RequestCreateUseCase;
import com.videocustom.videocustom.application.usecases.request.delete.RequestDeleteUseCase;
import com.videocustom.videocustom.application.usecases.request.retrieve.get.RequestGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.request.retrieve.list.RequestListUseCase;
import com.videocustom.videocustom.application.usecases.request.update.RequestUpdateUseCase;
import com.videocustom.videocustom.infrastructure.mappers.RequestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RequestController implements RequestApi {

    private final RequestCreateUseCase requestCreateUseCase;
    private final RequestListUseCase requestListUseCase;
    private final RequestGetByIdUseCase requestGetByIdUseCase;
    private final RequestDeleteUseCase requestDeleteUseCase;
    private final RequestUpdateUseCase requestUpdateUseCase;
    private final RequestMapper requestMapper;

    @Override
    public ResponseEntity<RequestDTO> createRequest(final CreateRequestDTO body) {
        final var useCaseInput = requestMapper.fromDTO(body);
        final var useCaseOutput = requestCreateUseCase.execute(useCaseInput);
        return ResponseEntity.ok(requestMapper.toDTO(useCaseOutput));
    }

    @Override
    public ResponseEntity<Void> deleteRequest(final UUID requestId) {
        requestDeleteUseCase.execute(requestId.toString());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<RequestDTO> getRequest(final UUID requestId) {
        final var output = requestMapper.toDTO(requestGetByIdUseCase.execute(requestId.toString()));
        return ResponseEntity.ok(output);
    }

    @Override
    public ResponseEntity<RequestDTO> updateRequest(final UUID requestId, final UpdateRequestDTO body) {
        final var input = requestMapper.fromDTO(requestId.toString(), body);
        final var output = requestUpdateUseCase.execute(input);
        return ResponseEntity.ok(requestMapper.toDTO(output));
    }

    @Override
    public ResponseEntity<List<RequestDTO>> listRequests() {
        return ResponseEntity.ok(requestMapper.toDTO(requestListUseCase.execute()));
    }

}
