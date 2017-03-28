package com.david.makson.dao;

import java.util.List;

import com.david.makson.model.Agenda;

public interface AgendaDao {

	List<Agenda> findAll();

	void update(Agenda agenda);

	Agenda findById(Integer id);
	
	void delete(Integer id);

	void save(Agenda agenda);

	List<Agenda> validaAgenda(String data, String hora, int funcionario);
}
