package com.videocustom.videocustom.infrastructure.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.videocustom.project.api.ProjectApi;
import com.videocustom.project.model.ProjectDTO;
import com.videocustom.project.model.CreateProjectDTO;
import com.videocustom.project.model.UpdateProjectDTO;
import com.videocustom.videocustom.application.usecases.project.create.ProjectCreateUseCase;
import com.videocustom.videocustom.application.usecases.project.delete.ProjectDeleteUseCase;
import com.videocustom.videocustom.application.usecases.project.retrieve.get.ProjectGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.project.retrieve.list.ProjectListUseCase;
import com.videocustom.videocustom.application.usecases.project.update.ProjectUpdateUseCase;
import com.videocustom.videocustom.infrastructure.mappers.ProjectMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProjectController implements ProjectApi {

    private final ProjectCreateUseCase projectCreateUseCase;
    private final ProjectListUseCase projectListUseCase;
    private final ProjectGetByIdUseCase projectGetByIdUseCase;
    private final ProjectDeleteUseCase projectDeleteUseCase;
    private final ProjectUpdateUseCase projectUpdateUseCase;
    private final ProjectMapper projectMapper;

    @Override
    public ResponseEntity<ProjectDTO> createProject(final CreateProjectDTO body) {
        final var useCaseInput = projectMapper.fromDTO(body);
        final var useCaseOutput = projectCreateUseCase.execute(useCaseInput);
        return ResponseEntity.ok(projectMapper.toDTO(useCaseOutput));
    }

    @Override
    public ResponseEntity<Void> deleteProject(final UUID projectId) {
        projectDeleteUseCase.execute(projectId.toString());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProjectDTO> getProject(final UUID projectId) {
        final var output = projectMapper.toDTO(projectGetByIdUseCase.execute(projectId.toString()));
        return ResponseEntity.ok(output);
    }

    @Override
    public ResponseEntity<ProjectDTO> updateProject(final UUID projectId, final UpdateProjectDTO body) {
        final var input = projectMapper.fromDTO(projectId.toString(), body);
        final var output = projectUpdateUseCase.execute(input);
        return ResponseEntity.ok(projectMapper.toDTO(output));
    }

    @Override
    public ResponseEntity<List<ProjectDTO>> listProjects() {
        return ResponseEntity.ok(projectMapper.toDTO(projectListUseCase.execute()));
    }

}
