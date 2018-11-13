package com.example.demo.services;

import com.example.demo.domain.orm.Produto;

public interface ProdutoService {
	
	Iterable<Produto> findAll();

	Produto save(Produto produto);

}
