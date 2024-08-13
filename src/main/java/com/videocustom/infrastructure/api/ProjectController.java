package com.videocustom.infrastructure.api;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    //private final ProjectCreateUseCase projectCreateUseCase;
   // private final ProjectListUseCase projectListUseCase;
   // private final ProjectGetByIdUseCase projectGetByIdUseCase;
   // private final ProjectDeleteUseCase projectDeleteUseCase;
  //  private final ProjectUpdateUseCase projectUpdateUseCase;
   // private final ProjectMapper projectMapper;

    //@Override
    //public ResponseEntity<ProjectDTO> createCategory(final CreateProjectDTO body) {
    //    final var useCaseInput = projectMapper.fromDTO(body);
    //    final var useCaseOutput = projectCreateUseCase.execute(useCaseInput);
     //   return ResponseEntity.ok(projectMapper.toDTO(useCaseOutput));
 //   }

   // @Override
    //public ResponseEntity<Void> deleteCategory(final UUID categoryId) {
        //projectDeleteUseCase.execute(categoryId.toString());
        //return ResponseEntity.noContent().build();
   // }

   // @Override
    //public ResponseEntity<ProjectDTO> getCategory(final UUID categoryId) {
       // final var output = projectMapper.toDTO(projectGetByIdUseCase.execute(categoryId.toString()));
       // return ResponseEntity.ok((ProjectDTO) output);
   // }

   // @Override
    //public ResponseEntity<ProjectDTO> updateCategory(final UUID categoryId, final UpdateProjectDTO body) {
      //  final var input = projectMapper.fromDTO(categoryId.toString(), body);
      //  final var output = projectUpdateUseCase.execute(input);
       // return ResponseEntity.ok(projectMapper.toDTO(output));
  //  }

   // @Override
    //public ResponseEntity<List<ProjectDTO>> listCategories() {
   //     return ResponseEntity.ok(projectMapper.toDTO(projectListUseCase.execute()));
    //}

}
