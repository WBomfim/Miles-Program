package com.trybe.acc.java.programamilhas.dto;

import javax.validation.constraints.Min;

/**
 * Classe responsável por representar uma transferência.
 * 
 */
public class TransferenciaDto {

  private String usuarioDestino;

  @Min(message = "O valor da transferência deve ser positivo", value = 1)
  private Integer valor;


  public Integer getValor() {
    return valor;
  }

  public void setValor(Integer valor) {
    this.valor = valor;
  }

  public String getUsuarioDestino() {
    return usuarioDestino;
  }

  public void setUsuarioDestino(String usuarioDestino) {
    this.usuarioDestino = usuarioDestino;
  }

}
