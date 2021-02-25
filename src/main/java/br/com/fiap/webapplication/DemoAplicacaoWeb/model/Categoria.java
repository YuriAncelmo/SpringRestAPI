package br.com.fiap.webapplication.DemoAplicacaoWeb.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name="categoria", sequenceName = "SQ_CATEGORIA", allocationSize = 1)
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @Size(max=50)
    private String nome;

    //Uma categoria para vários produtos
    @ManyToOne(targetEntity=Produto.class, fetch=FetchType.EAGER)
    private Produto produto;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
