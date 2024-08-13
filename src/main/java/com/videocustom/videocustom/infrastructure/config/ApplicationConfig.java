package com.videocustom.videocustom.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.videocustom.videocustom.application.repositories.UserRepository;
import com.videocustom.videocustom.application.usecases.user.create.UserCreateUseCase;
import com.videocustom.videocustom.application.usecases.user.create.DefaultUserCreateUseCase;
import com.videocustom.videocustom.application.usecases.user.delete.UserDeleteUseCase;
import com.videocustom.videocustom.application.usecases.user.delete.DefaultUserDeleteUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.get.UserGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.get.DefaultUserGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.list.UserListUseCase;
import com.videocustom.videocustom.application.usecases.user.retrieve.list.DefaultUserListUseCase;
import com.videocustom.videocustom.application.usecases.user.update.UserUpdateUseCase;
import com.videocustom.videocustom.application.usecases.user.update.DefaultUserUpdateUseCase;
import com.videocustom.videocustom.infrastructure.persistence.repositories.UserJPARepository;
import com.videocustom.videocustom.infrastructure.repositories.UserRepositoryImpl;

import com.videocustom.videocustom.application.repositories.GuestRepository;
import com.videocustom.videocustom.application.usecases.guest.create.GuestCreateUseCase;
import com.videocustom.videocustom.application.usecases.guest.create.DefaultGuestCreateUseCase;
import com.videocustom.videocustom.application.usecases.guest.delete.DefaultGuestDeleteUseCase;
import com.videocustom.videocustom.application.usecases.guest.delete.GuestDeleteUseCase;
import com.videocustom.videocustom.application.usecases.guest.retrieve.get.GuestGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.guest.retrieve.get.DefaultGuestGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.guest.retrieve.list.GuestListUseCase;
import com.videocustom.videocustom.application.usecases.guest.retrieve.list.DefaultGuestListUseCase;
import com.videocustom.videocustom.application.usecases.guest.update.GuestUpdateUseCase;
import com.videocustom.videocustom.application.usecases.guest.update.DefaultGuestUpdateUseCase;
import com.videocustom.videocustom.infrastructure.persistence.repositories.GuestJPARepository;
import com.videocustom.videocustom.infrastructure.repositories.GuestRepositoryImpl;

import com.videocustom.videocustom.application.repositories.ProjectRepository;
import com.videocustom.videocustom.application.usecases.project.create.ProjectCreateUseCase;
import com.videocustom.videocustom.application.usecases.project.create.DefaultProjectCreateUseCase;
import com.videocustom.videocustom.application.usecases.project.delete.DefaultProjectDeleteUseCase;
import com.videocustom.videocustom.application.usecases.project.delete.ProjectDeleteUseCase;
import com.videocustom.videocustom.application.usecases.project.retrieve.get.ProjectGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.project.retrieve.get.DefaultProjectGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.project.retrieve.list.ProjectListUseCase;
import com.videocustom.videocustom.application.usecases.project.retrieve.list.DefaultProjectListUseCase;
import com.videocustom.videocustom.application.usecases.project.update.ProjectUpdateUseCase;
import com.videocustom.videocustom.application.usecases.project.update.DefaultProjectUpdateUseCase;
import com.videocustom.videocustom.infrastructure.persistence.repositories.ProjectJPARepository;
import com.videocustom.videocustom.infrastructure.repositories.ProjectRepositoryImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserRepository userRepository(final UserJPARepository userJPARepository) {
        return new UserRepositoryImpl(userJPARepository);
    }

    @Bean
    public UserCreateUseCase userCreateUseCase(final UserRepository userRepository) {
        return new DefaultUserCreateUseCase(userRepository);
    }

    @Bean
    public UserListUseCase userListUseCase(final UserRepository userRepository) {
        return new DefaultUserListUseCase(userRepository);
    }

    @Bean
    public UserGetByIdUseCase userGetByIdUseCase(final UserRepository userRepository) {
        return new DefaultUserGetByIdUseCase(userRepository);
    }

    @Bean
    public UserDeleteUseCase userDeleteUseCase(final UserRepository userRepository) {
        return new DefaultUserDeleteUseCase(userRepository);
    }

    @Bean
    public UserUpdateUseCase userUpdateUseCase(final UserRepository userRepository) {
        return new DefaultUserUpdateUseCase(userRepository);
    }

    @Bean
    public GuestRepository guestRepository(final GuestJPARepository guestJPARepository) {
        return new GuestRepositoryImpl(guestJPARepository);
    }

    @Bean
    public GuestCreateUseCase guestCreateUseCase(final GuestRepository guestRepository) {
        return new DefaultGuestCreateUseCase(guestRepository);
    }

    @Bean
    public GuestListUseCase guestListUseCase(final GuestRepository guestRepository) {
        return new DefaultGuestListUseCase(guestRepository);
    }

    @Bean
    public GuestGetByIdUseCase GuestGetByIdUseCase(final GuestRepository guestRepository) {
        return new DefaultGuestGetByIdUseCase(guestRepository);
    }

    @Bean
    public GuestDeleteUseCase GuestDeleteUseCase(final GuestRepository guestRepository) {
        return new DefaultGuestDeleteUseCase(guestRepository);
    }

    @Bean
    public GuestUpdateUseCase guestUpdateUseCase(final GuestRepository guestRepository) {
        return new DefaultGuestUpdateUseCase(guestRepository);
    }

    @Bean
    public ProjectRepository projectRepository(final ProjectJPARepository projectRepository, final UserJPARepository userRepository) {
        return new ProjectRepositoryImpl(projectRepository, userRepository);
    }

    @Bean
    public ProjectCreateUseCase projectCreateUseCase(final ProjectRepository projectRepository) {
        return new DefaultProjectCreateUseCase(projectRepository);
    }

    @Bean
    public ProjectListUseCase projectListUseCase(final ProjectRepository projectRepository) {
        return new DefaultProjectListUseCase(projectRepository);
    }

    @Bean
    public ProjectGetByIdUseCase ProjectGetByIdUseCase(final ProjectRepository projectRepository) {
        return new DefaultProjectGetByIdUseCase(projectRepository);
    }

    @Bean
    public ProjectDeleteUseCase ProjectDeleteUseCase(final ProjectRepository projectRepository) {
        return new DefaultProjectDeleteUseCase(projectRepository);
    }

    @Bean
    public ProjectUpdateUseCase projectUpdateUseCase(final ProjectRepository projectRepository) {
        return new DefaultProjectUpdateUseCase(projectRepository);
    }
}
