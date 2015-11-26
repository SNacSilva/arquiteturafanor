package br.edu.fanor.progweb.arquitetura.manager.usuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.arquitetura.bussines.UsuarioBO;
import br.edu.fanor.progweb.arquitetura.entity.Usuario;
import br.edu.fanor.progweb.arquitetura.exceptions.DAOException;
import br.edu.fanor.progweb.arquitetura.utils.Navigation;
/**
 * @author patrick.cunha
 * 
 */
@RequestScoped
@ManagedBean(name="listUsuario")
@Component(value="listUsuario")
public class ListUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	private String nome;
	private List<Usuario> usuario;
	
	public void lista(){
		
		usuario = usuarioBO.listaUsuarioPorNome(nome);
		
	}
	
	public void excluir(Usuario user) throws DAOException{
		usuarioBO.excluir(user);
		usuario = usuarioBO.listaUsuarioPorNome(nome);
	}
	
	public String preparaAtualizar(Usuario usuario){
		System.out.println(usuario.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.usuario = null;
	}
	
	
	public String salvar(){
		return null;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
}
