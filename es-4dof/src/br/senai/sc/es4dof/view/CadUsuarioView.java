package br.senai.sc.es4dof.view;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.senai.sc.es4dof.abstracts.ACadView;
import br.senai.sc.es4dof.abstracts.Entidade;

/**
 * Classe responsável por desenhar a tela de cadastro de Funcionários
 * 
 * @author Jaime Gomes
 */
@SuppressWarnings("rawtypes")
public class CadUsuarioView extends ACadView {

	private static final long serialVersionUID = 1L;

	// estrutura da janela
	private JPanel panel;
	private GroupLayout groupLayout;
	private GroupLayout gl_panel;

	// campos do formulário
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblCpf;
	private JLabel lblEndereco;
	private JLabel lblEmail;
	private JLabel lblDataNascimento;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblConfirmarSenha;
	private JLabel lblTipo;
	private JLabel lblCrm;
	private JLabel lblEspecialidade;
	private JComboBox cmbTipo;
	private JComboBox cmbEspecialidade;
	private JTextField txtCrm;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtCpf;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtDataNascimento;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtConfirmarSenha;

	// botões
	private JButton btnCancelar;
	private JButton btnSalvar;
	private JButton btnLimpar;

	@SuppressWarnings({ "deprecation", "unchecked" })
	public CadUsuarioView(Entidade entidade, JTable table) {
		super(entidade, table);
		// título da janela
		setTitle("Cadastro Usuário");

		// instanciando o panel
		panel = new JPanel();

		// set configuração da borda
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "Cadastro Usuário", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnSalvar = new JButton("Salvar");
		btnLimpar = new JButton("Limpar");

		lblNome = new JLabel("Nome:");
		lblTelefone = new JLabel("Telefone:");
		lblCpf = new JLabel("CPF:");
		lblEndereco = new JLabel("Endere\u00E7o:");
		lblEmail = new JLabel("Email:");
		lblDataNascimento = new JLabel("Data Nascimento:");
		lblLogin = new JLabel("Login:");
		lblSenha = new JLabel("Senha:");
		lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblTipo = new JLabel("Tipo:");

		lblCrm = new JLabel("CRM:");
		lblCrm.setVisible(false);

		lblEspecialidade = new JLabel("Especialidade:");
		lblEspecialidade.setVisible(false);

		txtNome = new JTextField();
		txtNome.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);

		txtLogin = new JTextField();
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);

		txtConfirmarSenha = new JTextField();
		txtConfirmarSenha.setColumns(10);

		txtCrm = new JTextField();
		txtCrm.setColumns(10);
		txtCrm.setVisible(false);
		
		cmbEspecialidade = new JComboBox();
		cmbEspecialidade.setVisible(false);

		cmbTipo = new JComboBox();
		cmbTipo.setToolTipText("Escolha o tipo de usu\u00E1rio que voc\u00EA deseja cadastrar.");
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] { "",
				"M\u00E9dico", "Funcion\u00E1rio", "Paciente" }));

		// quando for selecionado Médico no comboBox libera as opção de
		// preenchimento de CRM e Especialidade
		cmbTipo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cmbTipo.getSelectedIndex() == 1) {

					lblCrm.setVisible(true);
					txtCrm.setVisible(true);

					lblEspecialidade.setVisible(true);
					cmbEspecialidade.setVisible(true);
				} else {
					lblCrm.setVisible(false);
					txtCrm.setVisible(false);

					lblEspecialidade.setVisible(false);
					cmbEspecialidade.setVisible(false);
				}
			}

		});
		

		groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																panel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnSalvar,
																				GroupLayout.PREFERRED_SIZE,
																				96,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				btnLimpar,
																				GroupLayout.PREFERRED_SIZE,
																				97,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				btnCancelar)))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE,
										284, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnLimpar)
												.addComponent(btnCancelar)
												.addComponent(btnSalvar))
								.addContainerGap()));
		

		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataNascimento)
						.addComponent(lblNome)
						.addComponent(lblLogin)
						.addComponent(lblSenha)
						.addComponent(lblConfirmarSenha)
						.addComponent(lblTelefone)
						.addComponent(lblEndereco)
						.addComponent(lblCpf)
						.addComponent(lblEmail)
						.addComponent(lblTipo))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEndereco, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(cmbTipo, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtConfirmarSenha, Alignment.LEADING)
								.addComponent(txtDataNascimento, Alignment.LEADING)
								.addComponent(txtCpf, Alignment.LEADING)
								.addComponent(txtTelefone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(txtLogin)
								.addComponent(txtSenha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCrm)
								.addComponent(lblEspecialidade))
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cmbEspecialidade, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtCrm, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereco)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataNascimento)
						.addComponent(txtDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmarSenha)
						.addComponent(txtConfirmarSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCrm)
						.addComponent(txtCrm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(cmbTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEspecialidade)
						.addComponent(cmbEspecialidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
