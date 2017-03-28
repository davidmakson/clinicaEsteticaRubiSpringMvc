package com.david.makson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.makson.dao.AgendaDao;
import com.david.makson.model.Agenda;

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

	@Override
	public List<Agenda> validaAgenda(String dtAgenda, String horaAgenda, Integer funcionario) {
		return agendaDAO.validaAgenda(dtAgenda, horaAgenda, funcionario);
	}

}
