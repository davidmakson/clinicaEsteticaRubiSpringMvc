package com.mkyong.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.form.dao.ServicoDao;
import com.mkyong.form.model.Servico;

@Service("servicoService")
public class ServicoServiceImp implements ServicoService {

	ServicoDao servicoDao;
	
	@Autowired
	public void setServicoDao(ServicoDao servicoDao){
		this.servicoDao = servicoDao;
	}
	
	@Override
	public Servico findById(Integer id) {
		return servicoDao.findById(id);
	}

	@Override
	public List<Servico> findAllProdutos() {
		return servicoDao.findAllProdutos();
	}
	
	@Override
	public List<Servico> findAllServicos() {
		return servicoDao.findAllServicos();
	}
	
	@Override
	public void saveOrUpdate(Servico servico) {
		
		if (servicoDao.findById(servico.getId())==null){
			servicoDao.save(servico);
		}else{
			servicoDao.update(servico);
		} 
		
	}

	@Override
	public void delete(int id) {
		servicoDao.delete(id);
	}

	@Override
	public List<Servico> findAll(int servico) {
		return servicoDao.findAll(servico);
	}

}
