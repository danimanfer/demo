package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.orm.Produto;
import com.example.demo.domain.repositories.ProdutoRepository;

@Service("produtoServiceImpl")
public class ProdutoServiceImpl implements ProdutoService {
 
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Iterable<Produto> findAll() {
		return this.produtoRepository.findAll();
	}

	@Override
	public Produto save(Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	@Override
	public Produto findById(Long id) {
		
		return this.produtoRepository.findById(id).get();
	}

	@Override
	public List<Produto> findProdutosWithPartOfName(String descricao) {
		return this.produtoRepository.findProdutosWithPartOfName(descricao);
	}

}
 

