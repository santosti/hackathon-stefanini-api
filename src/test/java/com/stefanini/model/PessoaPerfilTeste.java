package com.stefanini.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mockit.Tested;

public class PessoaPerfilTeste {
	@Tested
	PessoaPerfil pessoaPerfil;

	@Test
	public void testePessoaPerfil() {
		Long id = 1L;
		Long idPerfil = 2L;
		Long idPessoa = 3L;
		Perfil perfil = new Perfil();
		Pessoa pessoa = new Pessoa();

		PessoaPerfil pessoaPerfil = new PessoaPerfil();

		pessoaPerfil.setId(id);
		pessoaPerfil.setIdPerfil(idPerfil);
		pessoaPerfil.setIdPessoa(idPessoa);
		pessoaPerfil.setPerfil(perfil);
		pessoaPerfil.setPessoa(pessoa);

		Assert.assertEquals(pessoaPerfil.getId(), id);
		Assert.assertEquals(pessoaPerfil.getIdPerfil(), idPerfil);
		Assert.assertEquals(pessoaPerfil.getIdPessoa(), idPessoa);
		Assert.assertEquals(pessoaPerfil.getPerfil(), perfil);
		Assert.assertEquals(pessoaPerfil.getPessoa(), pessoa);

	}

	@Test
	public void testeConstrutor() {
		Perfil perfil = new Perfil();
		Pessoa pessoa = new Pessoa();

		PessoaPerfil pessoaPerfil = new PessoaPerfil(perfil, pessoa);

		Assert.assertEquals(pessoaPerfil.getPerfil(), perfil);
		Assert.assertEquals(pessoaPerfil.getPessoa(), pessoa);
	}
}