package com.mkyong.form.model;

import java.util.Date;
import java.util.List;

public class User {
	// form:hidden - hidden value
	Integer id;

	// form:input - textbox
	String nome;

	// form:input - textbox
	String email;

	// form:input - textbox
	String address;
	
	// form:input - textbox
	String telefone;
	
	//form:input - textbox
	String celular;
	
	public String getTelefone() {
		return telefone;
	}
	

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	public String getCelular() {
		return celular;
	}
	

	public void setCelular(String celular) {
		this.celular = celular;
	}
	

	// form:input - password
	String password;

	// form:input - password
	String confirmPassword;

	// form:checkbox - single checkbox
	boolean isFunc = false;

	// form:radiobutton - radio button
	String sex;

	// form:select - form:option - dropdown - single select
	String cidade;

	// form:select - multiple=true - dropdown - multiple select
	Date dtNasct;
	
	String obs;

	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isFunc() {
		return isFunc;
	}

	public void setIsFunc(boolean isFunc) {
		this.isFunc = isFunc;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDtNasct() {
		return dtNasct;
	}

	public void setNumber(Date dtNasct) {
		this.dtNasct = dtNasct;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getObs() {
		return obs;
	}
	

	public void setObs(String obs) {
		this.obs = obs;
	}
	

	public void setFunc(boolean isFunc) {
		this.isFunc = isFunc;
	}
	

	public void setDtNasct(Date dtNasct) {
		this.dtNasct = dtNasct;
	}
	
	@Override
	public String toString(){
		return this.nome;
	}
}
