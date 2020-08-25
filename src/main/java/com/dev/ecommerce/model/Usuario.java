package com.dev.ecommerce.model;

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

    public Usuario() {
    }

    public Usuario(long id, String nome, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;
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