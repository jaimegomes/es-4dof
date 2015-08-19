package br.senai.sc.es4dof.abstracts;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

/**
 * Classe abstrata com configura��es de janela pr� definidas, utilizada nas
 * views de cadastro
 * 
 * @author Jaime Gomes
 *
 */
public abstract class ACadView extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padr�o da classe.
	 * 
	 * @param Entidade
	 *            entidade (quando a entidade for diferente de nula, significa
	 *            que � uma edi��o de cadastro)
	 * @param JTable
	 *            table (tabela que ser� atualizada quando o cadastro for
	 *            conclu�do)
	 */
	public ACadView(Entidade entidade, JTable table) {
		// adiciona bot�o de fechar na janela
		setClosable(true);
		// especifica o tamanho da tela
		setBounds(15, 0, 614, 385);

	}

}
