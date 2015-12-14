package br.edu.fanor.progweb.arquitetura.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.aspectj.Loggable;
import br.edu.fanor.progweb.arquitetura.aspectj.PermitAll;
import br.edu.fanor.progweb.arquitetura.aspectj.RolesAllowed;
import br.edu.fanor.progweb.arquitetura.dao.UsuarioDAO;
import br.edu.fanor.progweb.arquitetura.entity.Usuario;
import br.edu.fanor.progweb.arquitetura.exceptions.BOException;
import br.edu.fanor.progweb.arquitetura.exceptions.DAOException;

/**
 * @author patrick.cunha
 * 
 */

@Loggable
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioBO {

	@Autowired
	private UsuarioDAO usuarioDAO;
	private Usuario user;

	@RolesAllowed(value = { "INCLUIR_USUARIO" })
	public void salvar(Usuario usuario) throws BOException {

		user = usuarioDAO.buscarPorLogin(usuario.getLogin());
		if (user != null) {
			throw new BOException("Já existe um usuário cadastrado com esse login");
		}
		user = usuarioDAO.buscarPorEmail(usuario.getEmail());
		if (user != null) {
			throw new BOException("Já existe um usuário cadastrado com esse e-mail");
		}
		usuarioDAO.salvar(usuario);
	}

	@RolesAllowed(value = { "ALTERAR_USUARIO" })
	public void atualizar(Usuario usuario) throws BOException {
		user = usuarioDAO.buscarPorLogin(usuario.getLogin());
		if (user != null) {
			throw new BOException("Já existe um usuário cadastrado com esse login");
		}
		user = usuarioDAO.buscarPorEmail(usuario.getEmail());
		if (user != null) {
			throw new BOException("Já existe um usuário cadastrado com esse e-mail");
		}

		usuarioDAO.atualizar(usuario);
	}

	@PermitAll
	@Loggable(enable = false)
	public Usuario loggar(String login, String senha) throws BOException {
		user = usuarioDAO.buscarPorLoginSenha(login, senha);
		if (user == null) {
			throw new BOException("Os dados de login não conferem.");
		}
		return user;

	}

	@PermitAll
	@Loggable(enable = false)
	public Usuario buscarUsuarioPorEmail(String email) {
		return usuarioDAO.buscarPorEmail(email);
	}

	@RolesAllowed(value = { "LISTAR_USUARIO" })
	@Loggable(enable = false)
	public List<Usuario> listaUsuarioPorNome(String nome) {
		List<Usuario> usuario = usuarioDAO.listarPorNome(nome);
		return usuario;
	}

	@PermitAll
	@Loggable(enable = false)
	public Usuario buscarPorId(Integer id) {
		try {
			return usuarioDAO.buscaPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RolesAllowed(value = { "EXCLUIR_USUARIO" })
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void excluir(Usuario usuario) throws DAOException {
		usuario = usuarioDAO.buscaPorId(usuario.getId());
		usuarioDAO.excluir(usuario);
	}

}
