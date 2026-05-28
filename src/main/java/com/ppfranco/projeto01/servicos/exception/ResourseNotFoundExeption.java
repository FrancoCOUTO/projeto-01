package com.ppfranco.projeto01.servicos.exception;

public class ResourseNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourseNotFoundExeption(Object id) {
		super("Resourse Not Found id." + id);
		
	}

}
