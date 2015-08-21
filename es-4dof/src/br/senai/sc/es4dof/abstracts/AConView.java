package br.senai.sc.es4dof.abstracts;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

public class AConView extends JInternalFrame {

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
	public AConView(JTable table) {
		// adiciona bot�o de fechar na janela
		setClosable(true);
		// especifica o tamanho da tela
		setBounds(15, 0, 708, 385);

	}


}
