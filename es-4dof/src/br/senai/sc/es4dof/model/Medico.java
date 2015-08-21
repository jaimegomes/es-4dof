package br.senai.sc.es4dof.model;

import java.util.Date;

/**
 * Classe que representa a entidade Medico no banco de dados.
 * 
 * @author Jaime Gomes
 *
 */
public class Medico extends Pessoa {

	private String crm;

	/**
	 * Construtor padrão.
	 */
	public Medico() {
	}

	/**
	 * Contrutor com todos os atributos menos o id.
	 * 
	 * @param nome
	 * @param telefone
	 * @param cpf
	 * @param endereco
	 * @param email
	 * @param dataNascimento
	 * @param usuario
	 * @param crm
	 */
	public Medico(String nome, String telefone, String cpf, String endereco,
			String email, Date dataNascimento, Usuario usuario, String crm) {
		super(nome, telefone, cpf, endereco, email, dataNascimento, usuario);
		this.crm = crm;
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
	 * @param crm
	 */
	public Medico(int id, String nome, String telefone, String cpf,
			String endereco, String email, Date dataNascimento,
			Usuario usuario, String crm) {
		super(id, nome, telefone, cpf, endereco, email, dataNascimento, usuario);
		this.crm = crm;
	}

	/**
	 * Método que retorna o crm.
	 * 
	 * @return the crm
	 */
	public String getCrm() {
		return crm;
	}

	/**
	 * Método que seta o crm
	 * 
	 * @param crm
	 *            the crm to set
	 */
	public void setCrm(String crm) {
		this.crm = crm;
	}

}
