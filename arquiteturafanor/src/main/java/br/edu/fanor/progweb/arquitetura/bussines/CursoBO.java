package br.edu.fanor.progweb.arquitetura.bussines;

import br.edu.fanor.progweb.arquitetura.aspectj.Loggable;
import br.edu.fanor.progweb.arquitetura.aspectj.PermitAll;
import br.edu.fanor.progweb.arquitetura.aspectj.RolesAllowed;
import br.edu.fanor.progweb.arquitetura.dao.CursoDAO;
import br.edu.fanor.progweb.arquitetura.entity.Curso;
import br.edu.fanor.progweb.arquitetura.exceptions.BOException;
import br.edu.fanor.progweb.arquitetura.exceptions.DAOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Samantha Silva on 13/12/15.
 */

@Loggable
@Component
@Transactional(propagation=Propagation.REQUIRED)
public class CursoBO {

    @Autowired
    private CursoDAO cursoDAO;
    private Curso curse;

    @RolesAllowed(value = { "INCLUIR_CURSO" })
    public void salvar(Curso curso) throws BOException {

        curse = cursoDAO.buscarPorNome(curso.getNome());

        if(curse != null){
            throw new BOException("Já existe um curso cadastrado com esse nome");
        }
       cursoDAO.salvar(curso);

    }

    @RolesAllowed(value = { "ATUALIZAR_CURSO" })
    public void atualizar(Curso curso) throws BOException {

        curse = cursoDAO.buscarPorNome(curso.getNome());

        if(curse != null){
            throw new BOException("Já existe um curso cadastrado com esse nome");
        }
        cursoDAO.atualizar(curso);
    }

    @PermitAll
    @Loggable(enable = false)
    public Curso buscarPorNome(String nome){
        return cursoDAO.buscarPorNome(nome);
    }

    @RolesAllowed(value = { "LISTAR_CURSO" })
    @Loggable(enable = false)
    public List<Curso> listarPorNome(Curso descricao) {
        List<Curso> curso = cursoDAO.listarPorNome(descricao);
        return curso;
    }

    @RolesAllowed(value = { "EXCLUIR_CURSO" })
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void excluir(Curso curso) throws DAOException {

        curso = cursoDAO.buscarPorNome(curso.getNome());
        cursoDAO.excluir(curso);

    }

}
