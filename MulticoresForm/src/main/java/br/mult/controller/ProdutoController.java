package br.mult.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(value = "/produtos/cadastro")
	public String cadastrarProduto(@Valid @RequestBody Produto produto, BindingResult result) {
		if(result.hasErrors()) {
			String retorno = "";
			
			for (ObjectError e : result.getAllErrors()) {
				retorno += e.getDefaultMessage() + "\n ";
			}
			return retorno;
		}
			
		if(produtoRepo.findByNome(produto.getNome()) != null)
			return "Produto já cadastrado";
		
		produtoRepo.save(produto);
		return "Produto registrado com sucesso";
	}
}
