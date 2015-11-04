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
		usuario.setEmail("miwera@gmail.com");
		usuario.setLogin("mirewamar");
		usuario.setMatricula("1234253sdf");
		usuario.setNome("mmewn");
		usuario.setSenha("1234wew876");
		usuario.setTipoUsuario(TipoUsuario.COORDENADOR);
			
		usuarioDAO.salvar(usuario);
		
		Assert.assertNotNull(usuario.getId());
		System.out.println(usuario.getId());
		
	}
	
	@Test
	public void testListaPorNome(){
		List<Usuario> usuario = usuarioDAO.listarPorNome("adri");
		Assert.assertEquals(1, usuario.size());
	}

}
