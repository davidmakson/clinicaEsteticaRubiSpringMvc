package com.david.makson.service;

import java.util.List;

import com.david.makson.model.Servico;

public interface ServicoService {

	Servico findById(Integer id);
	
	List<Servico> findAll(int servico);

	void saveOrUpdate(Servico user);
	
	void delete(int id);

	List<Servico> findAllProdutos();

	List<Servico> findAllServicos();

}
