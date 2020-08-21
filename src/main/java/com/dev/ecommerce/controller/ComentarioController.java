package com.dev.ecommerce.controller;

import com.dev.ecommerce.model.Comentario;
import com.dev.ecommerce.model.Produto;
import com.dev.ecommerce.repository.ComentarioRepository;
import com.dev.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    ComentarioRepository comentarioRepository;
    ProdutoRepository produtoRepository;

    @Autowired
    public ComentarioController(ComentarioRepository comentarioRepository, ProdutoRepository produtoRepository){
        this.comentarioRepository = comentarioRepository;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/{id}")
    public List<Comentario> getComentario(@PathVariable("id") long id){
        final Produto produto = produtoRepository.findById(id).get();
        return comentarioRepository.findAllByProduto(produto);
    }
}
