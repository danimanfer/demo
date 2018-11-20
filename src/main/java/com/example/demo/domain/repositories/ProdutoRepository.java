package com.example.demo.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.orm.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query(" FROM produto u WHERE u.descricao LIKE CONCAT('%',:descricao,'%')")
	List<Produto> findProdutosWithPartOfName(@Param("descricao") String descricao);
}
