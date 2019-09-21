package com.nino.mail.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SendEmail {
	
	@NotEmpty
	private String recipient;
	
	@NotEmpty
	private String emissary;
	
	@NotNull
	private String bodyText;
	
	@NotEmpty
	private String subjectText;
	
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getEmissary() {
		return emissary;
	}
	public void setEmissary(String emissary) {
		this.emissary = emissary;
	}
	public String getBodyText() {
		return bodyText;
	}
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
	public String getSubjectText() {
		return subjectText;
	}
	public void setSubjectText(String subjectText) {
		this.subjectText = subjectText;
	}
}
