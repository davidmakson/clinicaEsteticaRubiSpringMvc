package com.mkyong.form.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mkyong.form.model.Agenda;
import com.mkyong.form.model.Servico;
import com.mkyong.form.model.User;
import com.mkyong.form.service.AgendaServico;

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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dtAgenda", "required.dtAgenda");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "horaAgenda", "required.horaAgenda");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "obs", "required.obs");
		
	}

}
