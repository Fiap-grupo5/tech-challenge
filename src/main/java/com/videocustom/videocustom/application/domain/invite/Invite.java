package com.videocustom.videocustom.application.domain.invite;

import java.time.Instant;
import java.util.Objects;

import com.videocustom.videocustom.application.domain.base.BaseId;

import lombok.Getter;

@Getter
public class Invite {
    private BaseId id;
    private BaseId guestId;
    private BaseId projectId;
    private BaseId inviteBy;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Invite(final BaseId id, final BaseId guestId, final BaseId projectId,
            final BaseId inviteBy, final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.guestId = Objects.requireNonNull(guestId, "id cannot be null");
        this.projectId = Objects.requireNonNull(projectId, "id cannot be null");
        this.inviteBy = Objects.requireNonNull(inviteBy, "id cannot be null");
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Invite newInvite(final BaseId guestId, final BaseId projectId, final BaseId inviteBy) {
        final var id = BaseId.generate();
        final var now = Instant.now();
        return new Invite(id, guestId, projectId, inviteBy, now, now, null);
    }

    public static Invite with(final BaseId id, final BaseId guestId, final BaseId projectId, final BaseId inviteBy, 
        final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
        return new Invite(id, guestId, projectId, inviteBy, createdAt, updatedAt, deletedAt);
    }

    public Invite update(final BaseId guestId, final BaseId projectId, final BaseId inviteBy) {
        this.guestId = guestId;
        this.projectId = projectId;
        this.inviteBy = inviteBy;
        this.updatedAt = Instant.now();
        return this;
    }
}
