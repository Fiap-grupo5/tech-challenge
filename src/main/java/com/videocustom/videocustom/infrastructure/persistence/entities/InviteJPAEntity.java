package com.videocustom.videocustom.infrastructure.persistence.entities;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.invite.Invite;
import com.videocustom.videocustom.application.domain.base.BaseId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "invites")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class InviteJPAEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private GuestJPAEntity guestId;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectJPAEntity projectId;

    @ManyToOne
    @JoinColumn(name = "invite_by", nullable = false)
    private UserJPAEntity inviteBy;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public static InviteJPAEntity of(Invite newInvite, GuestJPAEntity guestIdEntity, ProjectJPAEntity projectIdEntity, UserJPAEntity inviteByEntity) {
        return new InviteJPAEntity(newInvite.getId().value(),
                                    guestIdEntity,
                                    projectIdEntity,
                                    inviteByEntity,
                                    newInvite.getCreatedAt(), 
                                    newInvite.getUpdatedAt(),
                                    newInvite.getDeletedAt());
    }

    public Invite toInvite() {
        return Invite.with(BaseId.from(id), BaseId.from(guestId.getId()), BaseId.from(projectId.getId()), BaseId.from(inviteBy.getId()), createdAt, updatedAt, deletedAt);
    }
}
