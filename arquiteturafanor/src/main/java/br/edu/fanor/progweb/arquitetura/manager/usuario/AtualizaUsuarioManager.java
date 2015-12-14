package br.edu.fanor.progweb.arquitetura.manager.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.arquitetura.bussines.UsuarioBO;
import br.edu.fanor.progweb.arquitetura.entity.Usuario;
import br.edu.fanor.progweb.arquitetura.exceptions.BOException;
import br.edu.fanor.progweb.arquitetura.utils.MessagesUtils;
import br.edu.fanor.progweb.arquitetura.utils.Navigation;
/**
 * @author patrick.cunha
 * 
 */
@RequestScoped
@ManagedBean(name = "atualizaUsuario")
@Component(value = "atualizaUsuario")
public class AtualizaUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	private Usuario Usuarioelecionado;

	public String atualizar() throws BOException {
		usuarioBO.atualizar(Usuarioelecionado);
		MessagesUtils.info("Usuário atualizado com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Usuario usuario) {
		Usuarioelecionado = usuarioBO.buscarPorId(usuario.getId());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		Usuarioelecionado.setNome("");
		Usuarioelecionado.setEmail("");
		Usuarioelecionado.setSenha("");
	}

	public Usuario getUsuarioelecionado() {
		return Usuarioelecionado;
	}
	public void setUsuarioelecionado(Usuario Usuarioelecionado) {
		this.Usuarioelecionado = Usuarioelecionado;
	}
	
}
