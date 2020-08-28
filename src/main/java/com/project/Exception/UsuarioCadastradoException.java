package com.project.Exception;

public class UsuarioCadastradoException extends RuntimeException{
	private static final long serialVersionUID = -456639376730360196L;

	public UsuarioCadastradoException(String login) {
		super("Usuario já cadastrado para login "+ login);		
	}
}
