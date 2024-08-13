package com.videocustom.videocustom.infrastructure.api;

import com.videocustom.videocustom.application.usecases.login.DefaultLoginUseCase;
import com.videocustom.videocustom.infrastructure.mappers.LoginMapper;
import com.videocustom.login.model.LoginDTO;
import com.videocustom.login.model.RequestLoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final DefaultLoginUseCase loginUseCase;
    private final LoginMapper loginMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginDTO> login(@RequestBody RequestLoginDTO body) {
        var useCaseInput = loginMapper.toUseCaseInput(body);

        return loginUseCase.execute(useCaseInput)
                .map(loginMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(401)
                        .body(createErrorMessage("Credenciais incorretas")));
    }

    private LoginDTO createErrorMessage(String message) {
        LoginDTO errorDTO = new LoginDTO();
        errorDTO.setName(message);
        return errorDTO;
    }
}
