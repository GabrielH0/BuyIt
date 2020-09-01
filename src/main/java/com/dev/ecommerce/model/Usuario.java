package com.dev.ecommerce.model;

import com.dev.ecommerce.model.comercial.Empresa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nome;
    @Column
    private String username;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoDoUsuario;
    @OneToOne
    private Empresa empresa;

    public Usuario() {
    }

    public Usuario(String nome, String username, String password) {
        this.nome = nome;
        this.username = username;
        this.password = password;
    }

    public Usuario(String nome, String username, String password, Empresa empresa) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.empresa = empresa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return username.equals(usuario.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}