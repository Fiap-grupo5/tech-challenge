package com.videocustom.videocustom.infrastructure.persistence.entities;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.request.Request;
import com.videocustom.videocustom.application.domain.base.BaseId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "requests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class RequestJPAEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private String id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private VideoJPAEntity videoId;

    @Column(name = "time", nullable = false)
    private Integer time;

    @ManyToOne
    @JoinColumn(name = "request_by", nullable = false)
    private GuestJPAEntity requestBy;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public static RequestJPAEntity of(Request newRequest, VideoJPAEntity videoIdEntity, GuestJPAEntity requestByEntity) {
        return new RequestJPAEntity(newRequest.getId().value(),
                                    newRequest.getDescription(),
                                    videoIdEntity,
                                    newRequest.getTime(),
                                    requestByEntity,
                                    newRequest.getCreatedAt(), 
                                    newRequest.getUpdatedAt(),
                                    newRequest.getDeletedAt());
    }

    public Request toRequest() {
        return Request.with(BaseId.from(id), description, BaseId.from(videoId.getId()), time, BaseId.from(requestBy.getId()), createdAt, updatedAt, deletedAt);
    }
}
