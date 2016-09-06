package com.mkyong.form.dao;

import java.util.List;

import com.mkyong.form.model.Agenda;

public interface AgendaDao {

	List<Agenda> findAll();

	void update(Agenda agenda);

	Agenda findById(Integer id);
	
	void delete(Integer id);

	void save(Agenda agenda);

}
