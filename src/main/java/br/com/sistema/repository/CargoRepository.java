package br.com.sistema.repository;

import br.com.sistema.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    public Cargo findByNome(String nome);

    public Cargo findByIdNotAndNome(Long id, String nome);

    //segundo
    public List<Cargo> findByNomeNot(String nome);

}
