package com.videocustom.videocustom.application.domain.guest;

import java.time.Instant;
import java.util.Objects;

import com.videocustom.videocustom.application.domain.base.BaseId;

import lombok.Getter;

@Getter
public class Guest {
    private BaseId id;
    private String name;
    private String email;
    private String password;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Guest(final BaseId id, final String name, final String email, final String password,
            final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Guest newGuest(final String name, final String email, final String password) {
        final var id = BaseId.generate();
        final var now = Instant.now();
        return new Guest(id, name, email, password, now, now, null);
    }

    public static Guest with(final BaseId id, final String name, final String email,
            final String password, final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        return new Guest(id, name, email, password, createdAt, updatedAt, deletedAt);
    }

    public Guest update(final String name, final String email, final String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.updatedAt = Instant.now();
        return this;
    }
}
