package com.videocustom.videocustom.application.domain.login;

import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Login {

    private final UserRepository userRepository;

    public Login(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> verifyCredentials(String email, String password) {
        return userRepository.findAll().stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }
}
