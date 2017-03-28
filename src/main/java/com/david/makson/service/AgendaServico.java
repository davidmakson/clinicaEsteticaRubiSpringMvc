package com.david.makson.service;

import java.util.List;

import com.david.makson.model.Agenda;

public interface AgendaServico {

	List<Agenda> findAll();

	void saveOrUpdate(Agenda agenda);

	Agenda findById(Integer id);
	
	void delete(Integer id);

	List<Agenda> validaAgenda(String dtAgenda, String horaAgenda, Integer funcionario);

}
