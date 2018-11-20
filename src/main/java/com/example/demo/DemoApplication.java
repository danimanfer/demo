package com.example.demo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.demo.domain.orm.Produto;
import com.example.demo.services.ProdutoServiceImpl;

@SpringBootApplication
public class DemoApplication extends  SpringApplicationBuilder {

	
    @PostConstruct
    void started() {
      TimeZone.setDefault(TimeZone.getTimeZone("GMT-3:00"));
    }
	
	@Resource
	 ProdutoServiceImpl produtoService_0;
	
	
 
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	

	@PostConstruct
	public void loadData() {
		Produto products = new Produto("teste","42445",2500.00);
		produtoService_0.save(products);
		
		Produto products1 = new Produto("Samsung Smart TV 65'' LED ","21321",6200.00);
		produtoService_0.save(products1);
		
		Produto products2 = new Produto("Iphone 9 ","1111",5500.00);
		produtoService_0.save(products2);
	}
	
	
	
}
