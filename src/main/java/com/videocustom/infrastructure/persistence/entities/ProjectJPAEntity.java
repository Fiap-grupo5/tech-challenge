package com.videocustom.infrastructure.persistence.entities;

import com.videocustom.application.domain.project.Project;
import com.videocustom.application.domain.project.ProjectId;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public static ProjectJPAEntity of(final Project project) {
      return null;
    }

    public Project toProject() {
        return Project.with(ProjectId.from(id), name, description, status, active, createdAt, updatedAt, deletedAt);
    }
}
