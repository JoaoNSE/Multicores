package br.mult.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mult.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByNome(String nome);
	
	public List<Usuario> findByNomeAndSenha(String nome, String senha);
	
}
