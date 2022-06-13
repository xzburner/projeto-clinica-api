package com.clinica.projetoclinicaapi.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    private static final long seriallVersionUID = 1l;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public ObjectNotFoundException(String message) {
		super(message);
		
	} 
}
