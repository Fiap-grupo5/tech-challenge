package com.videocustom.videocustom.application.repositories;

import com.videocustom.videocustom.application.domain.user.User;
import com.videocustom.videocustom.application.domain.base.BaseId;

import java.util.List;
import java.util.Optional;

public interface LoginRepository {

    Optional<User> findByEmailAndPassword(String email, String password);
}
