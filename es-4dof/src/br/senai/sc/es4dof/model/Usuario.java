package br.senai.sc.es4dof.model;

import br.senai.sc.es4dof.abstracts.Entidade;

public class Usuario extends Entidade {

	private int id;
	private String login;
	private String senha;
	private String tipo;

	/**
	 * Construtor padrão
	 */
	public Usuario() {
	}

	/**
	 * Construtor com todos os atributos menos o id.
	 * 
	 * @param login
	 * @param senha
	 */
	public Usuario(String login, String senha, String tipo) {
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}

	/**
	 * Construtor com todos os atributos.
	 * 
	 * @param id
	 * @param login
	 * @param senha
	 */
	public Usuario(int id, String login, String senha, String tipo) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
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
	 * Método que retorna o login do usuário.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Método que seta o login do usuário.
	 * 
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Método que retorna a senha do usuário.
	 * 
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Método que seta a senha do usuário.
	 * 
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Método que retorna o tipo de usuário.
	 * 
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Método que seta o tipo de usuário
	 * 
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
