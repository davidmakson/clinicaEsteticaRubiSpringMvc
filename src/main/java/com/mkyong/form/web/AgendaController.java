package com.mkyong.form.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mkyong.form.model.Agenda;
import com.mkyong.form.model.Servico;
import com.mkyong.form.model.User;
import com.mkyong.form.service.AgendaServico;
import com.mkyong.form.service.ServicoService;
import com.mkyong.form.service.UserService;
import com.mkyong.form.validator.AgendaValidatorForm;

@Controller
public class AgendaController{

	private static final int PRODUTO = 1;
	private static final int SERVICO = 0;
	private static final int FUNCIONARIO = 1;
	private static final int CLIENTE = 0;
	
	private static final String APPLICATION_JSON = "application/json";
	private static final String GET = "";
	
	private final Logger loger = LoggerFactory.getLogger(AgendaController.class);

	@Autowired
	AgendaValidatorForm agendaValidatorForm;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(agendaValidatorForm);
	}

	private AgendaServico agendaServico;
	private UserService userService;
	private ServicoService servicoService;

	@Autowired
	public void setAgendaServico(AgendaServico agendaServico) {
		this.agendaServico = agendaServico;
	}
	
	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}

	@Autowired
	public void setServicoService(ServicoService servicoService) {
		this.servicoService = servicoService;
	}
	
	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public String showAll(Model model) {

		loger.debug("/agenda");

		model.addAttribute("agenda", agendaServico.findAll());
		return "agenda/list";
	}

	@RequestMapping(value = "/agenda/add", method = RequestMethod.GET)
	public String saveOrUpdate(Model model) {

		loger.debug("/agenda/agendaform");
		try {
			populaCombos(model);
		} catch (Exception e) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Contato n�o encontrado!");
		}
		return "agenda/agendaform";
	}

	private void populaCombos(Model model) {

		Agenda agenda = new Agenda();
		List<User> contatoList = userService.findAll(CLIENTE);
		List<User> funcionarioList = userService.findAll(FUNCIONARIO);
		List<Servico> servicoList = servicoService.findAll(SERVICO);
		
		//model.addAttribute("servicoList", servicoService.findAll(PRODUTO));
		
		model.addAttribute("agendaform", agenda);
		model.addAttribute("funcionarioList",funcionarioList);
		model.addAttribute("contatoList", contatoList);
		model.addAttribute("servicoList", servicoList);
		
	}

	// save or update user
	@RequestMapping(value = "/agenda/add", method = RequestMethod.POST)
	public String saveOrUpdateAgenda(@ModelAttribute("agendaform") @Validated Agenda agenda, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		loger.debug("saveOrUpdateAgenda() : {}", agenda.toString());

		if (result.hasErrors()) {

			model.addAttribute("agendaform", agenda);
			return "/agenda/agendaform";

		} else {
			
			formataData(agenda);
			
			if (agenda.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "Agenda adicionada com sucesso!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "Agenda atualizada com sucesso!");
			}
			
			agendaServico.saveOrUpdate(agenda);

			// POST/REDIRECT/GET
			return "redirect:/agenda/" + agenda.getId();
		}

	}

	private void formataData(Agenda agenda) {
		
		//from 28/12/1988 to 1998-10-25
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfDtAgenda = new SimpleDateFormat("yyyy-MM-dd");
		
		Date myDate = null;
		
		try {
			//parser = String to Date
			myDate = sdf.parse(agenda.getDtAgenda());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//formater = Date to String
		String dtAgenda = sdfDtAgenda.format(myDate);
		
		agenda.setDtAgenda(dtAgenda);
		
	}
	//enviando no parametro da URL
	@ResponseBody
	@RequestMapping(value = "/menudinamico/{cnpj}", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public boolean validaAgenda(@PathVariable final String cnpj) {
		return true;
	}
	
	//enviando no corpo do ajax json
	@ResponseBody
	@RequestMapping(value = "/agenda/validaAgenda",
	    method = {RequestMethod.GET,RequestMethod.POST},
		consumes = APPLICATION_JSON,
	    produces = APPLICATION_JSON)
	public boolean validaAgenda(@RequestBody Agenda agenda) {
	    
		System.out.println("CNPJ recebido: " + agenda.getDtAgenda());
		
		boolean agendado = false;
		
		List<Agenda> result = agendaServico.validaAgenda(agenda.getDtAgenda(),agenda.getHoraAgenda(),agenda.getFuncionario());
		
		if(result.isEmpty()){
			agendado = false;
		}else{
			agendado = true;
		}
		return agendado;
	}

	// show agendaForm
	@RequestMapping(value = "agenda/showAgenda", method = RequestMethod.GET)
	public String showAgendaForm(Model model) {

		loger.debug("agenda/list");

		Agenda agenda = new Agenda();

		model.addAttribute("agenda", agenda);
		return "agenda/list";
	}

	// show agenda form to update
	@RequestMapping(value = "agenda/{id}/update", method = RequestMethod.POST)
	public String updateAgenda(@PathVariable("id") int id, Model model) {

		Agenda agenda = agendaServico.findById(id);
		model.addAttribute("agendaForm", agenda);

		return "agenda/userform";
	}

	// deletar agenda
	@RequestMapping(value = "agenda/{id}/deletar", method = RequestMethod.POST)
	public String deletaAgenda(@PathVariable("id") Integer id, Model model) {

		agendaServico.delete(id);
		return "redirect:/agenda";
	}

	// show detalhes agenda
	@RequestMapping(value = "agenda/{id}", method = RequestMethod.GET)
	public String showDetalhesAgenda(@PathVariable("id") Integer id, Model model) {

		Agenda agenda = agendaServico.findById(id);
		model.addAttribute("agenda", agenda);

		return "agenda/show";
	}
}
