package com.Projeto.Loja.Controller;


import com.Projeto.Loja.Model.Cliente;
import com.Projeto.Loja.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCliente")
public class ClienteController {

    @Autowired
    ClienteRepository clRepo;

    //metodos Gets.
    @GetMapping("/todos")
    public List buscaTodos(){
        return clRepo.findAll();
    }

    @GetMapping("/buscacodigo/{codigo}")
    public Optional buscaCodigo(@PathVariable("codigo") int cod){
        return clRepo.findById(cod);
    }

    @GetMapping("/partenome/{nome}")
    public List<Cliente> buscaParteNome(@PathVariable("nome") String nome){
        return clRepo.findByParteNome(nome);
    }

    @GetMapping("/buscaremail/{email}")
    public List<Cliente> buscarEmail(@PathVariable("email") String email){
        return clRepo.findByEmail(email);
    }

    @GetMapping("/buscarnomeemail/{nome}/{email}")
    public List<Cliente> buscarNomeEmail(@PathVariable("nome") String nome, @PathVariable("email") String email){
        return clRepo.findByNomeEmail(nome, email);
    }

    //metodos Delete
    @DeleteMapping("/removecliente")
    public void removeCliente(@RequestBody Cliente cliente){
        clRepo.delete(cliente);
    }

    @DeleteMapping("/removeporid/{codigo}")
    public void removePorCod(@PathVariable("codigo") int cod){
        clRepo.deleteById(cod);
    }

    //metodos put
    @PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cliente){
        clRepo.save(cliente);
    }

    //metodos post
    @PostMapping("/inserircliente")
    public void inserirCliente(@RequestBody Cliente cliente){
        clRepo.save(cliente);
    }
}
