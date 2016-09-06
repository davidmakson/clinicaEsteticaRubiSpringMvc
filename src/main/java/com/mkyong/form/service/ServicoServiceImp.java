package com.mkyong.form.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkyong.form.dao.ServicoDao;
import com.mkyong.form.model.Servico;

@Service("servicoService")
public class ServicoServiceImp implements ServicoService {

	ServicoDao servicoDao;
	
	@Override
	public Servico findById(Integer id) {
		return servicoDao.findById(id);
	}

	@Override
	public List<Servico> findAll() {
		return servicoDao.findAll();
	}

	@Override
	public List<Servico> findAllProdutos() {
		return servicoDao.findAllProdutos();
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

}
