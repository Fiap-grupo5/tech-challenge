package com.videocustom.model.video;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoDAO {
    private List<Video> videos = new ArrayList<>();
    private AtomicInteger idGenerator = new AtomicInteger(1);
    public void addVideo(Video video) {
        video.setId(videos.size() + 1); // Simplesmente incrementa o ID
        videos.add(video);
    }

    public Optional<Video> getVideoById(int id) {
        return videos.stream().filter(video -> video.getId() == id).findFirst();
    }
    public void updateVideo(Video updatedVideo) {
        getVideoById(updatedVideo.getId()).ifPresent(videos -> {
            updatedVideo.setName(updatedVideo.getName());
            updatedVideo.setDescription(updatedVideo.getDescription());
            updatedVideo.setStatus(updatedVideo.getStatus());
            updatedVideo.setUrl(updatedVideo.getUrl());
        });
    }

    public void deleteVideo(int id) {
        videos.removeIf(video -> video.getId() == id);
    }
}
