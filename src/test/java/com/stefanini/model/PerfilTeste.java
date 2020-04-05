package com.stefanini.model;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mockit.Tested;

public class PerfilTeste {
	@Tested
	Perfil perfil;

	private Long id;

	@Before
	public void setUp() {
		id = 1L;
		perfil = new Perfil();
		perfil.setId(id);
	}

	@Test
	public void testePerfil() {
		String nome = "nome";
		String descricao = "descricao";
		LocalDateTime dataHoraInclusao = LocalDateTime.now();
		LocalDateTime dataHoraAlteracao = LocalDateTime.now();
		String tooString = "Perfil [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataHoraInclusao="
				+ dataHoraInclusao + ", dataHoraAlteracao=" + dataHoraAlteracao + "]";

		Perfil perfil = new Perfil();

		perfil.setId(id);
		perfil.setNome(nome);
		perfil.setDescricao(descricao);
		perfil.setDataHoraInclusao(dataHoraInclusao);
		perfil.setDataHoraAlteracao(dataHoraAlteracao);

		Assert.assertEquals(perfil.getId(), id);
		Assert.assertEquals(perfil.getNome(), nome);
		Assert.assertEquals(perfil.getDescricao(), descricao);
		Assert.assertEquals(perfil.getDataHoraInclusao(), dataHoraInclusao);
		Assert.assertEquals(perfil.getDataHoraAlteracao(), dataHoraAlteracao);
		Assert.assertEquals(perfil.toString(), tooString);

	}

	@Test
	public void testeConstrutorId() {
		Perfil perfil = new Perfil(id);

		Assert.assertEquals(perfil.getId(), id);
	}

	@Test
	public void testeConstrutor() {
		String nome = "nome";
		String descricao = "descricao";
		LocalDateTime dataHoraInclusao = LocalDateTime.now();
		LocalDateTime dataHoraAlteracao = LocalDateTime.now();

		Perfil perfil = new Perfil(nome, descricao, dataHoraInclusao, dataHoraAlteracao);

		Assert.assertEquals(perfil.getNome(), nome);
		Assert.assertEquals(perfil.getDescricao(), descricao);
		Assert.assertEquals(perfil.getDataHoraInclusao(), dataHoraInclusao);
		Assert.assertEquals(perfil.getDataHoraAlteracao(), dataHoraAlteracao);
	}

}
