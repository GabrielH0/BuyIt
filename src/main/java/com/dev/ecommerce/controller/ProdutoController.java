package com.dev.ecommerce.controller;

import com.dev.ecommerce.model.Comentario;
import com.dev.ecommerce.model.Produto;
import com.dev.ecommerce.repository.ComentarioRepository;
import com.dev.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    private ProdutoRepository produtoRepository;
    private ComentarioRepository comentarioRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository,ComentarioRepository comentarioRepository){
        this.produtoRepository = produtoRepository;
        this.comentarioRepository = comentarioRepository;
    }

    @GetMapping(value = "/listar")
    public List<Produto> getProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> getProduto(@PathVariable("id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/{id}")
    public Comentario postComentario(@PathVariable("id") long id,  @RequestBody Comentario comentario){
        System.out.println(comentario.getConteudo()+ ","+comentario.getAutor()+","+comentario.getProduto());
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            Produto p = produto.get();
            comentario.setProduto(p);
        }
        return this.comentarioRepository.save(comentario);
    }

}
