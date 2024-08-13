package com.videocustom.videocustom.application.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.guest.Guest;

public interface GuestRepository {

    Guest create(Guest aUser);

    Guest update(Guest aUser);

    Optional<Guest> findById(BaseId anId);

    List<Guest> findAll();

    void deleteById(BaseId anId);

}
