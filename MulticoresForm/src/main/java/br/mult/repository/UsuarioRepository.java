package br.mult.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mult.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByNome(String nome);
	
	public Usuario findByCpf(String cpf);
	
	public List<Usuario> findByEmailAndSenha(String email, String senha);
	
	public Usuario findByEmail(String email);
	
}
