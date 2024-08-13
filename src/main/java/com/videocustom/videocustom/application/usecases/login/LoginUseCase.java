package com.videocustom.videocustom.application.usecases.login;

import com.videocustom.videocustom.application.usecases.UseCase;
import com.videocustom.login.model.LoginDTO;
import com.videocustom.login.model.RequestLoginDTO;

import java.util.Optional;

public abstract class LoginUseCase extends UseCase<RequestLoginDTO, Optional<LoginDTO>> {
}
