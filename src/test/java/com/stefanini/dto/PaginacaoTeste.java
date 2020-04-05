package com.stefanini.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;

import org.junit.Assert;
import mockit.Tested;

public class PaginacaoTeste {
	@Tested
	PaginacaoDto paginacaoDto;

	@Test
	public void testePaginacaoDto() {
		Long id = 1L;
		String nome = "nome";
		String email = "email";
		LocalDate dataNascimento = LocalDate.now();
		Boolean situacao = true;
		Set<Endereco> enderecos = new HashSet<>();
		Set<Perfil> perfils = new HashSet<>();
		
		PaginacaoDto dto = new PaginacaoDto();
		
		dto.setId(id);
		dto.setNome(nome);
		dto.setEmail(email);
		dto.setDataNascimento(dataNascimento);
		dto.setSituacao(situacao);
		dto.setEnderecos(enderecos);
		dto.setPerfils(perfils);
		
		Assert.assertEquals(dto.getId(), id);
		Assert.assertEquals(dto.getNome(), nome);
		Assert.assertEquals(dto.getEmail(), email);
		Assert.assertEquals(dto.getDataNascimento(), dataNascimento);
		Assert.assertEquals(dto.getSituacao(), situacao);
		Assert.assertEquals(dto.getEnderecos(), enderecos);
		Assert.assertEquals(dto.getPerfils(), perfils);
		
	}

}
