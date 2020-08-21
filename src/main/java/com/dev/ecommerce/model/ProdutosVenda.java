package com.dev.ecommerce.model;

import javax.persistence.*;

@Entity
public class ProdutosVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Produto produto;

    private int quantidade;

    @ManyToOne
    private Venda venda;
}
