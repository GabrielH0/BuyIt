package com.dev.ecommerce.model;

import com.dev.ecommerce.model.comercial.Empresa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private double preco;

    private String descricao;

    private int quantidade;

    private String imagem = "NoImage.png";

    @OneToOne
    private Empresa empresa;

    @ManyToMany
    @JoinTable(name = "categoria_produto",joinColumns = {
            @JoinColumn(name = "produto_id")},inverseJoinColumns =
            {@JoinColumn(name = "categoria_id")})
    private List<Categoria> categorias;
}
