package br.mult.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.mult.model.Usuario;
import br.mult.repository.UsuarioRepository;

@RestController
public class LoginController {

	@Autowired
	private UsuarioRepository userRepo;
	
	@PostMapping(value = "/usuarios")
	public String cadastrarUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			String retorno = "";
			
			for (ObjectError e : result.getAllErrors()) {
				retorno += e.getDefaultMessage() + "\n ";
			}
			return retorno;
		}
			
			
		if(userRepo.findByNome(usuario.getNome()) != null)
			return "Usuário já cadastrado";
		
		userRepo.save(usuario);
		return "Usuário registrado com sucesso";
	}
	
}
