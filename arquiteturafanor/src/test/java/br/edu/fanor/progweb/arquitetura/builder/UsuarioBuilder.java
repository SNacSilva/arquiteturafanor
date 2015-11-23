package br.edu.fanor.progweb.arquitetura.builder;

import br.edu.fanor.progweb.arquitetura.entity.Usuario;

public class UsuarioBuilder {
	
	private Usuario usuario;
	
	public UsuarioBuilder() {
		usuario = new Usuario();
	}
	
	public UsuarioBuilder comNome(){
		usuario.setNome("adriano patrick");
		return this;
	}
	
	public UsuarioBuilder comSenha(){
		usuario.setSenha("123456");
		return this;
	}
	
	public UsuarioBuilder comEmail(){
		usuario.setEmail("adriano@gmail.com");
		return this;
	}
	
	
	
	public Usuario build(){
		return usuario;
	}
	
}
