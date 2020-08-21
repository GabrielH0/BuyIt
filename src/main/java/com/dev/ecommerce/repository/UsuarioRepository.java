package com.dev.ecommerce.repository;


import com.dev.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    List<Usuario> findAll();

    Usuario findById(long id);
    Optional<Usuario> findByUsername(String username);
}
