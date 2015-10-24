package br.edu.fanor.progweb.arquitetura.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Coordenador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "alocado_id")
	private Alocado alocado;
	
	@ManyToOne
	@JoinColumn(name = "solicitacao_id")
	private TipoSolicitacao solicitacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Alocado getAlocado() {
		return alocado;
	}

	public void setAlocado(Alocado alocado) {
		this.alocado = alocado;
	}

	public TipoSolicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(TipoSolicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
}
