package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.orm.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

 
}
