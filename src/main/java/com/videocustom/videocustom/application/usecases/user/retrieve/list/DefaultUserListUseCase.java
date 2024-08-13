package com.videocustom.videocustom.application.usecases.user.retrieve.list;

import java.util.List;

import com.videocustom.videocustom.application.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultUserListUseCase extends UserListUseCase {

    private final UserRepository userRepository;

    @Override
    public List<UserListUseCaseOutput> execute() {
        return userRepository.findAll().stream()
                .map(UserListUseCaseOutput::from)
                .toList();
    }

}
