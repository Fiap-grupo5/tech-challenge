package com.videocustom.videocustom.application.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.user.User;

public interface UserRepository {

    User create(User aUser);

    User update(User aUser);

    Optional<User> findById(BaseId anId);

    List<User> findAll();

    void deleteById(BaseId anId);

}
