package br.com.sistema.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "funcionario")
public class Funcionario {

    //atributos
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Size(max=80)
    @NotNull
    private String nome;

    @Size(max = 100)
    @NotNull
    private String email;

    @Size(max = 30)
    @NotNull
    private String zap;

    @OneToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    @ManyToMany(mappedBy = "funcionarios")
    private List<Projeto> projetos;



    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZap() {
        return zap;
    }

    public void setZap(String zap) {
        this.zap = zap;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nE-mail: " + email +
                "\nZap: " + zap;
    }
}
