package com.mkyong.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.form.dao.AgendaDao;
import com.mkyong.form.model.Agenda;

@Service("agendaServico")
public class AgendaServicoImp implements AgendaServico{

	AgendaDao agendaDAO;
	
	@Autowired
	public void setAgendaDAO(AgendaDao agendaDAO){
		this.agendaDAO = agendaDAO;
	}
	
	@Override
	public List<Agenda> findAll() {
		return agendaDAO.findAll();
	}

	@Override
	public void saveOrUpdate(Agenda agenda) {
		if(agenda.isNew()){
			agendaDAO.save(agenda);
		}else{
			agendaDAO.update(agenda);
		}
	}

	@Override
	public Agenda findById(Integer id) {
		return agendaDAO.findById(id);
	}

	@Override
	public void delete(Integer id) {
		 agendaDAO.delete(id);
	}

}
