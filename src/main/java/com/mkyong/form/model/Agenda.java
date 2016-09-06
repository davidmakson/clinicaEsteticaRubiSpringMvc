package com.mkyong.form.model;

import java.util.Date;

public class Agenda {

	Integer id;
	Integer contato;
	Integer funcionario;
	Integer servico;
	String dtAgenda;
	String horaAgenda;
	String obs;
	
	public String getHoraAgenda() {
		return horaAgenda;
	}
	


	public void setHoraAgenda(String horaAgenda) {
		this.horaAgenda = horaAgenda;
	}
	


	public void setDtAgenda(String dtAgenda) {
		this.dtAgenda = dtAgenda;
	}
	


	public Integer getContato() {
		return contato;
	}
	

	public void setContato(Integer contato) {
		this.contato = contato;
	}
	

	public Integer getFuncionario() {
		return funcionario;
	}
	

	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}
	

	public Integer getServico() {
		return servico;
	}
	

	public void setServico(Integer servico) {
		this.servico = servico;
	}
	
	public String getObs() {
		return obs;
	}
	

	public void setObs(String obs) {
		this.obs = obs;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isNew() {
		return(this.id == null);
	}
	@Override
	public String toString(){
		return "[id="+ id +",contato="+ contato +", "
				+ "funcionario = "+funcionario+",servico="+servico+","
					+ "obs="+obs+", dtAgenda="+dtAgenda+", horaAgenda ="+horaAgenda+"isNew="+isNew();
	}



	public String getDtAgenda() {
		return dtAgenda;
	}
	
	
}