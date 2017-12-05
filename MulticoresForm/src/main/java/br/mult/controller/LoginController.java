package br.mult.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
			
		if (usuario.getId() != null) {
			Usuario older = userRepo.findOne(usuario.getId());
			System.out.println("UPDATE");
			if (!older.getEmail().equals(usuario.getEmail()) && userRepo.findByEmail(usuario.getEmail()) != null) {
				System.out.println("Older" + older.getEmail());
				System.out.println("Newer" + usuario.getEmail());
				return "Email já cadastrado";
			}
			userRepo.save(usuario);
			return "Perfil alterado";
		} else if(userRepo.findByEmail(usuario.getEmail()) != null) {
			return "Email já cadastrado";
		}
		
		userRepo.save(usuario);
		return "redirect";
	}
	
	@PostMapping(value = "/login")
	public String efetuaLogin(@RequestBody Usuario usuario, HttpSession session) {
			
		if (usuario.getEmail().equals("") || usuario.getEmail() == null) {
			return "Usuário inválido";
		}
		
		ArrayList<Usuario> users = (ArrayList<Usuario>) userRepo.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
		if(users == null || users.size() == 0) {
			return "Usuário inválido";
		}
		
		if (users.size() == 1 ) {
			usuario.setId(users.get(0).getId());
			if (usuario.getId() == 1) {
				session.setAttribute("adm", usuario);
			}
			else {
				session.setAttribute("adm", null);
			}
			session.setAttribute("usuarioLogado", usuario);
		    return "redirect:/";
		}
		return "Bem vindo";
	}
	
	@RequestMapping(value = "/logout")
	public void efetuaLogout(HttpSession session, HttpServletResponse response) {
		if (session.getAttribute("usuarioLogado") != null) {
			session.removeAttribute("usuarioLogado");
			
		}
		if (session.getAttribute("adm") != null) {
			session.removeAttribute("adm");
			
		}
		
		
		
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
