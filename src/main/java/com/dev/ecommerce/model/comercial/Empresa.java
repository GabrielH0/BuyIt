package com.dev.ecommerce.model.comercial;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nome;
    @Column
    private String cnpj;
    @Column
    private String endereco;
    @Column
    private LocalDate dataCriacaoEmpresa;
    @Column
    private LocalDate dataInicioOperacao;

    public Empresa() {
    }

    public Empresa(String cnpj, String endereco, LocalDate dataCriacaoEmpresa, LocalDate dataInicioOperacao) {
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.dataCriacaoEmpresa = dataCriacaoEmpresa;
        this.dataInicioOperacao = dataInicioOperacao;
    }

}
