package br.senai.sc.es4dof.abstracts;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

public class AConView extends JInternalFrame {

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
	public AConView(JTable table) {
		// adiciona botão de fechar na janela
		setClosable(true);
		// especifica o tamanho da tela
		setBounds(15, 0, 708, 385);

	}


}
