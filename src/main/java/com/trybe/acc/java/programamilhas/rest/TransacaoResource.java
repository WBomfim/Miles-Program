package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.ResgateProdutoDto;
import com.trybe.acc.java.programamilhas.dto.TransferenciaDto;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Classe responsável por expor os serviços de transação.
 * 
 */
@Path("/transacao")
@ApplicationScoped
public class TransacaoResource {

  /* @Inject
  TransacaoService service; */

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
      @PathParam("token") String token, ResgateProdutoDto resgate
  ) {
    
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
      @PathParam("token") String token, TransferenciaDto transferencia
  ) {
    
  }
  
}
