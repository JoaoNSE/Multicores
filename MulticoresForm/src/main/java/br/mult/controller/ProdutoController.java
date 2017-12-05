package br.mult.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mult.model.Produto;
import br.mult.repository.ProdutoRepository;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepo;
	
	@PostMapping(value = "/produtos")
	public List<Produto> getProdutos() {
		return produtoRepo.findAll();
	}
	
	
	@PostMapping(value = "/produtos/{id}/remover")
	public String removerProduto(@PathVariable long id) {
		
		Produto temp = produtoRepo.findOne(id);
		produtoRepo.delete(temp);
		return "redirect:/produtos";
	}
	
	@PostMapping(value = "/produtos/cadastrar")
	public String cadastrarProduto(@Valid @RequestBody Produto produto, BindingResult result) {
		if(result.hasErrors()) {
			String retorno = "";
			
			for (ObjectError e : result.getAllErrors()) {
				retorno += e.getDefaultMessage() + "\n ";
			}
			return retorno;
		}
		produtoRepo.save(produto);
		return "redirect:/produtosAdmin";
		
	}
	
	/*
	@PostMapping (value = "/produtos/{id}/update")
	public String update(@PathVariable long id) {
		
		return "editar-produto";
	}*/
	
	@PostMapping (value="/getProdutoSelecionado/{id}")
	public Produto getProdutoSelecionado(@PathVariable long id) {
		return produtoRepo.findOne(id);
		
	}
}
