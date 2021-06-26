package br.com.sistema.service;

import br.com.sistema.model.Cargo;
import br.com.sistema.model.Funcionario;

import java.util.List;

public interface FuncionarioService {
    public List<Funcionario> findAll();
    public Funcionario findById(Long id);
    public Funcionario findByEmail(String email);
    public String validarFuncionario(Funcionario funcionario);

    public List<Funcionario> findByCargo(Cargo cargo);
    public List<Funcionario> findByCargoIn(List<Cargo> cargos);


    public boolean save(Funcionario funcionario);
    public boolean deleteById(Long id);

}
