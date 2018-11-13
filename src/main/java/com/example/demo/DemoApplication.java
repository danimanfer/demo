package com.example.demo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.orm.Produto;
import com.example.demo.services.ProdutoServiceImpl;

@SpringBootApplication
public class DemoApplication {

	
    @PostConstruct
    void started() {
      TimeZone.setDefault(TimeZone.getTimeZone("GMT-3:00"));
    }
	
	@Resource
	 ProdutoServiceImpl produtoService_0;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
		
	}
	
	

	@PostConstruct
	public void loadData() {
		Produto products = new Produto("teste","42445",2500.00);
		produtoService_0.save(products);
	}
}
