package com.videocustom.videocustom.application.usecases.user.update;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultUserUpdateUseCase extends UserUpdateUseCase {

    private final UserRepository userRepository;

    @Override
    public UserUpdateUseCaseOutput execute(UserUpdateUseCaseInput input) {
        final var userId = BaseId.from(input.id());

        final var user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("user with ID %s not found.".formatted(userId)));

        user.update(input.name(), input.email(), input.password());
        this.userRepository.update(user);

        return UserUpdateUseCaseOutput.from(user);
    }

}
