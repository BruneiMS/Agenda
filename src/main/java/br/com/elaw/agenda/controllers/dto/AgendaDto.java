package br.com.elaw.agenda.controllers.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.elaw.agenda.entities.Agenda;

public class AgendaDto {

	private int id;
	
	@NotNull
	@NotBlank(message = "O campo Nome não pode ser vazio.")
	private String nome;
	
	@NotNull
	@NotBlank(message = "O campo Descrição não pode ser vazio.")
	private String descricao;
	
	@NotNull
	@NotBlank(message = "O campo Data do Compromisso não pode ser vazio.")
	private String dataAgendamento;
	
	private String dataCriacao;

	public AgendaDto() {}
	
	public AgendaDto(Agenda t) {
		this.id = t.getId();
		this.nome= t.getNome();
		this.descricao = t.getDescricao();
		this.dataAgendamento = t.getDataAgendamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.dataCriacao = t.getDataCriacao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Agenda converter() {
		
		var data = LocalDate.parse(this.dataAgendamento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		return new Agenda(this.id, this.nome, this.descricao, data);
		
	}
		
}
