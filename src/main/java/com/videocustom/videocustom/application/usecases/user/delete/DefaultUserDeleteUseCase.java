package com.videocustom.videocustom.application.usecases.user.delete;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultUserDeleteUseCase extends UserDeleteUseCase {

    private final UserRepository userRepository;

    @Override
    public void execute(final String input) {
        final var userId = BaseId.from(input);
        userRepository.deleteById(userId);
    }

}
