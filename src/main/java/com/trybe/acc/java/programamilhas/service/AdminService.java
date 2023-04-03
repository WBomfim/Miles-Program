package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.AdminDao;
import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.dto.LancamentoDto;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.util.LancamentoUtil;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Classe responsável por representar os recursos do administrador.
 * 
 */
@ApplicationScoped
public class AdminService {

  @Inject
  AdminDao adminDao;

  @Inject
  PessoaDao pessoaDao;

  @Inject
  LancamentoUtil lancamentoUtil;

  /**
   * Método responsável por adicionar crédito para um usuário.
   *
   */
  public MensagemResult adicionaCredito(LancamentoDto lancamentoDto) {
    Pessoa pessoa = pessoaDao.buscarPorNome(lancamentoDto.getUsuario());
  
    Lancamento lancamento = lancamentoUtil.criarLancamento(
        pessoa.getId(),
        lancamentoDto.getValor(),
        lancamentoDto.getIdTipoLancamento(),
        lancamentoDto.getIdParceiro(),
        lancamentoDto.getDescricao(),
        null
    );

    adminDao.adicionaCredito(lancamento);

    return new MensagemResult("Crédito adicionado com sucesso!");
  }
  
  /**
   * Método responsável por efetuar um resgate para um usuário.
   *
   */
  public MensagemResult efetuaResgate(LancamentoDto lancamentoDto) {
    Pessoa pessoa = pessoaDao.buscarPorNome(lancamentoDto.getUsuario());
  
    Lancamento lancamento = lancamentoUtil.criarLancamento(
        pessoa.getId(),
        lancamentoDto.getValor() * -1,
        lancamentoDto.getIdTipoLancamento(),
        lancamentoDto.getIdParceiro(),
        lancamentoDto.getDescricao(),
        null
    );

    adminDao.efetuaResgate(lancamento);

    return new MensagemResult("Resgate efetuado com sucesso!");
  }

  /**
   * Método responsável por buscar os saldos dos usuários.
   *
   */
  public List<SaldoResult> buscarSaldos() {
    return adminDao.buscarSaldos();
  }
  
}
