package com.example.demo.apis.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.orm.Produto;
import com.example.demo.services.ProdutoServiceImpl;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoApiRestController {
	
	
	@Autowired 
	private JmsTemplate jmsTemplate;

	@Autowired @Qualifier("produtoServiceImpl")
	private ProdutoServiceImpl produtoService;

// Envia 
	@GetMapping(produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Iterable <Produto> findAll() {

		Iterable <Produto> array =	this.produtoService.findAll();

		return array;
	}


	@RequestMapping (method =  RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String save( @RequestBody  Produto  produto) {

		Produto prod = null;

		prod = this.produtoService.save(produto);
		
//		TODO Envia via JMS
//		jmsTemplate.convertAndSend("queue.sample", prod);

		return  "OK" ;
	}


}
