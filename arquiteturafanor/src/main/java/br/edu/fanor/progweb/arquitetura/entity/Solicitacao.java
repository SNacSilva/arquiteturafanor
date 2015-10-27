package br.edu.fanor.progweb.arquitetura.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Solicitacao {

	@Id
	@Column(name = "solicitacao_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "solicitante_usuario_fk", referencedColumnName = "usuario_id")
	private Usuario solicitante;		
	
	@ManyToOne
	@JoinColumn(name = "tipo_solicitacao_fk", referencedColumnName = "tipo_solicitacao_id")
	private TipoSolicitacao tipoSolicitacao;
	
	@Column(name = "status_id")
	private int status;
	
	@Column
	private String descricao;
	
	@OneToOne(mappedBy = "solicitacao")
	private Atendimento atendimento;

	
	public Solicitacao(Long id, Usuario solicitante,
			TipoSolicitacao tipoSolicitacao, int status, String descricao,
			Atendimento atendimento) {
		this.id = id;
		this.solicitante = solicitante;
		this.tipoSolicitacao = tipoSolicitacao;
		this.status = status;
		this.descricao = descricao;
		this.atendimento = atendimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

	public TipoSolicitacao getTipoSolicitacao() {
		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}	
}
