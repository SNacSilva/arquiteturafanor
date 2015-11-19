package br.edu.fanor.progweb.arquitetura.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.fanor.progweb.arquitetura.dao.UsuarioDAO;
import br.edu.fanor.progweb.arquitetura.entity.Usuario;
import br.edu.fanor.progweb.arquitetura.enums.TipoUsuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class UsuarioDAOTest {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	

	@Test
	public void testSalvar() throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setEmail("samantha@hotmail.com");
		usuario.setLogin("sns");
		usuario.setMatricula("12345u5");
		usuario.setNome("Samantha");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(TipoUsuario.ALUNO);
			
		usuarioDAO.salvar(usuario);
		
		Assert.assertNotNull(usuario.getId());
		System.out.println(usuario.getId());
		
	}
	
	@Test
	public void testListaPorNome(){
		List<Usuario> usuarios = usuarioDAO.listarPorNome("qwerasd");
		Assert.assertEquals(1, usuarios.size());
		}
	
	@Test
	public void testBuscarPorEmail(){
		Usuario usuarios = usuarioDAO.buscarPorEmail("samantha@gmail.com");
		Assert.assertEquals(1, usuarios);
	}
	
	

}
