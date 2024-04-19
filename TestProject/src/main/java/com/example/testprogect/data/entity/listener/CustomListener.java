package com.example.testprogect.data.entity.listener;

import com.example.testprogect.data.entity.ListenerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

public class CustomListener {
    private final Logger LOGGER = LoggerFactory.getLogger(CustomListener.class);

    @PostLoad
    public void postLoad(ListenerEntity listenerEntity){
        LOGGER.info("[postLoad] called!!");
    }
    @PrePersist
    public void prePersist(ListenerEntity listenerEntity) {
        LOGGER.info("[prePersist] called!!");
    }

    @PostPersist
    public void postPersist(ListenerEntity listenerEntity) {
        LOGGER.info("[postPersist] called!!");
    }

    @PreUpdate
    public void preUpdate(ListenerEntity listenerEntity) {
        LOGGER.info("[preUpdate] called!!");
    }

    @PostUpdate
    public void postUpdate(ListenerEntity listenerEntity) {
        LOGGER.info("[postUpdate] called!!");
    }

    @PreRemove
    public void preRemove(ListenerEntity listenerEntity) {
        LOGGER.info("[preRemove] called!!");
    }

    @PostRemove
    public void postRemove(ListenerEntity listenerEntity) {
        LOGGER.info("[postRemove] called!!");
    }

}
