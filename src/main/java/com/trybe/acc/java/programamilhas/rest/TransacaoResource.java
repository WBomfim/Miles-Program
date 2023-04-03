package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.ResgateProdutoDto;
import com.trybe.acc.java.programamilhas.dto.TransferenciaDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.exception.SaldoInsuficienteException;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.service.TransacaoService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Classe responsável por expor os serviços de transação.
 * 
 */
@Path("/transacao")
@ApplicationScoped
public class TransacaoResource {

  @Inject
  TransacaoService service;

  @Inject
  TokenUtil tokenUtil;

  /* /transacao/resgate-produto:
    post:
      tags:
      - Transacao Resource
      parameters:
      - name: token
        in: query
        schema:
          type: string
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/ResgateProdutoDTO'
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/MensagemResult' */
  @POST
  @Path("/resgate-produto")
  public MensagemResult resgateProduto(
      @QueryParam("token") String token, ResgateProdutoDto resgate
  ) throws AcessoNaoAutorizadoException, SaldoInsuficienteException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.resgateProduto(idUsuario, resgate);
  }

  /* /transacao/transferencia:
    post:
      tags:
      - Transacao Resource
      parameters:
      - name: token
        in: query
        schema:
          type: string
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/TransferenciaDTO'
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/MensagemResult' */
  @POST
  @Path("/transferencia")
  public MensagemResult transferencia(
      @QueryParam("token") String token, TransferenciaDto transferencia
  ) throws AcessoNaoAutorizadoException, SaldoInsuficienteException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.transferencia(idUsuario, transferencia);
  }
  
}
