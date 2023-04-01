package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.service.PessoaService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Classe responsável por expor os serviços de pessoa.
 * 
 */
@Path("/pessoa")
@ApplicationScoped
public class PessoaResource {

  @Inject
  PessoaService service;

  /* /pessoa:
    post:
      tags:
      - Pessoa Resource
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/LoginDTO'
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/MensagemResult' */
  @POST
  public MensagemResult addPessoa(LoginDto login) {
    
  }

  /* delete:
      tags:
      - Pessoa Resource
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
                $ref: '#/components/schemas/MensagemResult' */
  @DELETE
  public MensagemResult deletePessoa(@PathParam("token") String token) {
    
  }
  
}
