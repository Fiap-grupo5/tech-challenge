package com.videocustom.videocustom.application.usecases.login;

import com.videocustom.videocustom.application.domain.login.Login;
import com.videocustom.videocustom.application.usecases.UseCase;
import com.videocustom.videocustom.application.usecases.login.LoginUseCaseInput;
import com.videocustom.videocustom.application.usecases.login.LoginUseCaseOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultLoginUseCase extends UseCase<LoginUseCaseInput, Optional<LoginUseCaseOutput>> {

    private final Login loginService;

    @Override
    public Optional<LoginUseCaseOutput> execute(LoginUseCaseInput input) {
        return loginService.verifyCredentials(input.email(), input.password())
                .map(LoginUseCaseOutput::from);
    }
}
