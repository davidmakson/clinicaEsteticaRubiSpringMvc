package com.mkyong.form.model;

import java.util.Date;
import java.util.List;

public class User {
	// form:hidden - hidden value
	Integer id;

	// form:input - textbox
	String name;

	// form:input - textbox
	String email;

	// form:textarea - textarea
	String address;

	// form:input - password
	String password;

	// form:input - password
	String confirmPassword;

	// form:checkbox - single checkbox
	boolean isFunc;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", sex=" + sex
				+ ", dtNasct=" + dtNasct + ", cidade=" + cidade + ", obs=" + obs +"isNew="+ isNew() + "isFunc=" +isFunc();
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
	

}
