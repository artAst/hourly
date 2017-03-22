package org.hourly.core.entity.anon;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Handles and determines the status value that should be assigned to the entity.
 */
public class EmailMessageStatusListener {
	
	/**
     * Sets the entity status before the persist process.
     */
    @PrePersist
    public void prePersist(EmailMessage email) {
    	if(email.getStatus() == null) {
    		email.setStatus(EmailMessageStatus.ACTIVE);
    	}
    }
    
    /**
     * Sets the entity status before the update process.
     */
    @PreUpdate
    public void preUpdate(EmailMessage email) {
    	if(email.getStatus() == null) {
    		email.setStatus(EmailMessageStatus.ACTIVE);
    	}
    }
}
