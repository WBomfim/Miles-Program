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

  /* /echo:
  get:
    tags:
    - Echo Resource
    responses:
      "200":
        description: OK
        content:
          text/plain:
            schema:
              type: string */
  @GET
  public String echo() {
    return "Welcome to programa-milhas!";
  }
  
}
