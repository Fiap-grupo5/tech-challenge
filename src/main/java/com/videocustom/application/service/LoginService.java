package com.videocustom.application.service;

import com.videocustom.domain.model.User;
import com.videocustom.domain.port.in.UserPort;
import com.videocustom.login.model.LoginDTO;
import com.videocustom.login.model.RequestLoginDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserPort userPort;

    public LoginService(UserPort userPort) {
        this.userPort = userPort;
    }

    public Optional<LoginDTO> login(RequestLoginDTO requestLoginDTO) {
        for (User user : userPort.listUsers()) {
            if (user.getEmail().equals(requestLoginDTO.getEmail()) &&
                    user.getPassword().equals(requestLoginDTO.getPassword())) {


                LoginDTO loginDTO = new LoginDTO();
                loginDTO.setId(user.getId());
                loginDTO.setName(user.getName());
                loginDTO.setEmail(user.getEmail());
                loginDTO.setIsGuest(false);
                loginDTO.setCreatedAt(user.getCreatedAt());
                loginDTO.setUpdatedAt(user.getUpdatedAt());
                return Optional.of(loginDTO);
            }
        }
        return Optional.empty();
    }
}
