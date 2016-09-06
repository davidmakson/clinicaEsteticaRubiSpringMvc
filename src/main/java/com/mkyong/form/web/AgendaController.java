package com.mkyong.form.web;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mkyong.form.model.Agenda;
import com.mkyong.form.model.User;
import com.mkyong.form.service.AgendaServico;
import com.mkyong.form.validator.AgendaValidatorForm;

@Controller
public class AgendaController {

	private final Logger loger = LoggerFactory.getLogger(AgendaController.class);
	
	@Autowired
	AgendaValidatorForm agendaValidatorForm;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(agendaValidatorForm);
	}
	
	private AgendaServico agendaServico;
	
	@Autowired
	public void setAgendaServico(AgendaServico agendaServico){
		this.agendaServico = agendaServico;
	}
	
	@RequestMapping(value = "/agenda", method=RequestMethod.GET)
	public String showAll(Model model){
		
		loger.debug("/agenda");
		
		model.addAttribute("agenda", agendaServico.findAll());
		return "agenda/list";
	}
	
	@RequestMapping(value = "/agenda/add", method=RequestMethod.GET)
	public String saveOrUpdate(Model model){
		
		loger.debug("/agenda/agendaform");
		
		Agenda agenda = new Agenda();
		
		model.addAttribute("agendaform",agenda);
		return "agenda/agendaform";
	}
	
	// save or update user
		@RequestMapping(value = "/agenda/add", method = RequestMethod.POST)
		public String saveOrUpdateUser(@ModelAttribute("agendaform") @Validated Agenda agenda,
				BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

			loger.debug("/agenda/add POST ", agenda);

			if (result.hasErrors()) {

				model.addAttribute("agendaform",agenda);
				return "/agenda/agendaform";
				
			} else {

				redirectAttributes.addFlashAttribute("css", "success");
				if(agenda.isNew()){
					redirectAttributes.addFlashAttribute("msg", "Agenda adicionada com sucesso!");
				}else{
					redirectAttributes.addFlashAttribute("msg", "Agenda atualizada com sucesso!");
				}
				
				agendaServico.saveOrUpdate(agenda);

				// POST/REDIRECT/GET
				return "redirect:/agenda/" +agenda.getId();
			}

		}
		
	//show agendaForm
	@RequestMapping(value="agenda/showAgenda", method=RequestMethod.GET)
	public String showAgendaForm(Model model){
		
		loger.debug("agenda/list");
		
		Agenda agenda = new Agenda();
		
		model.addAttribute("agenda", agenda);
		return "agenda/list";
	}
	
	//show agenda form to update
	@RequestMapping(value = "agenda/{id}/update", method= RequestMethod.POST)
	public String updateAgenda(@PathVariable("id") int id, Model model){
		
		Agenda agenda = agendaServico.findById(id);
		model.addAttribute("agendaForm", agenda);
		
		return "agenda/userform";
	}
	
	//deletar agenda
	@RequestMapping(value = "agenda/{id}/deletar", method=RequestMethod.POST)
	public String deletaAgenda(@PathVariable("id")Integer id, Model model){
		
		agendaServico.delete(id);
		return "redirect:/agenda";
	}
	
	//show detalhes agenda
	@RequestMapping(value="agenda/{id}", method=RequestMethod.GET)
	public String showDetalhesAgenda(@PathVariable("id") Integer id,Model model){
		
		Agenda agenda = agendaServico.findById(id);
		model.addAttribute("agenda", agenda);
		
		return "agenda/show";
	}
}