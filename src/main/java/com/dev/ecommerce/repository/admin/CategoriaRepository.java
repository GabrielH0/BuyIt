package com.dev.ecommerce.repository.admin;

import com.dev.ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findall();

    @Override
    Optional<Categoria> findById(Long aLong);
}
