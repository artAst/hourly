package com.hourly.core.model;

import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * External timestamp updater.
 */
@Component
public class EntityTimestampListener {

    @PrePersist
    public void prePersist(Createable createable) {
        Date now = new Date();
        createable.setTimeCreated(now);
        if (createable instanceof Updateable) {
            ((Updateable) createable).setTimeUpdated(now);
        }
    }

    @PreUpdate
    public void preUpdate(Updateable updateable) {
        updateable.setTimeUpdated(new Date());
    }
}
