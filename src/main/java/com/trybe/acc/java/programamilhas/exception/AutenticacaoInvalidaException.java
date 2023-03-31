package com.trybe.acc.java.programamilhas.exception;

/**
 * Classe responsável por representar uma exceção de autenticação inválida.
 * 
 */
public class AutenticacaoInvalidaException extends Exception {

  private static final long serialVersionUID = 1L;

  public AutenticacaoInvalidaException() {
    super("Autenticacão inválida.");
  }

}
