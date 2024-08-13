package com.videocustom.videocustom.application.usecases.user.create;

import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultUserCreateUseCase extends UserCreateUseCase {

    private final UserRepository userRepository;

    @Override
    public UserCreateUseCaseOutput execute(UserCreateUseCaseInput input) {
        final var newUser = User.newUser(input.name(), input.email(), input.password());
        final var user = userRepository.create(newUser);
        return UserCreateUseCaseOutput.from(user);
    }

}
