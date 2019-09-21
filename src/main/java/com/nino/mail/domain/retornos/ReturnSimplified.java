package com.nino.mail.domain.retornos;

public class ReturnSimplified {

	private String path;
	private String method;
	private Object object;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public void clean() {
		this.path = "";
		this.method = "";
	}
	
}
