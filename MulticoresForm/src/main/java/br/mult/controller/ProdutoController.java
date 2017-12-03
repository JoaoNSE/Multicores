package br.mult.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
