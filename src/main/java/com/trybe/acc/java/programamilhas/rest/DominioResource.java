package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Classe responsável por expor os serviços de domínio.
 * 
 */
@Path("/dominio")
@ApplicationScoped
public class DominioResource {

  /* @Inject
  DominioService service; */

  /* /dominio/parceiro:
    get:
      tags:
      - Dominio Resource
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Parceiro' */
  @GET
  @Path("/parceiro")
  public List<Parceiro> getParceiros() {
    
  }

  /* /dominio/produto:
    get:
      tags:
      - Dominio Resource
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Produto' */
  @GET
  @Path("/produto")
  public List<Produto> getProdutos() {
    
  }

  /* /dominio/tipolancamento:
    get:
      tags:
      - Dominio Resource
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/TipoLancamento' */
  @GET
  @Path("/tipolancamento")
  public List<TipoLancamento> getTipoLancamentos() {
    
  }
  
}
