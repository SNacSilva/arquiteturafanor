package br.edu.fanor.progweb.arquitetura.manager.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.arquitetura.bussines.UsuarioBO;
import br.edu.fanor.progweb.arquitetura.entity.Usuario;
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
	private Usuario usuarioelecionado;

	public String atualizar() {
		usuarioBO.atualizar(usuarioelecionado);
		MessagesUtils.info("Usuário atualizado com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Usuario usuario) {
		usuarioelecionado = usuarioBO.buscarPorId(usuario.getId());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		usuarioelecionado.setNome("");
		usuarioelecionado.setEmail("");
		usuarioelecionado.setSenha("");
	}

	public Usuario getUsuarioelecionado() {
		return usuarioelecionado;
	}
	public void setUsuarioelecionado(Usuario Usuarioelecionado) {
		this.usuarioelecionado = Usuarioelecionado;
	}
	
}
