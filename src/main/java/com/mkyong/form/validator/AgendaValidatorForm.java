package com.mkyong.form.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mkyong.form.service.AgendaServico;
import com.mkyong.form.model.Agenda;

@Component
public class AgendaValidatorForm implements Validator{

	@Autowired
	AgendaServico AgendaServico;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Agenda.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
