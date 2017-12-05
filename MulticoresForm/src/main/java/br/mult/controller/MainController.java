package br.mult.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
	@GetMapping("/cadastro")
	public String mostraCadastro() {
		return "cadastro";
	}
	
	@GetMapping("/usuarios/{id}/update")
	public String editarPerfil() {
		return "editar-perfil";
	}
	
	@GetMapping("/login")
	public String mostraLogin() {
		return "login";
	}
	
	@GetMapping("/produtos")
	public String listarProdutos() {
		return "produto";
	}
	
	@GetMapping("/produtosAdmin")
	public String listarProdutosAdmin() {
		return "produtoAdmin";
	}
	@GetMapping("/cadastrarProduto")
	public String cadastrarProduto() {
		return "cadastrarProduto";
	}
	
	@RequestMapping (value = "/produtos/{id}/update")
	public String updateProduto(@PathVariable long id) {
		return "editar-produto";
		
	}
}
