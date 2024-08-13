package com.videocustom.videocustom.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.UserRepository;
import com.videocustom.videocustom.infrastructure.persistence.entities.UserJPAEntity;
import com.videocustom.videocustom.infrastructure.persistence.repositories.UserJPARepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJPARepository userJPARepository;

    @Override
    @Transactional
    public User create(final User aUser) {
        return save(aUser);
    }

    @Override
    public List<User> findAll() {
        return userJPARepository.findAll().stream().map(UserJPAEntity::toUser).toList();
    }

    @Override
    public Optional<User> findById(final BaseId anId) {
        return userJPARepository.findById(anId.value()).map(UserJPAEntity::toUser);
    }

    @Override
    @Transactional
    public void deleteById(final BaseId anId) {
        userJPARepository.deleteById(anId.value());
    }

    @Override
    @Transactional
    public User update(final User aUser) {
        return save(aUser);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userJPARepository.findAll().stream()
                .filter(userEntity -> userEntity.getEmail().equals(email) && userEntity.getPassword().equals(password))
                .map(UserJPAEntity::toUser)
                .findFirst();
    }

    private User save(final User user) {
        return userJPARepository.save(UserJPAEntity.of(user)).toUser();
    }

}
