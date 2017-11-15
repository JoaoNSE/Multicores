package br.mult.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=3, max=20, message="O tamanho do nome deve ser entre {min} e {max}")
	private String nome;
	
	@NotNull
	@Size(min=3, max=20, message="O tamanho do sobrenome deve ser entre {min} e {max}")
	private String sobrenome;
	
	@NotNull
	@Size(min=5, max=60, message="O tamanho do email deve ser entre {min} e {max}")
	private String email;
	
	@NotNull
	@Size(min=5, max=60, message="O tamanho da senha deve ser entre {min} e {max}")
	private String senha;
	
	@NotNull
	@Size(min=11, max=14, message="O cpf é inválido")
	private String cpf;
	
	@NotNull
	@Size(min=5, max=60, message="O tamanho do endereço deve ser entre {min} e {max}")
	private String endereco;
	
	@NotNull
	@Size(min=5, max=60, message="O tamanho do nome do pai deve ser entre {min} e {max}")
	private String nomePai;
	
	@NotNull
	@Size(min=5, max=60, message="O tamanho do nome da mãe deve ser entre {min} e {max}")
	private String nomeMae;
	
	@NotNull
	@Size(min=5, max=60, message="O tamanho do nome da instituição de ensino deve ser entre {min} e {max}")
	private String instituicaoEnsino;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull(message = "Uma data de nascimento deve ser inserida.")
	private Date validade;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nome, String sobrenome, String email, String senha, String cpf, String nomePai,
			String nomeMae, String instituicaoEnsino, Date validade, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.instituicaoEnsino = instituicaoEnsino;
		this.validade = validade;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
