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
import br.edu.fanor.progweb.arquitetura.exceptions.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class UsuarioDAOTest {

	@Autowired
	private UsuarioDAO usuarioDAO;
	/*
	 * @Test public void testSalvar() throws Exception {
	 * 
	 * Usuario usuario = new Usuario();
	 * 
	 * usuario.setEmail("samantha@gmail.com"); usuario.setLogin("samnasc");
	 * usuario.setMatricula("123456"); usuario.setNome("Samantha");
	 * usuario.setSenha("123476"); usuario.setTipoUsuario(TipoUsuario.ALUNO);
	 * 
	 * usuarioDAO.salvar(usuario);
	 * 
	 * Assert.assertNotNull(usuario.getId());
	 * System.out.println(usuario.getId());
	 * 
	 * }
	 */

	@Test
	public void testListaPorNome() {
		List<Usuario> usuario = usuarioDAO.listarPorNome("Samantha");
		Assert.assertEquals(1, usuario.size());
	}

	@Test
	public void testBuscarPorEmail() {
		Usuario usuario = usuarioDAO.buscarPorEmail("samantha@gmail.com");
		Assert.assertEquals(usuario.getEmail(), usuario.getEmail());
	}

	@Test
	public void testBuscarPorEmailSenha() {
		Usuario usuario = usuarioDAO.buscarPorEmailSenha("samantha@gmail.com", "123476");
		Assert.assertEquals(usuario.getEmail(), usuario.getEmail());
		Assert.assertEquals(usuario.getSenha(), usuario.getSenha());
		
	}

	/*
	 * @Test public void testBuscarPorId() throws DAOException{ Usuario usuario
	 * = usuarioDAO.buscaPorId(36); Assert.assertEquals(1,usuario.getId()); }*
	 * 
	 * @Test public void testRemover(){
	 * 
	 * Usuario usuario = new Usuario(); usuario.setEmail("samantha@gmail.com");
	 * usuario.setLogin("samnasc"); usuario.setMatricula("123456");
	 * usuario.setNome("Samantha"); usuario.setSenha("123476");
	 * usuario.setTipoUsuario(TipoUsuario.ALUNO); usuarioDAO.excluir(usuario); }
	 * 
	 * @Test public void testAtualizar(){
	 * 
	 * Usuario usuario = new Usuario(); usuario.setEmail("samantha@gmail.com");
	 * usuario.setLogin("samnasc"); usuario.setMatricula("123456");
	 * usuario.setNome("Samantha"); usuario.setSenha("123476");
	 * usuario.setTipoUsuario(TipoUsuario.ALUNO); usuarioDAO.atualizar(usuario);
	 * 
	 * }
	 */

}
