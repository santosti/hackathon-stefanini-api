package com.stefanini.dto;

import org.junit.Assert;
import org.junit.Test;

import mockit.Tested;

public class ErroDtoTeste {
	@Tested
	ErroDto erroDto;
	
	@Test
	public void testeErroDto() {
		String campo = "campo";
		String mensagem = "mensagem";
		Object valor = "valor";
		
		ErroDto dto = new ErroDto(campo, mensagem, valor);
		
		Assert.assertEquals(dto.getCampo(), campo);
		Assert.assertEquals(dto.getMensagem(), mensagem);
		Assert.assertEquals(dto.getValor(), valor);
	}
}
