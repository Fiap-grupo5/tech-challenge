package com.videocustom.infrastructure.api;


import java.util.List;
import java.util.UUID;

import com.videocustom.application.domain.pagination.Page;
import com.videocustom.application.usecases.project.create.ProjectCreateUseCase;
import com.videocustom.application.usecases.project.delete.ProjectDeleteUseCase;
import com.videocustom.application.usecases.project.retrieve.get.ProjectyGetByIdUseCase;
import com.videocustom.application.usecases.project.retrieve.list.ProjectListUseCase;
import com.videocustom.application.usecases.project.update.ProjectUpdateUseCase;
import com.videocustom.infrastructure.mappers.ProjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

//import com.videocustom.projects.api.ProjectApi;
//import com.videocustom.projects.model.ProjectDTO;
//import com.videocustom.projects.model.CreateProjectDTO;
//import com.videocustom.projects.model.UpdateProjectDTO;


import lombok.RequiredArgsConstructor;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectCreateUseCase projectCreateUseCase;
    private final ProjectListUseCase projectListUseCase;
    private final ProjectyGetByIdUseCase projectGetByIdUseCase;
    private final ProjectDeleteUseCase projectDeleteUseCase;
    private final ProjectUpdateUseCase projectUpdateUseCase;
    private final ProjectMapper projectMapper;

        //public ResponseEntity<ProjectDTO> createProject(final CreateProjectDTO body) {
        //final var useCaseInput = projectMapper.fromDTO(body);
        //final var useCaseOutput = projectCreateUseCase.execute(useCaseInput);
       //return ResponseEntity.ok(projectMapper.toDTO(useCaseOutput));
    //}

    public ResponseEntity<Void> deleteProject(final UUID projectId) {
        projectDeleteUseCase.execute(projectId.toString());
        return ResponseEntity.noContent().build();
    }

    //public ResponseEntity<ProjectDTO> getProject(final UUID projectId) {
      //  final var output = projectMapper.toDTO(projectGetByIdUseCase.execute(projectId.toString()));
        //return ResponseEntity.ok((ProjectDTO) output);
    //}

    //public ResponseEntity<ProjectDTO> updateProject(final UUID projectId, final UpdateProjectDTO body) {
      //  final var input = projectMapper.fromDTO(projectId.toString(), body);
        //final var output = projectUpdateUseCase.execute(input);
        //return ResponseEntity.ok(projectMapper.toDTO(output));
    //}

    //public ResponseEntity<PaginatedProjectsDTO> listProjects(final Integer page, final Integer perPage) {
      //  Pagination<ProjectDTO> projects = projectListUseCase.execute(new Page(page, perPage)).mapItems(projectMapper::toDTO);

        //PaginatedProjectssDTO paginatedProjects = new PaginatedProjectssDTO()
          //      .items(projects.items())
            //    .page(projects.currentPage())
              //  .perPage(projects.perPage())
                //.total(projects.total());

       // return ResponseEntity.ok(paginatedProjects);
    //}

}
