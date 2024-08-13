package com.videocustom.videocustom.application.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.video.Video;

public interface VideoRepository {

    Video create(Video aVideo);

    Video update(Video aVideo);

    Optional<Video> findById(BaseId anId);

    List<Video> findAll();

    void deleteById(BaseId anId);

}
