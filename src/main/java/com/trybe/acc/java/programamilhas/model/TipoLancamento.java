package com.trybe.acc.java.programamilhas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe responsável por representar um tipo de lançamento.
 * 
 */
@Entity
public class TipoLancamento {

  @Id
  @Column(name = "idTipoLancamento")
  private Integer id;

  private String descricao;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
