package com.videocustom.videocustom.infrastructure.persistence.entities;

import java.time.Instant;

import com.videocustom.videocustom.application.domain.project.Project;
import com.videocustom.videocustom.application.domain.project.ProjectStatus;
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
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class ProjectJPAEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProjectStatus status;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private UserJPAEntity createdBy;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public static ProjectJPAEntity of(Project newProject, UserJPAEntity createdByEntity) {
        return new ProjectJPAEntity(newProject.getId().value(),
                                    newProject.getName(), 
                                    newProject.getDescription(),
                                    newProject.getStatus(), 
                                    createdByEntity, 
                                    newProject.getCreatedAt(), 
                                    newProject.getUpdatedAt(),
                                    newProject.getDeletedAt());
    }

    public Project toProject() {
        return Project.with(BaseId.from(id), name, description, status, BaseId.from(createdBy.getId()), createdAt, updatedAt, deletedAt);
    }
}
