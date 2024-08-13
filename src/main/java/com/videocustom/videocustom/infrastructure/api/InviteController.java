package com.videocustom.videocustom.infrastructure.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.videocustom.invite.api.InviteApi;
import com.videocustom.invite.model.InviteDTO;
import com.videocustom.invite.model.CreateInviteDTO;
import com.videocustom.invite.model.UpdateInviteDTO;
import com.videocustom.videocustom.application.usecases.invite.create.InviteCreateUseCase;
import com.videocustom.videocustom.application.usecases.invite.delete.InviteDeleteUseCase;
import com.videocustom.videocustom.application.usecases.invite.retrieve.get.InviteGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.invite.retrieve.list.InviteListUseCase;
import com.videocustom.videocustom.application.usecases.invite.update.InviteUpdateUseCase;
import com.videocustom.videocustom.infrastructure.mappers.InviteMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class InviteController implements InviteApi {

    private final InviteCreateUseCase inviteCreateUseCase;
    private final InviteListUseCase inviteListUseCase;
    private final InviteGetByIdUseCase inviteGetByIdUseCase;
    private final InviteDeleteUseCase inviteDeleteUseCase;
    private final InviteUpdateUseCase inviteUpdateUseCase;
    private final InviteMapper inviteMapper;

    @Override
    public ResponseEntity<InviteDTO> createInvite(final CreateInviteDTO body) {
        final var useCaseInput = inviteMapper.fromDTO(body);
        final var useCaseOutput = inviteCreateUseCase.execute(useCaseInput);
        return ResponseEntity.ok(inviteMapper.toDTO(useCaseOutput));
    }

    @Override
    public ResponseEntity<Void> deleteInvite(final UUID inviteId) {
        inviteDeleteUseCase.execute(inviteId.toString());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<InviteDTO> getInvite(final UUID inviteId) {
        final var output = inviteMapper.toDTO(inviteGetByIdUseCase.execute(inviteId.toString()));
        return ResponseEntity.ok(output);
    }

    @Override
    public ResponseEntity<InviteDTO> updateInvite(final UUID inviteId, final UpdateInviteDTO body) {
        final var input = inviteMapper.fromDTO(inviteId.toString(), body);
        final var output = inviteUpdateUseCase.execute(input);
        return ResponseEntity.ok(inviteMapper.toDTO(output));
    }

    @Override
    public ResponseEntity<List<InviteDTO>> listInvites() {
        return ResponseEntity.ok(inviteMapper.toDTO(inviteListUseCase.execute()));
    }

}
