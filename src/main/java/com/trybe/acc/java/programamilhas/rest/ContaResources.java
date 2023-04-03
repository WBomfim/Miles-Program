package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.ContaService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Classe responsável por expor os serviços de conta.
 * 
 */
@Path("/conta")
@ApplicationScoped
public class ContaResources {

  @Inject
  ContaService service;

  @Inject
  TokenUtil tokenUtil;

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
  public List<Lancamento> buscaExtrato(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.buscaExtrato(idUsuario);
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
  public SaldoResult buscaSaldo(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.buscaSaldo(idUsuario);
  }
  
}
