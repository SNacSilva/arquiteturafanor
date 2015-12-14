package br.edu.fanor.progweb.arquitetura.bussines;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.aspectj.Loggable;
import br.edu.fanor.progweb.arquitetura.aspectj.PermitAll;
import br.edu.fanor.progweb.arquitetura.aspectj.RolesAllowed;
import br.edu.fanor.progweb.arquitetura.dao.SolicitacaoDAO;
import br.edu.fanor.progweb.arquitetura.entity.Solicitacao;
import br.edu.fanor.progweb.arquitetura.exceptions.DAOException;

/**
 * Created by Samantha Silva on 13/12/15.
 */

@Loggable
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class SolicitacaoBO {

	@Autowired
	private SolicitacaoDAO soliDAO;
	private Solicitacao soli;
	private AtendimentoBO att;

	@RolesAllowed(value = { "INCLUIR_SOLICITACAO" })
	public void salvar(Solicitacao solicitacao) {

		soliDAO.salvar(solicitacao);
		
	}

	@RolesAllowed(value = { "ATUALIZAR_SOLICITACAO" })
	public void atualizar(Solicitacao solicitacao) {

		soli = soliDAO.buscarPorSolicitacao(solicitacao);
		soliDAO.atualizar(soli);

	}

	@PermitAll
	@Loggable(enable = false)
	public Solicitacao buscarPorSolicitacao(Solicitacao solicitacao) {
		return soliDAO.buscarPorSolicitacao(solicitacao);
	}

	@PermitAll
	@Loggable(enable = false)
	public Solicitacao buscarPorSolicitacaoHorario(Calendar data, Calendar hora) {

		soli = soliDAO.buscarPorSolicitacaoHorario(data, hora);
		return soli;

	}

	@RolesAllowed(value = { "LISTAR_SOLICITACOES_HORA" })
	@Loggable(enable = false)
	public List<Solicitacao> listarPorHorario(Calendar hora) {

		List<Solicitacao> sol = soliDAO.listarPorHorario(hora);
		return sol;
	}

	@PermitAll
	@Loggable(enable = false)
	public Solicitacao buscaPorId(Integer id) {
		try {
			return soliDAO.buscaPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;

	}



	@RolesAllowed(value = { "EXCLUIR_SOLICITACAO" })
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void excluir(Solicitacao solicitacao) throws DAOException {
		
		solicitacao = soliDAO.buscaPorId(solicitacao.getId());
		soliDAO.excluir(solicitacao);
	}
}
