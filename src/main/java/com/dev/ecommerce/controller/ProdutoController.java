package com.dev.ecommerce.controller;

import com.dev.ecommerce.model.Comentario;
import com.dev.ecommerce.model.Produto;
import com.dev.ecommerce.model.comercial.Empresa;
import com.dev.ecommerce.repository.ComentarioRepository;
import com.dev.ecommerce.repository.ProdutoRepository;
import com.dev.ecommerce.repository.comercial.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    private ProdutoRepository produtoRepository;
    private ComentarioRepository comentarioRepository;
    private EmpresaRepository empresaRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository,ComentarioRepository comentarioRepository, EmpresaRepository empresaRepository){
        this.produtoRepository = produtoRepository;
        this.comentarioRepository = comentarioRepository;
        this.empresaRepository = empresaRepository;
    }

    @GetMapping(value = "/listar/{empresa}")
    public List<Produto> getProdutos(@PathVariable("empresa") Long id){
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            return produtoRepository.findAllByEmpresa(empresa.get());
        }
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Optional<Produto> getProduto(@PathVariable("id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/{id}")
    public Comentario postComentario(@PathVariable("id") long id,  @RequestBody Comentario comentario){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            Produto p = produto.get();
            comentario.setProduto(p);
        }
        return this.comentarioRepository.save(comentario);
    }

    @PostMapping("/new")
    public Produto postProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}
