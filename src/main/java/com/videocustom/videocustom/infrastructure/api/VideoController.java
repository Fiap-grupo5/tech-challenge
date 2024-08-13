package com.videocustom.videocustom.infrastructure.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.videocustom.video.api.VideoApi;
import com.videocustom.video.model.VideoDTO;
import com.videocustom.video.model.CreateVideoDTO;
import com.videocustom.video.model.UpdateVideoDTO;
import com.videocustom.videocustom.application.usecases.video.create.VideoCreateUseCase;
import com.videocustom.videocustom.application.usecases.video.delete.VideoDeleteUseCase;
import com.videocustom.videocustom.application.usecases.video.retrieve.get.VideoGetByIdUseCase;
import com.videocustom.videocustom.application.usecases.video.retrieve.list.VideoListUseCase;
import com.videocustom.videocustom.application.usecases.video.update.VideoUpdateUseCase;
import com.videocustom.videocustom.infrastructure.mappers.VideoMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class VideoController implements VideoApi {

    private final VideoCreateUseCase videoCreateUseCase;
    private final VideoListUseCase videoListUseCase;
    private final VideoGetByIdUseCase videoGetByIdUseCase;
    private final VideoDeleteUseCase videoDeleteUseCase;
    private final VideoUpdateUseCase videoUpdateUseCase;
    private final VideoMapper videoMapper;

    @Override
    public ResponseEntity<VideoDTO> createVideo(final CreateVideoDTO body) {
        final var useCaseInput = videoMapper.fromDTO(body);
        final var useCaseOutput = videoCreateUseCase.execute(useCaseInput);
        return ResponseEntity.ok(videoMapper.toDTO(useCaseOutput));
    }

    @Override
    public ResponseEntity<Void> deleteVideo(final UUID videoId) {
        videoDeleteUseCase.execute(videoId.toString());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<VideoDTO> getVideo(final UUID videoId) {
        final var output = videoMapper.toDTO(videoGetByIdUseCase.execute(videoId.toString()));
        return ResponseEntity.ok(output);
    }

    @Override
    public ResponseEntity<VideoDTO> updateVideo(final UUID videoId, final UpdateVideoDTO body) {
        final var input = videoMapper.fromDTO(videoId.toString(), body);
        final var output = videoUpdateUseCase.execute(input);
        return ResponseEntity.ok(videoMapper.toDTO(output));
    }

    @Override
    public ResponseEntity<List<VideoDTO>> listVideos() {
        return ResponseEntity.ok(videoMapper.toDTO(videoListUseCase.execute()));
    }

}
