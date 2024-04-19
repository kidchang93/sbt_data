package com.example.testprogect.service;

import com.example.testprogect.data.entity.ListenerEntity;

public interface ListenerService {
    ListenerEntity getEntity(Long id);

    void saveEntity(ListenerEntity listenerEntity);

    void updateEntity(ListenerEntity listenerEntity);

    void removeEntity(ListenerEntity listenerEntity);
}
