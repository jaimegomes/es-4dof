package br.senai.sc.es4dof.model;

import java.util.Date;

import br.senai.sc.es4dof.abstracts.Entidade;

/**
 * Classe abstrata Pessoa.
 * 
 * @author Jaime Gomes
 *
 */
public abstract class Pessoa extends Entidade {

	private int id;
	private String nome;
	private String telefone;
	private String cpf;
	private String endereco;
	private String email;
	private Date dataNascimento;
	private Usuario usuario;

	/**
	 * Construtor padr�o.
	 */
	public Pessoa() {
	}

	/**
	 * Construtor com todos os atributos menos o id.
	 * 
	 * @param nome
	 * @param telefone
	 * @param cpf
	 * @param endereco
	 * @param email
	 * @param dataNascimento
	 * @param usuario
	 */
	public Pessoa(String nome, String telefone, String cpf, String endereco,
			String email, Date dataNascimento, Usuario usuario) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.usuario = usuario;
	}

	/**
	 * Construtor com todos os atributos.
	 * 
	 * @param id
	 * @param nome
	 * @param telefone
	 * @param cpf
	 * @param endereco
	 * @param email
	 * @param dataNascimento
	 * @param usuario
	 */
	public Pessoa(int id, String nome, String telefone, String cpf,
			String endereco, String email, Date dataNascimento, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.usuario = usuario;
	}

	@Override
	public int getId() {

		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * M�todo que retorna o nome da Pessoa
	 * 
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M�todo que seta o nome da Pessoa
	 * 
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * M�todo que retorna o telefone da Pessoa
	 * 
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * 
	 * M�todo que seta o telefone da Pessoa
	 * 
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * M�todo que retorna o cpf da Pessoa
	 * 
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * M�todo que seta o cpf da Pessoa
	 * 
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * M�todo que retorna o endere�o da Pessoa
	 * 
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * M�todo que seta o endere�o da Pessoa
	 * 
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * M�todo que retorna o email da Pessoa
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * M�todo que seta o email da Pessoa
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * M�todo que retorna a data de nascimento da Pessoa
	 * 
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * M�todo que seta a data de nascimento da Pessoa
	 * 
	 * @param dataNascimento
	 *            the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * M�todo que retorna o usu�rio da Pessoa
	 * 
	 * @return the idUsuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * M�todo que seta o usu�rio da Pessoa
	 * 
	 * @param idUsuario
	 *            the idUsuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
