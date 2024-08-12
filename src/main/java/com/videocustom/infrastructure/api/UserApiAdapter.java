package com.videocustom.infrastructure.api;

import com.videocustom.application.service.UserService;
import com.videocustom.domain.model.CreateUserCommand;
import com.videocustom.domain.model.UpdateUserCommand;
import com.videocustom.domain.model.User;
import com.videocustom.domain.port.in.UserPort;
import com.videocustom.user.api.UserApi;
import com.videocustom.user.model.CreateUserDTO;
import com.videocustom.user.model.UpdateUserDTO;
import com.videocustom.user.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class UserApiAdapter implements UserApi {

    private final UserPort userPort;

    public UserApiAdapter(UserService userService) {
        this.userPort = userService;
    }

    @Override
    public ResponseEntity<UserDTO> createUser(CreateUserDTO body) {
        try {
            User user = userPort.createUser(new CreateUserCommand(body.getName(), body.getEmail(), body.getPassword()));
            return ResponseEntity.status(201).body(toDTO(user));
        } catch (RuntimeException e) {
            UserDTO errorDTO = new UserDTO();
            errorDTO.setName("Erro: " + e.getMessage());
            return ResponseEntity.status(400).body(errorDTO);
        }
    }

    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") UUID userId) {
        userPort.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<UserDTO>> listUsers() {
        List<UserDTO> users = userPort.listUsers().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(@PathVariable("userId") UUID userId, @RequestBody UpdateUserDTO body) {
        try {
            User user = userPort.updateUser(new UpdateUserCommand(userId, body.getName(), body.getPassword()));
            return ResponseEntity.ok(toDTO(user));
        } catch (RuntimeException e) {
            UserDTO errorDTO = new UserDTO();
            errorDTO.setName("Erro: " + e.getMessage());
            return ResponseEntity.status(400).body(errorDTO);
        }
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
    }
}

