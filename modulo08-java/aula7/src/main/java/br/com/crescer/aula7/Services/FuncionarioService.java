package br.com.crescer.aula7.Services;

import br.com.crescer.aula7.Entidades.Funcionario;
import br.com.crescer.aula7.Repositorios.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexia.pereira
 */
@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repositorio;

    public Iterable<Funcionario> findAll() {
        return repositorio.findAll();
    }

    public Funcionario save(Funcionario funcionario) {
        return repositorio.save(funcionario);
    }

    public Funcionario update(Funcionario funcionario) {
        return repositorio.save(funcionario);
    }

    public void remove(Funcionario funcionario) {
        repositorio.delete(funcionario);
    }

    public Funcionario loadById(Long id) {
        return repositorio.findOne(id);
    }

}
