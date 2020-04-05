package com.stefanini.model;

import org.junit.Assert;
import org.junit.Test;

import mockit.Tested;

public class EnderecoTeste {
	@Tested
	Endereco endereco;
	
	@Test
	public void testeEndereco() {
		Long id = 1L;
		Long idPessoa = 1L;
		String cep = "cep";
		String uf = "uf";
		String localidade = "localidade";
		String bairro = "bairro";
		String complemento = "complemento";
		String logradouro = "logradouro";
		String tooString = "Endereco [id=" + id + ", cep=" + cep + ", uf=" + uf + ", localidade=" + localidade + ", bairro="
				+ bairro + ", complemento=" + complemento + ", logradouro=" + logradouro + ", idPessoa=" + idPessoa
				+ "]";
		
		Endereco endereco = new Endereco();
		
		endereco.setId(id);
		endereco.setIdPessoa(idPessoa);
		endereco.setCep(cep);
		endereco.setUf(uf);
		endereco.setLocalidade(localidade);
		endereco.setBairro(bairro);
		endereco.setComplemento(complemento);
		endereco.setLogradouro(logradouro);
		
		Assert.assertEquals(endereco.getId(), id);
		Assert.assertEquals(endereco.getIdPessoa(), idPessoa);
		Assert.assertEquals(endereco.getCep(), cep);
		Assert.assertEquals(endereco.getUf(), uf);
		Assert.assertEquals(endereco.getLocalidade(), localidade);
		Assert.assertEquals(endereco.getBairro(), bairro);
		Assert.assertEquals(endereco.getComplemento(), complemento);
		Assert.assertEquals(endereco.getLogradouro(), logradouro);
		Assert.assertEquals(endereco.toString(), tooString);
		
		
	}
}
