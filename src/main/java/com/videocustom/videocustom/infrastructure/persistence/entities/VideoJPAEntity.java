package com.videocustom.videocustom.infrastructure.persistence.entities;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.video.Video;
import com.videocustom.videocustom.application.domain.video.VideoStatus;
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
@Table(name = "videos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class VideoJPAEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "url", nullable = false, length = 255)
    private String url;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VideoStatus status;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private UserJPAEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectJPAEntity projectId;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public static VideoJPAEntity of(Video newVideo, UserJPAEntity createdByEntity, ProjectJPAEntity projectIdEntity) {
        return new VideoJPAEntity(newVideo.getId().value(),
                                    newVideo.getName(), 
                                    newVideo.getUrl(),
                                    newVideo.getDescription(),
                                    newVideo.getStatus(), 
                                    createdByEntity,
                                    projectIdEntity, 
                                    newVideo.getCreatedAt(), 
                                    newVideo.getUpdatedAt(),
                                    newVideo.getDeletedAt());
    }

    public Video toVideo() {
        return Video.with(BaseId.from(id), name, description, BaseId.from(projectId.getId()), url, status, BaseId.from(createdBy.getId()), createdAt, updatedAt, deletedAt);
    }
}
