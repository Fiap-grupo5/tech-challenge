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

import com.videocustom.videocustom.application.repositories.VideoRepository;
import com.videocustom.videocustom.application.usecases.video.create.VideoCreateUseCase;
import com.videocustom.videocustom.application.usecases.video.create.DefaultVideoCreateUseCase;
import com.videocustom.videocustom.application.usecases.video.delete.DefaultVideoDeleteUseCase;
import com.videocustom.videocustom.application.usecases.video.delete.VideoDeleteUseCase;
import com.videocustom.videocustom.application.usecases.video.retrieve.get.VideoGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.video.retrieve.get.DefaultVideoGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.video.retrieve.list.VideoListUseCase;
import com.videocustom.videocustom.application.usecases.video.retrieve.list.DefaultVideoListUseCase;
import com.videocustom.videocustom.application.usecases.video.update.VideoUpdateUseCase;
import com.videocustom.videocustom.application.usecases.video.update.DefaultVideoUpdateUseCase;
import com.videocustom.videocustom.infrastructure.persistence.repositories.VideoJPARepository;
import com.videocustom.videocustom.infrastructure.repositories.VideoRepositoryImpl;

import com.videocustom.videocustom.application.repositories.RequestRepository;
import com.videocustom.videocustom.application.usecases.request.create.RequestCreateUseCase;
import com.videocustom.videocustom.application.usecases.request.create.DefaultRequestCreateUseCase;
import com.videocustom.videocustom.application.usecases.request.delete.DefaultRequestDeleteUseCase;
import com.videocustom.videocustom.application.usecases.request.delete.RequestDeleteUseCase;
import com.videocustom.videocustom.application.usecases.request.retrieve.get.RequestGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.request.retrieve.get.DefaultRequestGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.request.retrieve.list.RequestListUseCase;
import com.videocustom.videocustom.application.usecases.request.retrieve.list.DefaultRequestListUseCase;
import com.videocustom.videocustom.application.usecases.request.update.RequestUpdateUseCase;
import com.videocustom.videocustom.application.usecases.request.update.DefaultRequestUpdateUseCase;
import com.videocustom.videocustom.infrastructure.persistence.repositories.RequestJPARepository;
import com.videocustom.videocustom.infrastructure.repositories.RequestRepositoryImpl;

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
    public GuestGetByIdUseCase guestGetByIdUseCase(final GuestRepository guestRepository) {
        return new DefaultGuestGetByIdUseCase(guestRepository);
    }

    @Bean
    public GuestDeleteUseCase guestDeleteUseCase(final GuestRepository guestRepository) {
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
    public ProjectGetByIdUseCase projectGetByIdUseCase(final ProjectRepository projectRepository) {
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

    @Bean
    public VideoRepository videoRepository(final VideoJPARepository videoRepository, final UserJPARepository userRepository, final ProjectJPARepository projectRepository) {
        return new VideoRepositoryImpl(videoRepository, projectRepository, userRepository);
    }

    @Bean
    public VideoCreateUseCase videoCreateUseCase(final VideoRepository videoRepository) {
        return new DefaultVideoCreateUseCase(videoRepository);
    }

    @Bean
    public VideoListUseCase videoListUseCase(final VideoRepository videoRepository) {
        return new DefaultVideoListUseCase(videoRepository);
    }

    @Bean
    public VideoGetByIdUseCase videoGetByIdUseCase(final VideoRepository videoRepository) {
        return new DefaultVideoGetByIdUseCase(videoRepository);
    }

    @Bean
    public VideoDeleteUseCase videoDeleteUseCase(final VideoRepository videoRepository) {
        return new DefaultVideoDeleteUseCase(videoRepository);
    }

    @Bean
    public VideoUpdateUseCase videoUpdateUseCase(final VideoRepository videoRepository) {
        return new DefaultVideoUpdateUseCase(videoRepository);
    }

    @Bean
    public RequestRepository requestRepository(final RequestJPARepository requestRepository, final VideoJPARepository videoRepository, final GuestJPARepository guestRepository) {
        return new RequestRepositoryImpl(requestRepository, videoRepository, guestRepository);
    }

    @Bean
    public RequestCreateUseCase requestCreateUseCase(final RequestRepository requestRepository) {
        return new DefaultRequestCreateUseCase(requestRepository);
    }

    @Bean
    public RequestListUseCase requestListUseCase(final RequestRepository requestRepository) {
        return new DefaultRequestListUseCase(requestRepository);
    }

    @Bean
    public RequestGetByIdUseCase requestGetByIdUseCase(final RequestRepository requestRepository) {
        return new DefaultRequestGetByIdUseCase(requestRepository);
    }

    @Bean
    public RequestDeleteUseCase requestDeleteUseCase(final RequestRepository requestRepository) {
        return new DefaultRequestDeleteUseCase(requestRepository);
    }

    @Bean
    public RequestUpdateUseCase requestUpdateUseCase(final RequestRepository requestRepository) {
        return new DefaultRequestUpdateUseCase(requestRepository);
    }
}
