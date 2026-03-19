package br.senai.estoque.gerenciamento_estoque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios_autenticados")
public class FuncionarioAutenticado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, length = 20, unique = true)
    private String nif;

    @Column(nullable = false)
    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNif() {
        return nif;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}