package com.stefanini.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import mockit.Tested;

public class PessoaTeste {
	@Tested
	Pessoa pessoa;

	@Test
	public void testePessoa() {

		Long id = 1L;
		String nome = "nome";
		String email = "email";
		LocalDate dataNascimento = LocalDate.now();
		Boolean situacao = true;
		String imagem = "imagem";
		Set<Endereco> enderecos = new HashSet<Endereco>();
		Set<Perfil> perfils = new HashSet<Perfil>();
		String tooString = "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", situacao=" + situacao + ", imagem=" + imagem + ", enderecos=" + enderecos
				+ ", perfils=" + perfils + "]";
		
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId(id);
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setDataNascimento(dataNascimento);
		pessoa.setSituacao(situacao);
		pessoa.setImagem(imagem);
		pessoa.setEnderecos(enderecos);
		pessoa.setPerfils(perfils);

		Assert.assertEquals(pessoa.getId(), id);
		Assert.assertEquals(pessoa.getNome(), nome);
		Assert.assertEquals(pessoa.getEmail(), email);
		Assert.assertEquals(pessoa.getDataNascimento(), dataNascimento);
		Assert.assertEquals(pessoa.getSituacao(), situacao);
		Assert.assertEquals(pessoa.getImagem(), imagem);
		Assert.assertEquals(pessoa.getEnderecos(), enderecos);
		Assert.assertEquals(pessoa.getPerfils(), perfils);
		Assert.assertEquals(pessoa.toString(), tooString);

	}
	
	@Test
	public void testeConstrutor() {
		String nome = "nome";
		String email = "email";
		LocalDate dataNascimento = LocalDate.now();
		Boolean situacao = true;
		String imagem = "imagem";
		
		Pessoa pessoa = new Pessoa(nome, email, dataNascimento, situacao, imagem);
		
		Assert.assertEquals(pessoa.getNome(), nome);
		Assert.assertEquals(pessoa.getEmail(), email);
		Assert.assertEquals(pessoa.getDataNascimento(), dataNascimento);
		Assert.assertEquals(pessoa.getSituacao(), situacao);
		Assert.assertEquals(pessoa.getImagem(), imagem);
	}
	
	@Test
	public void testeHashCode() {
		
		Long id = 1L;
		String nome = "nome";
		String email = "email";
		LocalDate dataNascimento = LocalDate.now();
		Boolean situacao = true;
		String imagem = "imagem";
		Set<Endereco> enderecos = new HashSet<Endereco>();
		Set<Perfil> perfils = new HashSet<Perfil>();
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId(id);
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setDataNascimento(dataNascimento);
		pessoa.setSituacao(situacao);
		pessoa.setImagem(imagem);
		pessoa.setEnderecos(enderecos);
		pessoa.setPerfils(perfils);
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((perfils == null) ? 0 : perfils.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		
		int resultado = pessoa.hashCode();
		Assert.assertEquals(resultado, result);
	}
	
}
