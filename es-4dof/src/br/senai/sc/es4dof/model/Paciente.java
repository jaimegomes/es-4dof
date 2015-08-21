package br.senai.sc.es4dof.model;

import java.util.Date;

/**
 * Classe que representa a entidade Paciente no banco de dados.
 * 
 * @author Jaime Gomes
 *
 */
public class Paciente extends Pessoa {

	/**
	 * Contrutor padrão
	 */
	public Paciente() {
	}

	/**
	 * Contrutor com todos os atributos.
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
	public Paciente(int id, String nome, String telefone, String cpf,
			String endereco, String email, Date dataNascimento, Usuario usuario) {
		super(id, nome, telefone, cpf, endereco, email, dataNascimento, usuario);
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
	 */
	public Paciente(String nome, String telefone, String cpf, String endereco,
			String email, Date dataNascimento, Usuario usuario) {
		super(nome, telefone, cpf, endereco, email, dataNascimento, usuario);
	}

}
