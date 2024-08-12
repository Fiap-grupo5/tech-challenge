package com.videocustom.infrastructure.api;

import com.videocustom.application.service.LoginService;
import com.videocustom.login.model.LoginDTO;
import com.videocustom.login.model.RequestLoginDTO;
import com.videocustom.infrastructure.api.generated.login.LoginApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginApiAdapter implements LoginApi {

    private final LoginService loginService;

    public LoginApiAdapter(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public ResponseEntity<LoginDTO> login(@RequestBody RequestLoginDTO body) {
        return loginService.login(body)
                .map(loginDTO -> ResponseEntity.ok(loginDTO))
                .orElseGet(() -> ResponseEntity.status(401)
                        .body(createErrorMessage("Credenciais incorretas")));
    }

    private LoginDTO createErrorMessage(String message) {
        LoginDTO errorDTO = new LoginDTO();
        errorDTO.setName(message);
        return errorDTO;
    }
}
