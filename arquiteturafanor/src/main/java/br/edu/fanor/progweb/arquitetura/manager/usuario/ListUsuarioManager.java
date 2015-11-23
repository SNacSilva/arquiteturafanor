package br.edu.fanor.progweb.arquitetura.manager.usuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.arquitetura.bussines.UsuarioBO;
import br.edu.fanor.progweb.arquitetura.entity.Usuario;
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
	private List<Usuario> usuarios;
	
	public void lista(){
		
		usuarios = usuarioBO.listaUsuarioPorNome(nome);
		
	}
	
	public void excluir(Usuario usuario){
		usuarioBO.excluir(usuario);
		usuarios = usuarioBO.listaUsuarioPorNome(nome);
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
		this.usuarios = null;
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
		return usuarios;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuarios = usuario;
	}
	
}
