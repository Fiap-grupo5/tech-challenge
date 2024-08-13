package com.videocustom.videocustom.infrastructure.persistence.entities;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.guest.Guest;
import com.videocustom.videocustom.application.domain.base.BaseId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "guests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class GuestJPAEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public static GuestJPAEntity of(Guest newGuest) {
        return new GuestJPAEntity(newGuest.getId().value(), newGuest.getName(), newGuest.getEmail(),
            newGuest.getPassword(), newGuest.getCreatedAt(), newGuest.getUpdatedAt(),
            newGuest.getDeletedAt());
    }

    public Guest toGuest() {
        return Guest.with(BaseId.from(id), name, email, password, createdAt, updatedAt, deletedAt);
    }
}
