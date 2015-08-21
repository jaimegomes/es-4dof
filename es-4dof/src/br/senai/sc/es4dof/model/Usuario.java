package br.senai.sc.es4dof.model;

import br.senai.sc.es4dof.abstracts.Entidade;

/**
 * Classe que representa a entidade Usuario no banco de dados
 * 
 * @author Jaime Gomes
 *
 */
public class Usuario extends Entidade {

	private int id;
	private String login;
	private String senha;
	private String perfil;
	private Empresa empresa;

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
	public Usuario(String login, String senha, String perfil, Empresa empresa) {
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.empresa = empresa;
	}

	/**
	 * Construtor com todos os atributos.
	 * 
	 * @param id
	 * @param login
	 * @param senha
	 */
	public Usuario(int id, String login, String senha, String perfil) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
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
	 * Método que retorna o perfil de usuário.
	 * 
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * Método que seta o perfil de usuário
	 * 
	 * @param perfil
	 *            the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *            the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
