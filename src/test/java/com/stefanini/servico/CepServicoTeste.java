package com.stefanini.servico;

import static org.junit.Assert.assertFalse;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import mockit.Injectable;
import mockit.Tested;

public class CepServicoTeste {
	@Injectable
	EntityManager entityManager;

	@Tested
	CepServico cepServico;
	
	private Long id;
	
	@Before
	public void setUp() {
		id = 1L;
		cepServico = new CepServico();
	}
	
	@Test
	public void testeGetEnderecoPorCep() {
		String retornoCep = cepServico.getEnderecoPorCep("72888700");
		assertFalse(retornoCep.isEmpty());
	}
}
