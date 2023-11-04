package com.Projeto.Loja.Repository;

import com.Projeto.Loja.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository <Cliente, Integer>{

    @Query("select c from Cliente c where c.nome like %?1%")
    List<Cliente> findByParteNome(String nome);

    @Query("select c from Cliente c where c.email = ?1")
    List<Cliente> findByEmail(String email);

    @Query("select c from Cliente c where c.nome like %?1% or c.email like %?2%")
    List<Cliente> findByNomeEmail(String nome, String email);
}
