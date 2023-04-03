package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.model.Produto;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Classe responsável pela persistência de transação.
 * 
 */
@ApplicationScoped
public class TransacaoDao {

  @Inject
  EntityManager entityManager;

  /**
   * Busca o saldo do usuário.
   * 
   */
  public Integer buscaSaldoUsuario(Integer idUsuario) {
    String hql = "SELECT SUM(l.valor) "
        + "FROM Lancamento l WHERE l.idUsuario = :idUsuario";
    return entityManager.createQuery(hql, Integer.class)
        .setParameter("idUsuario", idUsuario)
        .getSingleResult();
  }

  /**
   * Busca usuário pelo login.
   * 
   */
  public Pessoa buscaUsuarioPorNome(String login) {
    String hql = "SELECT p FROM Pessoa p WHERE p.login = :login";
    return entityManager.createQuery(hql, Pessoa.class)
        .setParameter("login", login)
        .getSingleResult();
  }

  /**
   * Buscar usuário pelo id.
   * 
   */
  public Pessoa buscaUsuarioPorId(Integer idUsuario) {
    String hql = "SELECT p FROM Pessoa p WHERE p.id = :idUsuario";
    return entityManager.createQuery(hql, Pessoa.class)
        .setParameter("idUsuario", idUsuario)
        .getSingleResult();
  }

  /**
   * Busca o produto.
   * 
   */
  public Produto buscaProduto(Integer idProduto) {
    String hql = "SELECT p FROM Produto p WHERE p.id = :idProduto";
    return entityManager.createQuery(hql, Produto.class)
        .setParameter("idProduto", idProduto)
        .getSingleResult();
  }

  /**
   * Efetua uma transação.
   * 
   */
  @Transactional
  public void efetuaTransacao(Lancamento lancamento) {
    entityManager.persist(lancamento);
  }
}
