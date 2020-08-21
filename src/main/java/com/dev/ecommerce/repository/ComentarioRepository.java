package com.dev.ecommerce.repository;

import com.dev.ecommerce.model.Comentario;
import com.dev.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {

    List<Comentario> findAllByProduto(Produto produto);
}
