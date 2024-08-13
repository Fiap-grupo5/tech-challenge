package com.videocustom.videocustom.infrastructure.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.videocustom.guest.api.GuestApi;
import com.videocustom.guest.model.GuestDTO;
import com.videocustom.guest.model.CreateGuestDTO;
import com.videocustom.guest.model.UpdateGuestDTO;
import com.videocustom.videocustom.application.usecases.guest.create.GuestCreateUseCase;
import com.videocustom.videocustom.application.usecases.guest.delete.GuestDeleteUseCase;
import com.videocustom.videocustom.application.usecases.guest.retrieve.get.GuestGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.guest.retrieve.list.GuestListUseCase;
import com.videocustom.videocustom.application.usecases.guest.update.GuestUpdateUseCase;
import com.videocustom.videocustom.infrastructure.mappers.GuestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GuestController implements GuestApi {

    private final GuestCreateUseCase guestCreateUseCase;
    private final GuestListUseCase guestListUseCase;
    private final GuestGetByIdUseCase guestGetByIdUseCase;
    private final GuestDeleteUseCase guestDeleteUseCase;
    private final GuestUpdateUseCase guestUpdateUseCase;
    private final GuestMapper guestMapper;

    @Override
    public ResponseEntity<GuestDTO> createGuest(final CreateGuestDTO body) {
        final var useCaseInput = guestMapper.fromDTO(body);
        final var useCaseOutput = guestCreateUseCase.execute(useCaseInput);
        return ResponseEntity.ok(guestMapper.toDTO(useCaseOutput));
    }

    @Override
    public ResponseEntity<Void> deleteGuest(final UUID guestId) {
        guestDeleteUseCase.execute(guestId.toString());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<GuestDTO> getGuest(final UUID guestId) {
        final var output = guestMapper.toDTO(guestGetByIdUseCase.execute(guestId.toString()));
        return ResponseEntity.ok(output);
    }

    @Override
    public ResponseEntity<GuestDTO> updateGuest(final UUID guestId, final UpdateGuestDTO body) {
        final var input = guestMapper.fromDTO(guestId.toString(), body);
        final var output = guestUpdateUseCase.execute(input);
        return ResponseEntity.ok(guestMapper.toDTO(output));
    }

    @Override
    public ResponseEntity<List<GuestDTO>> listGuests() {
        return ResponseEntity.ok(guestMapper.toDTO(guestListUseCase.execute()));
    }

}
