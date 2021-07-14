package br.com.elaw.agenda.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.elaw.agenda.controllers.dto.AgendaDto;
import br.com.elaw.agenda.entities.Agenda;
import br.com.elaw.agenda.repositories.AgendaRepository;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

	@Autowired
	private AgendaRepository agendaRepository;
	
	@GetMapping("/novo")
	public String novo(Model model) {
		
		model.addAttribute("agenda", new AgendaDto());
		
		return "agenda/cadastra";
	}
	
	@PostMapping("/cadastra")
	public String cadastra(@Valid AgendaDto agendaDto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("erro", "Erro ao tentar cadastrar um Compromisso: " + result.getAllErrors().get(0).getDefaultMessage());
			model.addAttribute("agenda", agendaDto);
			
			return "agenda/cadastra";
		}
		
		Agenda agenda = agendaDto.converter();
		
		agendaRepository.save(agenda);
		
		return "redirect:/";
	}
	
	@GetMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		
		agendaRepository.deleteById(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/edita/{id}")
	public String edita(@PathVariable int id, Model model) {
		
		var agendaOptional = agendaRepository.findById(id);
		
		if (agendaOptional.isPresent()) {
			
			var agenda = agendaOptional.get();
			
			var agendaDto = new AgendaDto(agenda);
			
			model.addAttribute("agenda", agendaDto);
			
		}
		
		return "agenda/cadastra";
	}
}
