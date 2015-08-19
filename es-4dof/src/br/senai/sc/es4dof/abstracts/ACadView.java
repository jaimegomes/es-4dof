package br.senai.sc.es4dof.abstracts;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

/**
 * Classe abstrata com configurações de janela pré definidas, utilizada nas
 * views de cadastro
 * 
 * @author Jaime Gomes
 *
 */
public abstract class ACadView extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padrão da classe.
	 * 
	 * @param Entidade
	 *            entidade (quando a entidade for diferente de nula, significa
	 *            que é uma edição de cadastro)
	 * @param JTable
	 *            table (tabela que será atualizada quando o cadastro for
	 *            concluído)
	 */
	public ACadView(Entidade entidade, JTable table) {
		// adiciona botão de fechar na janela
		setClosable(true);
		// especifica o tamanho da tela
		setBounds(15, 0, 614, 385);

	}

}
