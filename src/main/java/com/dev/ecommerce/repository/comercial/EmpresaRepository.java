package com.dev.ecommerce.repository.comercial;

import com.dev.ecommerce.model.comercial.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Override
    Optional<Empresa> findById(Long aLong);
}
