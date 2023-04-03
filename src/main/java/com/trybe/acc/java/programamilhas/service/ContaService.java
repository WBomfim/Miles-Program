package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.ContaDao;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe responsável por representar os recursos de conta.
 * 
 */
public class ContaService {

  @Inject
  ContaDao contaDao;

  public List<Lancamento> buscaExtrato(Integer idUsuario) {
    contaDao.buscaExtrato(idUsuario);
  }

  public SaldoResult buscaSaldo(Integer idUsuario) {
    contaDao.buscaSaldo(idUsuario);
  }
  
}
