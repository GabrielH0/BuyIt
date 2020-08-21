package com.dev.ecommerce.controller;

import com.dev.ecommerce.model.Usuario;
import com.dev.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UserController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping(value = "/")
    public String home(){
        return"home";
    }

    @GetMapping(value = "/user")
    public List<Usuario> getUsers(){
        return usuarioRepository.findAll();
    }

    @PostMapping(value = "/user")
    public Usuario postUser(Usuario user){
        return usuarioRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public Usuario getUsuario(@PathVariable("id") long id){
        return usuarioRepository.findById(id);
    }

    @PutMapping("/user/{id}")
    public Usuario putUsuario(@PathVariable("id") long id, Usuario usuario){
        usuario.setId(id);
        return this.usuarioRepository.save(usuario);

    }

    @DeleteMapping("/user/{id]")
    public boolean deleteUsuario(@PathVariable("id") long id){
        this.usuarioRepository.deleteById(id);
        return this.usuarioRepository.existsById(id);
    }
}