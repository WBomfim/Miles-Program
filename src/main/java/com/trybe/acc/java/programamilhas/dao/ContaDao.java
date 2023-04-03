package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Classe responsável pela persistência de conta.
 * 
 */
public class ContaDao {

  @Inject
  EntityManager entityManager;

  /**
   * Busca o extrato do usuário.
   * 
   */
  public List<Lancamento> buscaExtrato(Integer idUsuario) {
    String hql = "SELECT l FROM Lancamento l WHERE l.idUsuario = :idUsuario";
    return entityManager.createQuery(hql, Lancamento.class)
        .setParameter("idUsuario", idUsuario)
        .getResultList();
  }

  /**
   * Busca o saldo do usuário.
   * 
   */
  public SaldoResult buscaSaldo(Integer idUsuario) {
    String hql = "SELECT l.id, l.login, SUM(l.valor) "
        + "FROM Lancamento l WHERE l.idUsuario = :idUsuario";
    return entityManager.createQuery(hql, SaldoResult.class)
        .setParameter("idUsuario", idUsuario)
        .getSingleResult();
  }
  
}
