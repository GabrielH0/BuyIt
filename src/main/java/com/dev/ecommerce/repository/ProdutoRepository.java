package com.dev.ecommerce.repository;

import com.dev.ecommerce.model.Produto;
import com.dev.ecommerce.model.comercial.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Override
    List<Produto> findAll();

    List<Produto> findAllByEmpresa(Empresa empresa);
}
