package com.trybe.acc.java.programamilhas.dto;

/**
 * Classe responsável por representar um resgate de produto.
 * 
 */
public class ResgateProdutoDto {

  private Integer idProduto;

  private String descricao;

  public Integer getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(Integer idProduto) {
    this.idProduto = idProduto;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
