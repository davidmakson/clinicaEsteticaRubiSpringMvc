package com.mkyong.form.dao;

import java.util.List;

import com.mkyong.form.model.Servico;

public interface ServicoDao {

	List<Servico> findAll();
	
	List<Servico> findAll(int identificador);

	void update(Servico servico);

	Servico findById(Integer id);
	
	void delete(Integer id);

	void save(Servico servico);

	List<Servico> findAllProdutos();

	List<Servico> findAllServicos();
}
