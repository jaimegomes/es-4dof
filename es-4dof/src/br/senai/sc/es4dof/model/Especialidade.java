package br.senai.sc.es4dof.model;

import br.senai.sc.es4dof.abstracts.Entidade;

/**
 * Classe que representa a entidade Especialidade no banco de dados.
 * 
 * @author Jaime Gomes
 *
 */
public class Especialidade extends Entidade {

	private int id;
	private String nome;

	/**
	 * Construtor padrão
	 */
	public Especialidade() {

	}

	/**
	 * Construtor com todos os atributos menos o id;
	 * @param nome
	 */
	public Especialidade(String nome) {
		this.nome = nome;
	}

	/**
	 * Construtor com todos os atributos.
	 * @param id
	 * @param nome
	 */
	public Especialidade(int id, String nome) {
		this.id = id;
		this.nome = nome;
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
	 * Método que retorna o nome da Especialidade
	 * 
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que seta o nome da Especialidade.
	 * 
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
