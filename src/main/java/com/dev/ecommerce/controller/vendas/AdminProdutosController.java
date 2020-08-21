package com.dev.ecommerce.controller.vendas;

import com.dev.ecommerce.model.Produto;
import com.dev.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vendas/produtos")
public class AdminProdutosController {

    private ProdutoRepository produtoRepository;

    @Autowired
    public AdminProdutosController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @PutMapping("/{id}")
    public Produto putProduto(@PathVariable("id") long id, Produto produto){
        produto.setId(id);
        return this.produtoRepository.save(produto);
    }

    @DeleteMapping("/{id]")
    public boolean deleteProduto(@PathVariable("id") long id){
        this.produtoRepository.deleteById(id);
        return this.produtoRepository.existsById(id);
    }

    @PostMapping()
    public Produto postProduto(Produto produto){
        return produtoRepository.save(produto);
    }
}
