package br.senai.sc.es4dof.model;

import br.senai.sc.es4dof.abstracts.Entidade;

public class Usuario extends Entidade {

	private int id;
	private String login;
	private String senha;
	private String tipo;

	/**
	 * Construtor padr�o
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
	 * M�todo que retorna o login do usu�rio.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * M�todo que seta o login do usu�rio.
	 * 
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * M�todo que retorna a senha do usu�rio.
	 * 
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * M�todo que seta a senha do usu�rio.
	 * 
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * M�todo que retorna o tipo de usu�rio.
	 * 
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * M�todo que seta o tipo de usu�rio
	 * 
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
