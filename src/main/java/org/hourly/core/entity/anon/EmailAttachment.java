package org.hourly.core.entity.anon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.hourly.core.model.Updateable;


/**
 * The persistent class for the attachment database table.
 */
@Entity
@Table(name = "email_attachment")
@NamedQuery(name="EmailAttachment.findAll", query="SELECT e FROM EmailAttachment e")
public class EmailAttachment extends Updateable {
	
	@Column(name="content_type")
	private String contentType;

	@Column(name="file_type")
	private String fileType;
	
	private String name;
	
	private String path;
	
	@ManyToOne
	@JoinColumn( name = "email_id", nullable = false, insertable = true, updatable = false )
	private EmailMessage email;
	
	public EmailAttachment() {
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
