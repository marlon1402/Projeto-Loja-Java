package com.Projeto.Loja.Repository;

import com.Projeto.Loja.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Integer>{

    @Query("select p from Produto p where p.descricao like %?1%")
    List<Produto> findByDescricao(String descricao);

    @Query("select p from Produto p where p.preco < ?1")
    List<Produto> findByPrecoMenor(int preco);

    @Query("select p from Produto p where p.marca like %?1%")
    List<Produto> findByMarca(String marca);

    @Query("select p from Produto p where p.marca like %?1% or p.preco < ?2")
    List<Produto> findByParteMarcaPrecoMenor(String marca, int preco);
}
