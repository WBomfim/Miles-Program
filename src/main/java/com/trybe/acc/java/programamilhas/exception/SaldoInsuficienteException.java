package com.trybe.acc.java.programamilhas.exception;

/**
 * Classe responsável por representar uma exceção de saldo insuficiente.
 * 
 */
public class SaldoInsuficienteException extends Exception {

  private static final long serialVersionUID = 1L;

  public SaldoInsuficienteException() {
    super("Saldo insuficiente.");
  }

}
