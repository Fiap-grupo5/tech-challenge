package com.videocustom.infrastructure.config;

import com.videocustom.application.repositories.ProjectRepository;
import com.videocustom.application.usecases.project.create.DefaultProjectCreateUseCase;
import com.videocustom.application.usecases.project.delete.DefaultProjectDeleteUseCase;
import com.videocustom.application.usecases.project.delete.ProjectDeleteUseCase;
import com.videocustom.application.usecases.project.retrieve.get.DefaultProjectGetByIdUseCase;
import com.videocustom.application.usecases.project.retrieve.get.ProjectyGetByIdUseCase;
import com.videocustom.application.usecases.project.retrieve.list.DefaultProjectListUseCase;
import com.videocustom.application.usecases.project.retrieve.list.ProjectListUseCase;
import com.videocustom.application.usecases.project.update.DefaultProjectUpdateUseCase;
import com.videocustom.application.usecases.project.update.ProjectUpdateUseCase;
import com.videocustom.infrastructure.persistence.repositories.ProjectJPARepository;
import com.videocustom.infrastructure.repositories.ProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
     public ProjectRepository projectRepository(final ProjectJPARepository projectJPARepository) {
        //return new ProjectRepositoryImpl(projectJPARepository);
        return null;
    }
    @Bean
   public DefaultProjectCreateUseCase projectCreateUseCase(final ProjectRepository projectRepository) {
        return new DefaultProjectCreateUseCase(projectRepository);
   }

    @Bean
    public ProjectListUseCase projectListUseCase(final ProjectRepository projectRepository) {
       return new DefaultProjectListUseCase(projectRepository);
    }

    @Bean
    public ProjectyGetByIdUseCase projectGetByIdUseCase(final ProjectRepository projectRepository) {
        return new DefaultProjectGetByIdUseCase(projectRepository);
    }

    @Bean
    public ProjectDeleteUseCase projectDeleteUseCase(final ProjectRepository projectRepository) {
        return new DefaultProjectDeleteUseCase(projectRepository);
    }

    @Bean
    public ProjectUpdateUseCase projectUpdateUseCase(final ProjectRepository projectRepository) {
       return new DefaultProjectUpdateUseCase(projectRepository);
    }
}