package br.mult.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mult.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public Produto findByNome(String nome);
}
