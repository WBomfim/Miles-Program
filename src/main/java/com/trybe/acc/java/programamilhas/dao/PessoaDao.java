package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.util.LancamentoUtil;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Classe responsável pela persistência de {@link Pessoa}.
 * 
 */
@ApplicationScoped
public class PessoaDao {

  @Inject
  EntityManager entityManager;

  @Inject
  LancamentoUtil lancamentoUtil;

  /**
   * Método responsável pela realização do login.
   * 
   * <p>
   * Não delete este método!
   * </p>
   */
  public Pessoa autenticar(String login, String hash) {
    String hql = "from " + Pessoa.class.getSimpleName() + " where login = :login and hash = :hash";
    Query query = entityManager.createQuery(hql);
    query.setParameter("login", login);
    query.setParameter("hash", hash);
    return (Pessoa) query.getSingleResult();
  }

  /**
   * Método responsável por salva uma pessoa.
   * 
   */
  @Transactional
  public void salvar(String login, String hash) {
    Pessoa pessoa = new Pessoa();
    pessoa.setLogin(login);
    pessoa.setHash(hash);
    entityManager.persist(pessoa);
    entityManager.flush();
    
    Lancamento lancamento = lancamentoUtil.criarLancamento(
        pessoa.getId(),
        0,
        1,
        null,
        "Saldo inicial",
        null
    );

    entityManager.persist(lancamento);
    return;
  }

  /**
   * Método responsável por deletar uma pessoa.
   * 
   */
  @Transactional
  public void deletar(Integer id) {
    String hql = "DELETE FROM Lancamento l WHERE l.usuario.id = :id";
    Query query = entityManager.createQuery(hql);
    query.setParameter("id", id);
    query.executeUpdate();

    Pessoa pessoa = entityManager.find(Pessoa.class, id);
    entityManager.remove(pessoa);
    return;
  }

  /**
   * Método responsável por trazer uma pessoa por nome.
   * 
   */
  public Pessoa buscarPorNome(String nome) {
    String hql = "from " + Pessoa.class.getSimpleName() + " where nome = :nome";
    Query query = entityManager.createQuery(hql);
    query.setParameter("nome", nome);
    return (Pessoa) query.getSingleResult();
  }
  
}
