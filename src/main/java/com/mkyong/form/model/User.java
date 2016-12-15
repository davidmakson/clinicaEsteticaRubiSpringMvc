package com.mkyong.form.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	String dtNasct;
	
	String obs;
	
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return this.celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean getIsFunc() {
		return this.isFunc;
	}

	public void setIsFunc(boolean isFunc) {
		this.isFunc = isFunc;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDtNasct() {
		return this.dtNasct;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getObs() {
		return this.obs;
	}
	
	public void setObs(String obs) {
		this.obs = obs;
	}

	public void setDtNasct(String dtNasct) {
		this.dtNasct = dtNasct;
	}
}
