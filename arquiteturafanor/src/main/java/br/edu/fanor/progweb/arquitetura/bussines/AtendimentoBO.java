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
import br.edu.fanor.progweb.arquitetura.dao.AtendimentoDAO;
import br.edu.fanor.progweb.arquitetura.dao.SolicitacaoDAO;
import br.edu.fanor.progweb.arquitetura.entity.Atendimento;
import br.edu.fanor.progweb.arquitetura.exceptions.DAOException;

/**
 * @author Samantha Silva on Dec 13, 2015
 **/

@Loggable
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class AtendimentoBO {

	@Autowired
	private Atendimento att;
	private AtendimentoDAO attDAO;
	private SolicitacaoDAO soliDAO;

	@RolesAllowed(value = { "INCLUIR_ATENDIMENTO" })
	public void salvar(Atendimento atendimento) {

		attDAO.salvar(atendimento);

	}

	@PermitAll
	@Loggable(enable = false)
	public Atendimento buscarPorAtendimento(Calendar data) {
		return attDAO.buscarPorAtendimento(data);
	}

	@PermitAll
	@Loggable(enable = false)
	public Atendimento buscarPorDataHora(Calendar data, Calendar hora) {

		att = attDAO.buscarPorDataHora(data, hora);
		return att;

	}

	@RolesAllowed(value = { "LISTAR_SOLICITACOES_HORA" })
	@Loggable(enable = false)
	public List<Atendimento> listarPorHorario(Calendar hora){

		List<Atendimento> ate = attDAO.listarPorHorario(hora);
		return ate;
	}

	@PermitAll
	@Loggable(enable = false)
	public Atendimento buscaPorId(Integer id) throws DAOException{
		try {
			return attDAO.buscaPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RolesAllowed(value = { "EXCLUIR_SOLICITACAO" })
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void excluir(Atendimento atendimento) throws DAOException {

		atendimento = attDAO.buscaPorId(atendimento.getId());
		attDAO.excluir(atendimento);
	}

}
