package com.stefanini.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Pessoa;

/**
 * O Unico objetivo da Dao
 * 
 * @author joaopedromilhome
 *
 */
public class PessoaDao extends GenericDao<Pessoa, Long> {

	public PessoaDao() {
		super(Pessoa.class);
	}
	/**
	 * Efetuando busca de Pessoa por email
	 * 
	 * @param email
	 * @return
	 */
	public Optional<Pessoa> buscarPessoaPorEmail(String email) {

		TypedQuery<Pessoa> q2 = entityManager.createQuery(" select p from Pessoa p where p.email=:email", Pessoa.class);
		q2.setParameter("email", email);

		return q2.getResultStream().findFirst();
	}

	// Efetuando query de paginas
	public List<Pessoa> listarPessoasPaginado(Integer pageNumber, Integer pageSize) {
		
		TypedQuery<Pessoa> q = entityManager.createQuery("from Pessoa pes join fetch pes.enderecos join fetch pes.perfils", Pessoa.class);
		
		q.setFirstResult((pageNumber - 1) * pageSize);
		q.setMaxResults(pageSize);
		
		return q.getResultList();
	}

	// Efetuando busca de Pessoa cheia
	public List<Pessoa> obterPessoaComRelacionamentos() {

		StringBuilder jpql = new StringBuilder();

		jpql.append("select distinct pes from Pessoa pes left join fetch pes.enderecos left join fetch pes.perfils ORDER BY pes.nome");
		TypedQuery<Pessoa> q3 = entityManager.createQuery(jpql.toString(), Pessoa.class);

		return q3.getResultList();
	}

}
