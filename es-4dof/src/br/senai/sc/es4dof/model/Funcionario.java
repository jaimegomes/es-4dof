package br.senai.sc.es4dof.model;

import java.util.Date;

/**
 * Classe que representa a entidade Funcionario no banco de dados.
 * 
 * @author Jaime Gomes
 *
 */
public class Funcionario extends Pessoa {
	
	/**
	 * Construtor padrão
	 */
	public Funcionario() {
	}

	/**
	 * Construtor com todos os atributos.
	 * @param id
	 * @param nome
	 * @param telefone
	 * @param cpf
	 * @param endereco
	 * @param email
	 * @param dataNascimento
	 * @param usuario
	 */
	public Funcionario(int id, String nome, String telefone, String cpf,
			String endereco, String email, Date dataNascimento, Usuario usuario) {
		super(id, nome, telefone, cpf, endereco, email, dataNascimento, usuario);
	}

	/**
	 * Construtor com todos os atributos menos o id.
	 * @param nome
	 * @param telefone
	 * @param cpf
	 * @param endereco
	 * @param email
	 * @param dataNascimento
	 * @param usuario
	 */
	public Funcionario(String nome, String telefone, String cpf,
			String endereco, String email, Date dataNascimento, Usuario usuario) {
		super(nome, telefone, cpf, endereco, email, dataNascimento, usuario);
	}

	
}
