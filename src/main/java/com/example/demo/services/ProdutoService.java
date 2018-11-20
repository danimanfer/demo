package com.example.demo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.domain.orm.Produto;

public interface ProdutoService {
	
	Iterable<Produto> findAll();

	Produto save(Produto produto);

	Produto findById(Long id);
	
	

	List<Produto> findProdutosWithPartOfName(@Param("descricao") String descricao);

}
