package com.videocustom.videocustom.application.usecases.user.retrieve.get;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.exceptions.NotFoundException;
import com.videocustom.videocustom.application.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultUserGetByIdUseCase extends UserGetByIdUseCase {

    private final UserRepository userRepository;

    @Override
    public UserGetByIdUseCaseOutput execute(String input) {
        final var userId = BaseId.from(input);

        return userRepository.findById(userId)
                .map(UserGetByIdUseCaseOutput::from)
                .orElseThrow(() -> new NotFoundException("User with ID %s not found.".formatted(userId)));
    }

}
