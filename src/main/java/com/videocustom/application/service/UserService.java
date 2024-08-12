package com.videocustom.application.service;

import com.videocustom.domain.model.User;
import com.videocustom.domain.model.CreateUserCommand;
import com.videocustom.domain.model.UpdateUserCommand;
import com.videocustom.domain.port.in.UserPort;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserPort {

    private final List<User> users = new ArrayList<>();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User createUser(CreateUserCommand command) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(command.getEmail())) {
                throw new RuntimeException("Usuário já cadastrado com este e-mail.");
            }
        }

        // String encryptedPassword = passwordEncoder.encode(command.getPassword());
        String plainPassword = command.getPassword();

        User user = new User(
                UUID.randomUUID(),
                command.getName(),
                command.getEmail(),
                plainPassword,
                OffsetDateTime.now(),
                OffsetDateTime.now()
        );
        users.add(user);
        System.out.println("User created: " + user);
        return user;
    }

    @Override
    public void deleteUser(UUID userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public User updateUser(UpdateUserCommand command) {
        for (User user : users) {
            if (user.getId().equals(command.getId())) {
                user.setName(command.getName());

                // String encryptedPassword = passwordEncoder.encode(command.getPassword());
                String plainPassword = command.getPassword();

                user.setPassword(plainPassword);
                user.setUpdatedAt(OffsetDateTime.now());
                return user;
            }
        }
        throw new RuntimeException("User not found");
    }
}
