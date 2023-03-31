package com.trybe.acc.java.programamilhas.exception;

/**
 * Classe responsável por representar uma exceção de validação.
 * 
 */
public class ValidacaoException extends Exception {

  private static final long serialVersionUID = 1L;

  public ValidacaoException(String mensagem) {
    super(mensagem);
  }

}
