package br.mult.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.mult.model.Produto;
import br.mult.model.Usuario;
import br.mult.repository.ProdutoRepository;
import br.mult.repository.UsuarioRepository;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepo;
	
	@PostMapping(value = "/produtos")
	public List<Produto> getProdutos() {
		return produtoRepo.findAll();
	}
	
}
