package com.videocustom.videocustom.infrastructure.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.videocustom.user.api.UserApi;
import com.videocustom.user.model.UserDTO;
import com.videocustom.user.model.CreateUserDTO;
import com.videocustom.user.model.UpdateUserDTO;
import com.videocustom.videocustom.application.usecases.user.create.UserCreateUseCase;
import com.videocustom.videocustom.application.usecases.user.delete.UserDeleteUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.get.UserGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.list.UserListUseCase;
import com.videocustom.videocustom.application.usecases.user.update.UserUpdateUseCase;
import com.videocustom.videocustom.infrastructure.mappers.UserMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserCreateUseCase userCreateUseCase;
    private final UserListUseCase userListUseCase;
    private final UserGetByIdUseCase userGetByIdUseCase;
    private final UserDeleteUseCase userDeleteUseCase;
    private final UserUpdateUseCase userUpdateUseCase;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<UserDTO> createUser(final CreateUserDTO body) {
        final var useCaseInput = userMapper.fromDTO(body);
        final var useCaseOutput = userCreateUseCase.execute(useCaseInput);
        return ResponseEntity.ok(userMapper.toDTO(useCaseOutput));
    }

    @Override
    public ResponseEntity<Void> deleteUser(final UUID userId) {
        userDeleteUseCase.execute(userId.toString());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDTO> getUser(final UUID userId) {
        final var output = userMapper.toDTO(userGetByIdUseCase.execute(userId.toString()));
        return ResponseEntity.ok(output);
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(final UUID userId, final UpdateUserDTO body) {
        final var input = userMapper.fromDTO(userId.toString(), body);
        final var output = userUpdateUseCase.execute(input);
        return ResponseEntity.ok(userMapper.toDTO(output));
    }

    @Override
    public ResponseEntity<List<UserDTO>> listUsers() {
        return ResponseEntity.ok(userMapper.toDTO(userListUseCase.execute()));
    }

}
