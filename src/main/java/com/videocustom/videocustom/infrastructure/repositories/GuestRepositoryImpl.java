package com.videocustom.videocustom.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.guest.Guest;
import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.repositories.GuestRepository;
import com.videocustom.videocustom.infrastructure.persistence.entities.GuestJPAEntity;
import com.videocustom.videocustom.infrastructure.persistence.repositories.GuestJPARepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GuestRepositoryImpl implements GuestRepository {

    private final GuestJPARepository guestJPARepository;

    @Override
    @Transactional
    public Guest create(final Guest aGuest) {
        return save(aGuest);
    }

    @Override
    public List<Guest> findAll() {
        return guestJPARepository.findAll().stream().map(GuestJPAEntity::toGuest).toList();
    }

    @Override
    public Optional<Guest> findById(final BaseId anId) {
        return guestJPARepository.findById(anId.value()).map(GuestJPAEntity::toGuest);
    }

    @Override
    @Transactional
    public void deleteById(final BaseId anId) {
        guestJPARepository.deleteById(anId.value());
    }

    @Override
    @Transactional
    public Guest update(final Guest aGuest) {
        return save(aGuest);
    }

    @Override
    public Optional<Guest> findByEmailAndPassword(String email, String password) {
        return guestJPARepository.findAll().stream()
                .filter(guestEntity -> guestEntity.getEmail().equals(email) && guestEntity.getPassword().equals(password))
                .map(GuestJPAEntity::toGuest)
                .findFirst();
    }

    private Guest save(final Guest guest) {
        return guestJPARepository.save(GuestJPAEntity.of(guest)).toGuest();
    }

}
