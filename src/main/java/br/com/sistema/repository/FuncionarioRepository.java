package br.com.sistema.repository;

import br.com.sistema.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    public Funcionario findByEmail(String email);
    public Funcionario findByNome(String nome);
    public Funcionario findByZap(String zap);
    public Funcionario findByIdNotAndEmail(Long id, String email);
    public Funcionario findByIdNotAndNome(Long id, String nome);
}
