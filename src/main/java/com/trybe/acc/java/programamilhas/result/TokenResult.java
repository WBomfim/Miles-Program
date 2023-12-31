package com.trybe.acc.java.programamilhas.result;

/**
 * Classe responsável por representar um token.
 * 
 */
public class TokenResult {

  private String token;

  /**
   * Construtor para a classe TokenResult.
   */
  public static TokenResult construir(String token) {
    TokenResult result = new TokenResult();
    result.setToken(token);
    return result;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
