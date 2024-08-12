package com.videocustom.domain.port.in;

import com.videocustom.domain.model.User;
import com.videocustom.domain.model.CreateUserCommand;
import com.videocustom.domain.model.UpdateUserCommand;

import java.util.List;
import java.util.UUID;

public interface UserPort {
    User createUser(CreateUserCommand command);
    void deleteUser(UUID userId);
    List<User> listUsers();
    User updateUser(UpdateUserCommand command);
}
