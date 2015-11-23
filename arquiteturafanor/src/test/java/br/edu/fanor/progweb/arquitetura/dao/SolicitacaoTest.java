/**
 * 
 */
package br.edu.fanor.progweb.arquitetura.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.fanor.progweb.arquitetura.entity.Solicitacao;
import br.edu.fanor.progweb.arquitetura.entity.Usuario;

/**
 * @author Samantha Silva
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class SolicitacaoTest {

	@Autowired
	private SolicitacaoDAO soliDAO;

	public void testSalvar(){
		Solicitacao soli = new Solicitacao();
		
	}
}
