package br.edu.fanor.progweb.arquitetura.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import br.edu.fanor.progweb.arquitetura.enums.TipoStatus;
import br.edu.fanor.progweb.arquitetura.enums.TipoUsuario;

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
	
	@Enumerated(EnumType.ORDINAL)
	private TipoStatus tipoStatus;
	
	@Column
	private String descricao;
	
	@OneToOne(mappedBy = "solicitacao")
	private Atendimento atendimento;

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

	public TipoStatus getTipoStatus() {
		return tipoStatus;
	}

	public void setTipoStatus(TipoStatus tipoStatus) {
		this.tipoStatus = tipoStatus;
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
