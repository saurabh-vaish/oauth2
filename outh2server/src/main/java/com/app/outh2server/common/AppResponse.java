package com.app.outh2server.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class AppResponse {
	
	private String message;

	private AlertType alertType;

	private Object payload;

	private HttpStatus status;
	
	private Integer statusCode;

	private Boolean error = Boolean.FALSE;

	private long timestamp = new Date().getTime();
	
	public AppResponse(AlertType alertType){
		super();
		this.alertType = alertType;
	}

	public AppResponse() { }

	public AppResponse(Object payload, HttpStatus status) {
		this.payload = payload;
		getStatusMessage(status);
	}


	public AppResponse(HttpStatus status) {
		getStatusMessage(status);
	}

	public AppResponse(HttpStatus status,String message) {
		getStatusMessage(status);
		this.message = message;
	}

	private void getStatusMessage(HttpStatus status){

		if(status.value()==200){
			this.status = status;
			this.message = AlertType.SUCCESS.name();
			this.alertType = AlertType.SUCCESS;
			this.error = Boolean.FALSE;
			this.statusCode = status.value();
		} else if (status.value() == 400 )
		{
			this.status = status;
			this.message = AlertType.NOTFOUND.name();
			this.alertType = AlertType.NOTFOUND;
			this.error = Boolean.TRUE;
			this.statusCode = status.value();
		}
		else if (status.value() == 401 )
		{
			this.status = status;
			this.message = AlertType.UNAUTHORISED.name();
			this.alertType = AlertType.UNAUTHORISED;
			this.error = Boolean.TRUE;
			this.statusCode = status.value();
		}
		else{
			this.status = status;
			this.message = AlertType.ERROR.name();
			this.alertType = AlertType.ERROR;
			this.error = Boolean.TRUE;
			this.statusCode = status.value();
		}

	}



}
