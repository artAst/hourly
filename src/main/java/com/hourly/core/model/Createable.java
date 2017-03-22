package com.hourly.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hourly.util.IdConverter;

/**
 * The base class of all objects within the model.
 */
@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(EntityTimestampListener.class)
public abstract class Createable implements Serializable {

    /**
     * The unique value that identifies the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    @Access(AccessType.PROPERTY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_created", nullable = false, updatable = false)
    private Date timeCreated;

    /**
     * Returns this object's hashcode.
     */
    @Override
    public int hashCode() {
        return id == 0 ? super.hashCode() : getClass().hashCode() ^ Long.valueOf(id).hashCode();
    }

    /**
     * Returns true if that object equals this object.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || obj != null && obj.getClass().equals(getClass()) && ((Createable) obj).id == id;
    }

    /**
     * Returns the id of the entity.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id of the entity.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the id of the entity as an obfuscated string.
     */
    public String getStringId() {
        return IdConverter.fromId(getId());
    }

    /**
     * Returns the creation time of the entity.
     */
    public Date getTimeCreated() {
        return timeCreated;
    }

    /**
     * Sets the creation time of the entity.
     */
    protected void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }
}
