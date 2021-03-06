package com.david.makson.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agenda {

	Integer id;
	Integer contato;
	Integer funcionario;
	Integer servico;
	String nmContato;
	String nmFuncionario;
	String nmServico;
	String dtAgenda;
	String horaAgenda;
	String obs;
	
	public Agenda() {
	}

	public Agenda(Integer id, Integer contato, Integer funcionario, Integer servico, String dtAgenda, String horaAgenda,
			String obs, List<User> contatoList, List<User> funcionarioList, List<Servico> servicoList) {
		super();
		this.id = id;
		this.contato = contato;
		this.funcionario = funcionario;
		this.servico = servico;
		this.dtAgenda = dtAgenda;
		this.horaAgenda = horaAgenda;
		this.obs = obs;
	}

	public String getNmContato() {
		return nmContato;
	}
	

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
	}
	

	public String getNmFuncionario() {
		return nmFuncionario;
	}
	

	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}
	

	public String getNmServico() {
		return nmServico;
	}
	

	public void setNmServico(String nmServico) {
		this.nmServico = nmServico;
	}
	

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
		return "Agenda [id="+ id + ", contato="+ contato
				+ ", funcionario=" + funcionario + ", servico= " + servico
				+ ", obs=" + obs + ", dtAgenda=" + dtAgenda
				+ ", horaAgenda=" + horaAgenda + "]" + isNew();
	}
	
	public String getDtAgenda() {
		return dtAgenda;
	}
	
}
