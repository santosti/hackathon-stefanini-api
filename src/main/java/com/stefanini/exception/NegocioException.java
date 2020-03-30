package com.stefanini.exception;

public class NegocioException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
    public NegocioException(String s) {
        mensagem = s;
    }

    public String getMensagem() {
        return mensagem;
    }
}
