package com.example.demo.apis.v1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.orm.Produto;
import com.example.demo.services.ProdutoServiceImpl;

@Controller
@RequestMapping("/produtos")
public class ProdutoConsultaController {

	@Autowired 
	@Qualifier("produtoServiceImpl")
	private ProdutoServiceImpl produtoService;


	@RequestMapping(value= "/inicial"  ,  method = RequestMethod.GET)
	public String listar(Model model) {

		model.addAttribute("produto", new Produto());
		model.addAttribute("produtos", produtoService.findAll());

		return "produtoLista";
	}

	@RequestMapping(value= "/pesquisa"  ,  method = RequestMethod.POST)
	public String acaoProdutos(@RequestParam String  id, @RequestParam String descricao,  Model model) {

		ArrayList<Produto> resultado = new ArrayList<Produto>();

		if (id != null && !id.isEmpty()) {

			Produto produto = null;

			try {
			produto = produtoService.findById(new Long(id));
			
			}catch (RuntimeException e) {
				
				
				if (!e.getMessage().equalsIgnoreCase("No value present")) {
					
					e.printStackTrace();
					
				}else {
					
					produto = null;
				}
				
			}

			resultado.add(produto);
		}

		if (descricao != null && !descricao.isEmpty()) {

			List<Produto> prod = 
					produtoService.findProdutosWithPartOfName(descricao);

			if (prod!= null && !prod.isEmpty()) {
				for (Iterator<Produto> iterator = prod.iterator(); iterator.hasNext();) {
					Produto produtos = (Produto) iterator.next();

					resultado.add(produtos);

				}

			}
		}


		if ( (id == null || id.isEmpty() ) & (descricao == null || descricao.isEmpty())) {

			model.addAttribute("produto", new Produto());
			model.addAttribute("produtos", produtoService.findAll());

			return "produtoLista";


		}

		model.addAttribute("produto", new Produto());
		model.addAttribute("produtos", resultado );

		return "produtoLista";

	}


}
