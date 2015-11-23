/**
 * 
 */
package br.edu.fanor.progweb.arquitetura.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.fanor.progweb.arquitetura.entity.Atendimento;

/**
 * @author Samantha Silva
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class AtendimentoTestDAO {
	
	@Autowired
	private AtendimentoDAO atDAO;
	
	@Test
	public void salvarTest(){
		Atendimento at = new Atendimento();
		
	}

}
