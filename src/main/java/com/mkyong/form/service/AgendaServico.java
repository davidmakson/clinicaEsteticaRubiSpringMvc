package com.mkyong.form.service;

import java.util.List;

import com.mkyong.form.model.Agenda;

public interface AgendaServico {

	List<Agenda> findAll();

	void saveOrUpdate(Agenda agenda);

	Agenda findById(Integer id);
	
	void delete(Integer id);

}
