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
import javax.ws.rs.QueryParam;

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

  @POST
  @Path("/credito")
  public MensagemResult adicionaCredito(@QueryParam("token") String token, LancamentoDto lancamento)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    return adminService.adicionaCredito(lancamento);
  }

  @POST
  @Path("/resgate")
  public MensagemResult efetuaResgate(@QueryParam("token") String token, LancamentoDto lancamento)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    return adminService.efetuaResgate(lancamento);
  }

  @POST
  @Path("/saldos")
  public List<SaldoResult> buscaSaldos(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    return adminService.buscarSaldos();
  }

}
