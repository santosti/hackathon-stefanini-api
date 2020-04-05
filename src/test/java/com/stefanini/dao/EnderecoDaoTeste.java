package com.stefanini.dao;

import org.junit.Test;

import com.stefanini.model.Endereco;

import mockit.Injectable;
import mockit.Mocked;

public class EnderecoDaoTeste {
	@Injectable
	EnderecoDao enderecoDao;

	@Injectable
	@Mocked
	Endereco endereco;

	@Test
	public void testeEnderecoDao() {
		EnderecoDao dao = new EnderecoDao();
	}
}
