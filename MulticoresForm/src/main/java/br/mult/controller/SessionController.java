	package br.mult.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mult.model.Usuario;
import br.mult.repository.UsuarioRepository;

@RestController
public class SessionController {
	
	@Autowired
	private UsuarioRepository userRepo;

	@PostMapping(value = "/getUserLogado")
	public Usuario getSession(HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			
			Usuario temp = userRepo.findOne(((Usuario) session.getAttribute("usuarioLogado")).getId());
			
			return temp;
			
		}
		
		return null;
	}
	
}
