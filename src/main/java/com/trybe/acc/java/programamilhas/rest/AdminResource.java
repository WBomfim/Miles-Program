package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.LancamentoDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.AdminService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Classe responsável por expor os serviços para o administrador.
 * 
 */
@Path("/admin")
@ApplicationScoped
public class AdminResource {

  @Inject
  AdminService adminService;

  @Inject
  TokenUtil tokenUtil;

  /* /admin/credito:
    post:
      tags:
      - Admin Resource
      parameters:
      - name: token
        in: query
        schema:
          type: string
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/LancamentoDTO'
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/MensagemResult' */
  @POST
  @Path("/credito")
  public MensagemResult adicionaCredito(@PathParam("token") String token, LancamentoDto lancamento)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    return adminService.adicionaCredito(lancamento);
  }

  /* /admin/resgate:
    post:
      tags:
      - Admin Resource
      parameters:
      - name: token
        in: query
        schema:
          type: string
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/LancamentoDTO'
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/MensagemResult' */
  @POST
  @Path("/resgate")
  public MensagemResult efetuaResgate(@PathParam("token") String token, LancamentoDto lancamento)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    return adminService.efetuaResgate(lancamento);
  }

  /* /admin/saldos:
    post:
      tags:
      - Admin Resource
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
                  $ref: '#/components/schemas/SaldoResult' */
  /**
   * Método responsável por buscar os saldos de todos os usuários.
   * 
   */
  @POST
  @Path("/saldos")
  public List<SaldoResult> buscaSaldos(@PathParam("token") String token)
      throws AcessoNaoAutorizadoException {
    /* tokenUtil.validarAdmToken(token);
    System.out.println("AQUIIIIIIIIIIIIIIIIII"); */
    return adminService.buscarSaldos();
    
  }

}
