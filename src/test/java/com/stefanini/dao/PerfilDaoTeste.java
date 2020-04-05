package com.stefanini.dao;

import javax.persistence.EntityManager;

import org.junit.Test;

import mockit.Injectable;
import mockit.Tested;

public class PerfilDaoTeste {
	@Injectable
	EntityManager entityManager;

	@Tested
	PerfilDao perfilDao;
	
	@Test
	public void testeBuscarPessoaPorNome() {
		String nome = "nome";
		perfilDao.buscarPessoaPorNome(nome);

	}
}
