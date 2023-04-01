package com.trybe.acc.java.programamilhas.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Classe responsável por pelos acessos públicos.
 * 
 */
@Path("/echo")
@ApplicationScoped
public class EchoResource {

  @GET
  public String echo() {
    return "Olá!";
  }
  
}
