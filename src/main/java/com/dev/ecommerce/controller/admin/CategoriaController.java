package com.dev.ecommerce.controller.admin;

import com.dev.ecommerce.model.Categoria;
import com.dev.ecommerce.repository.admin.CategoriaRepository;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/categorias")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @RequestMapping("/")
    public List<Categoria> getAll(){
        return categoriaRepository.findall();
    }

    @PostMapping("/")
    public Categoria postCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @PutMapping("/")
    public Categoria putCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/")
    public void deleteCategoria(Long id) throws NotFoundException {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()){
            categoriaRepository.delete(categoria.get());
        } else {
            throw new NotFoundException("Categoria não encontrada");
        }
    }
}
