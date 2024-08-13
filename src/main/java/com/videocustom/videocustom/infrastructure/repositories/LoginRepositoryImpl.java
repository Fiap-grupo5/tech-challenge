package com.videocustom.videocustom.infrastructure.persistence.repositories;

import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.repositories.LoginRepository;
import com.videocustom.videocustom.infrastructure.persistence.entities.UserJPAEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoginRepositoryImpl implements LoginRepository {

    private final UserJPARepository userJPARepository;

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userJPARepository.findAll().stream()
                .filter(userEntity -> userEntity.getEmail().equals(email) && userEntity.getPassword().equals(password))
                .map(UserJPAEntity::toUser)
                .findFirst();
    }
}
