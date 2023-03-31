package com.trybe.acc.java.programamilhas.exception;

/**
 * Classe responsável por representar uma exceção de acesso não autorizado.
 * 
 */
public class AcessoNaoAutorizadoException extends Exception {

  private static final long serialVersionUID = 1L;

  public AcessoNaoAutorizadoException() {
    super("Acesso não autorizado.");
  }

}
