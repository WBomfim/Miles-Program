package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Classe responsável por expor os serviços de conta.
 * 
 */
@Path("/conta")
@ApplicationScoped
public class ContaResources {

  @Inject
  ContaService service;

  /* /conta/extrato:
    get:
      tags:
      - Conta Resource
      parameters:
      - name: token
        in: query
        schema:
          type: string
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Lancamento' */
  @GET
  @Path("/extrato")
  public List<Lancamento> getExtrato(@PathParam("token") String token) {
    
  }

  /* /conta/saldo:
    get:
      tags:
      - Conta Resource
      parameters:
      - name: token
        in: query
        schema:
          type: string
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/SaldoResult' */
  @GET
  @Path("/saldo")
  public SaldoResult getSaldo(@PathParam("token") String token) {
    
  }
  
}
