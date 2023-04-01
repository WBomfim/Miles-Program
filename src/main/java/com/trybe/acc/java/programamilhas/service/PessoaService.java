package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Classe responsável por representar os serviços de pessoa.
 * 
 */
@ApplicationScoped
public class PessoaService {

  @Inject
  PessoaDao dao;
  
}
