package com.Projeto.Loja.Controller;

import com.Projeto.Loja.Model.Produto;
import com.Projeto.Loja.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProduto")
public class ProdutoController {

    @Autowired
    ProdutoRepository pdRepo;

    //metodos gets
    @GetMapping("/todos")
    public List buscaTodos(){
        return pdRepo.findAll();
    }

    @GetMapping("/buscacodigo/{codigo}")
    public Optional buscaCodigo(@PathVariable("codigo") int cod){
        return pdRepo.findById(cod);
    }

    @GetMapping("/buscadescricao/{descricao}")
    public List<Produto> buscaDescricao(@PathVariable("descricao") String descricao){
        return pdRepo.findByDescricao(descricao);
    }

    @GetMapping("/precomenor/{preco}")
    public List<Produto> precoMenor(@PathVariable("preco") int preco){
        return pdRepo.findByPrecoMenor(preco);
    }

    @GetMapping("/marca/{marca}")
    public List<Produto> buscarMarca(@PathVariable("marca") String marca){
        return pdRepo.findByMarca(marca);
    }

    @GetMapping("/marcaprecoinicial/{marca}/{preco}")
    public List<Produto> marcaPrecoInicial(@PathVariable("marca") String marca, @PathVariable("preco") int preco){
        return pdRepo.findByParteMarcaPrecoMenor(marca, preco);
    }

    @DeleteMapping("/removeproduto")
    public void removeProduto(@RequestBody Produto produto){
        pdRepo.delete(produto);
    }

    @DeleteMapping("/removeporcod/{codigo}")
    public void removePorCodigo(@PathVariable("codigo") int cod){
        pdRepo.deleteById(cod);
    }

    //metodos put
    @PutMapping("/atualizar")
    public void atualizarProduto(@RequestBody Produto produto){
        pdRepo.save(produto);
    }

    //metodo post
    @PostMapping("/inserirproduto")
    public void inserirProduto(@RequestBody Produto produto){
        pdRepo.save(produto);
    }
}
