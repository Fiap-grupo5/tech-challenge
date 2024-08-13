package com.videocustom.videocustom.application.repositories;

import java.util.List;
import java.util.Optional;

import com.videocustom.videocustom.application.domain.base.BaseId;
import com.videocustom.videocustom.application.domain.request.Request;

public interface RequestRepository {

    Request create(Request aRequest);

    Request update(Request aRequest);

    Optional<Request> findById(BaseId anId);

    List<Request> findAll();

    void deleteById(BaseId anId);

}
