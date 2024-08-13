package com.videocustom.videocustom.application.usecases.login;

import com.videocustom.videocustom.application.domain.login.Login;
import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.domain.guest.Guest;
import com.videocustom.videocustom.application.repositories.UserRepository;
import com.videocustom.videocustom.application.repositories.GuestRepository;
import com.videocustom.videocustom.application.usecases.UseCase;
import com.videocustom.videocustom.application.usecases.login.LoginUseCaseInput;
import com.videocustom.videocustom.application.usecases.login.LoginUseCaseOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultLoginUseCase extends UseCase<LoginUseCaseInput, Optional<LoginUseCaseOutput>> {

    private final UserRepository userRepository;
    private final GuestRepository guestRepository;

    @Override
    public Optional<LoginUseCaseOutput> execute(LoginUseCaseInput input) {
        Optional<User> user = userRepository.findByEmailAndPassword(input.email(), input.password());
        if (user.isPresent()) {
            return Optional.of(LoginUseCaseOutput.from(user.get()));
        }

        Optional<Guest> guest = guestRepository.findByEmailAndPassword(input.email(), input.password());
        return guest.map(LoginUseCaseOutput::from);
    }
}
