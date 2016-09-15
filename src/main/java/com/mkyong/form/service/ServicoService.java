package com.mkyong.form.service;

import java.util.List;

import com.mkyong.form.model.Servico;

public interface ServicoService {

	Servico findById(Integer id);
	
	List<Servico> findAll(int servico);

	void saveOrUpdate(Servico user);
	
	void delete(int id);

	List<Servico> findAllProdutos();

	List<Servico> findAllServicos();
}
