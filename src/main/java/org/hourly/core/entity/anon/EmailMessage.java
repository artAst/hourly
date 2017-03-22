package org.hourly.core.entity.anon;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hourly.core.model.Updateable;

/**
 * The persistent class for the Email database table.
 */
@Entity
@EntityListeners({ EmailMessageStatusListener.class })
@Table(name = "email")
@NamedQuery(name = "EmailMessage.findAll", query="SELECT a FROM EmailMessage a")
public class EmailMessage extends Updateable {
	
	// From
	@OneToOne( targetEntity = User.class )
	@JoinColumn( name = "from_user_id" )
	private User from;
	
	// To
	@OneToMany
	@JoinTable( name = "email_to_user", joinColumns = @JoinColumn( name = "email_id" ), inverseJoinColumns = @JoinColumn( name = "to_user_id" ) )
	private List<User> to;
	
	// Attachments
	@OneToMany(mappedBy="email")
	private List<EmailAttachment> attachments;
	
	// Message Content
	private String messageContent;
	
	@Enumerated(EnumType.STRING)
	private EmailMessageStatus status;
	
	public EmailMessage() {
	}

	public EmailMessageStatus getStatus() {
		return status;
	}

	public void setStatus(EmailMessageStatus status) {
		this.status = status;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
}
