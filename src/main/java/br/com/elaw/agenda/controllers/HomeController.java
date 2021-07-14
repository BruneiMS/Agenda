package br.com.elaw.agenda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.elaw.agenda.controllers.dto.AgendaDto;
import br.com.elaw.agenda.repositories.AgendaRepository;

@Controller
public class HomeController {

	@Autowired
	private AgendaRepository agendaRepository;
	
	@RequestMapping("")
	public String home(Model model) {
		
		model.addAttribute("agendas", retornaAgendaDto());
		
		return "index";
	}

	private List<AgendaDto> retornaAgendaDto() {
		
		var agendaDto = new ArrayList<AgendaDto>();
		
		agendaRepository.findAll().forEach(t ->{
			agendaDto.add(new AgendaDto(t));
		});
		
		return agendaDto;
	}
}
