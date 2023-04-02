package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Classe responsável pela persistência dos dados para o administrador.
 * 
 */
@ApplicationScoped
public class AdminDao {

  @Inject
  EntityManager entityManager;

  public void adicionaCredito(Lancamento lancamento) {
    entityManager.persist(lancamento);
  }

  public void efetuaResgate(Lancamento lancamento) {
    entityManager.persist(lancamento);
  }

  /**
   * Busca os saldos dos usuários.
   * 
   */
  public List<Object[]> buscarSaldos() {
    String hql = "SELECT l.usuario.id, l.usuario.login, "
        + "SUM(l.valor) AS saldo "
        + "FROM Lancamento l "
        + "GROUP BY l.usuario.id";
    
    TypedQuery<Object[]> query = entityManager.createQuery(hql, Object[].class);
    
    return query.getResultList();
  }
  
}
