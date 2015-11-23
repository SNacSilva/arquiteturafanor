/**
 * 
 */
package br.edu.fanor.progweb.arquitetura.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.fanor.progweb.arquitetura.entity.Curso;
import br.edu.fanor.progweb.arquitetura.entity.Usuario;
import br.edu.fanor.progweb.arquitetura.exceptions.DAOException;

/**
 * @author Samantha Silva
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class CursoTestDAO {

	@Autowired
	private CursoDAO cursoDAO;

	@Test
	public void testSalvar() throws Exception {

		Curso curso = new Curso();

		curso.setNome("Culinaria");

		cursoDAO.salvar(curso);
	}

	@Test
	public void testListaPorNome() {
		List<Curso> curso = cursoDAO.listarPorNome("Analise e Desenvolvimento de Sistemas");
		Assert.assertEquals(1, curso.size());
	}

	@Test
	public void testRemover() {
		Curso curso = new Curso();

		curso.setNome("Culinaria");

		cursoDAO.excluir(curso);

	}

	@Test
	public void testAtualizar() {
		
		Curso curso = new Curso();
		curso.setNome("Culinaria");
		cursoDAO.atualizar(curso);
	}

}
