package br.senai.sc.es4dof.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.JXDatePicker;

import br.senai.sc.es4dof.abstracts.ACadView;
import br.senai.sc.es4dof.abstracts.Entidade;
import br.senai.sc.es4dof.controller.EmpresaController;
import br.senai.sc.es4dof.controller.FuncionarioController;
import br.senai.sc.es4dof.controller.MedicoController;
import br.senai.sc.es4dof.controller.PacienteController;
import br.senai.sc.es4dof.controller.UsuarioController;
import br.senai.sc.es4dof.model.Empresa;
import br.senai.sc.es4dof.model.Funcionario;
import br.senai.sc.es4dof.model.Medico;
import br.senai.sc.es4dof.model.Paciente;
import br.senai.sc.es4dof.model.Usuario;
import br.senai.sc.es4dof.utils.StringUtils;

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
	private JLabel lblPerfil;
	private JLabel lblCrm;
	private JLabel lblEspecialidade;
	private JLabel lblEmpresa;
	private JComboBox cmbEmpresa;
	private JComboBox cmbPerfil;
	private JComboBox cmbEspecialidade;
	private JXDatePicker datePicker;
	private JTextField txtCrm;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtCpf;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtConfirmarSenha;

	// botões
	private JButton btnCancelar;
	private JButton btnSalvar;
	private JButton btnLimpar;

	@SuppressWarnings("unchecked")
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
		btnCancelar.setIcon(new ImageIcon("images/cancelar_16x16.png"));
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("images/add_16x16.png"));
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String empresa = cmbEmpresa.getSelectedItem() + "";
					String perfil = cmbPerfil.getSelectedIndex() + "";

					if (txtSenha.getText().equals(txtConfirmarSenha.getText())) {

						actionBtnSalvar(
								txtCpf.getText(),
								txtCrm.getText(),
								StringUtils.getInstance().dateToString(
										datePicker.getDate()),
								txtEmail.getText(), txtEndereco.getText(),
								txtLogin.getText(), txtNome.getText(),
								txtSenha.getText(), txtTelefone.getText(),
								perfil, empresa);
					} else {

						txtSenha.setText("");
						txtConfirmarSenha.setText("");
						JOptionPane.showMessageDialog(null,
								"Senhas diferentes.");
					}
				} catch (Exception e1) {
					System.out
							.println("Erro ao executar o método actionBtnSalvar().");
					e1.printStackTrace();
				}

			}

		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon("images/borracha_16x16.png"));
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnLimpar();

			}
		});

		lblNome = new JLabel("Nome:");
		lblTelefone = new JLabel("Telefone:");
		lblCpf = new JLabel("CPF:");
		lblEndereco = new JLabel("Endere\u00E7o:");
		lblEmail = new JLabel("Email:");
		lblDataNascimento = new JLabel("Data Nascimento:");
		lblLogin = new JLabel("Login:");
		lblSenha = new JLabel("Senha:");
		lblConfirmarSenha = new JLabel("Confirmar Senha:");
		lblPerfil = new JLabel("Perfil:");

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

		txtLogin = new JTextField();
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);

		txtConfirmarSenha = new JTextField();
		txtConfirmarSenha.setColumns(10);

		txtCrm = new JTextField();
		txtCrm.setColumns(10);
		txtCrm.setVisible(false);

		datePicker = new JXDatePicker();

		cmbEspecialidade = new JComboBox();
		cmbEspecialidade.setVisible(false);

		cmbPerfil = new JComboBox();
		cmbPerfil
				.setToolTipText("Escolha o tipo de usu\u00E1rio que voc\u00EA deseja cadastrar.");
		cmbPerfil.setModel(new DefaultComboBoxModel(new String[] { "",
				"M\u00E9dico", "Funcion\u00E1rio", "Paciente" }));

		// quando for selecionado Médico no comboBox libera as opções de
		// preenchimento de CRM e Especialidade
		cmbPerfil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				actionCmbPerfil(cmbPerfil.getSelectedIndex());
			}

		});

		lblEmpresa = new JLabel("Empresa:");

		cmbEmpresa = new JComboBox();

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
																580,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnSalvar,
																				GroupLayout.PREFERRED_SIZE,
																				121,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnLimpar,
																				GroupLayout.PREFERRED_SIZE,
																				122,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnCancelar,
																				GroupLayout.PREFERRED_SIZE,
																				125,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnCancelar)
												.addComponent(btnLimpar)
												.addComponent(btnSalvar))
								.addContainerGap()));

		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblDataNascimento)
												.addComponent(lblNome)
												.addComponent(lblLogin)
												.addComponent(lblSenha)
												.addComponent(lblConfirmarSenha)
												.addComponent(lblTelefone)
												.addComponent(lblEndereco)
												.addComponent(lblCpf)
												.addComponent(lblEmail)
												.addComponent(lblPerfil))
								.addGap(3)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														txtEndereco,
														GroupLayout.DEFAULT_SIZE,
														520, Short.MAX_VALUE)
												.addComponent(
														txtNome,
														GroupLayout.DEFAULT_SIZE,
														520, Short.MAX_VALUE)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						gl_panel.createParallelGroup(
																								Alignment.TRAILING)
																								.addComponent(
																										cmbPerfil,
																										Alignment.LEADING,
																										0,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										txtConfirmarSenha,
																										Alignment.LEADING)
																								.addComponent(
																										txtTelefone,
																										Alignment.LEADING,
																										GroupLayout.DEFAULT_SIZE,
																										126,
																										Short.MAX_VALUE)
																								.addComponent(
																										txtLogin)
																								.addComponent(
																										txtSenha)
																								.addComponent(
																										txtCpf,
																										Alignment.LEADING,
																										GroupLayout.DEFAULT_SIZE,
																										144,
																										Short.MAX_VALUE))
																				.addComponent(
																						datePicker,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										lblEmpresa)
																								.addGap(42)
																								.addComponent(
																										cmbEmpresa,
																										0,
																										256,
																										Short.MAX_VALUE))
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addGroup(
																										gl_panel.createParallelGroup(
																												Alignment.LEADING)
																												.addComponent(
																														lblCrm)
																												.addComponent(
																														lblEspecialidade))
																								.addGap(5)
																								.addGroup(
																										gl_panel.createParallelGroup(
																												Alignment.LEADING)
																												.addGroup(
																														gl_panel.createSequentialGroup()
																																.addComponent(
																																		txtCrm,
																																		GroupLayout.PREFERRED_SIZE,
																																		96,
																																		GroupLayout.PREFERRED_SIZE)
																																.addGap(77))
																												.addComponent(
																														cmbEspecialidade,
																														0,
																														256,
																														Short.MAX_VALUE)))))
												.addComponent(
														txtEmail,
														GroupLayout.DEFAULT_SIZE,
														520, Short.MAX_VALUE))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNome)
												.addComponent(
														txtNome,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblEndereco)
												.addComponent(
														txtEndereco,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblEmail)
												.addComponent(
														txtEmail,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblTelefone)
												.addComponent(
														txtTelefone,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblEmpresa)
												.addComponent(
														cmbEmpresa,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblCpf)
												.addComponent(
														txtCpf,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblCrm)
												.addComponent(
														txtCrm,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblDataNascimento)
												.addComponent(lblEspecialidade)
												.addComponent(
														cmbEspecialidade,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														datePicker,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblLogin)
												.addComponent(
														txtLogin,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblSenha)
												.addComponent(
														txtSenha,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblConfirmarSenha)
												.addComponent(
														txtConfirmarSenha,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblPerfil)
												.addComponent(
														cmbPerfil,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * Método que contém a ação do botão salvar.
	 * 
	 * @param empresa2
	 * 
	 * @throws Exception
	 */
	private void actionBtnSalvar(String cpf, String crm, String dataNascimento,
			String email, String endereco, String login, String nome,
			String senha, String telefone, String perfil, String empresa)
			throws Exception {

		EmpresaController empController = new EmpresaController();
		UsuarioController usuController = new UsuarioController();

		Date dataNasc = StringUtils.getInstance().stringToDate(dataNascimento);

		Empresa emp = (Empresa) empController.getPorRazaoSocial(empresa);

		// cria um novo usuário
		Usuario usuario = new Usuario(txtLogin.getText(), txtSenha.getText(),
				perfil, emp);

		// salva o usuário
		usuController.salvar(usuario);

		// get no usuário salvo acima.
		Usuario usuarioSalvo = (Usuario) usuController.getPorLoginEmpresa(
				usuario.getLogin(), emp);

		// verifica o perfil do usuário para salvar a entidade correspondente
		switch (usuario.getPerfil()) {
		case "Médico":
			Medico medico = new Medico(nome, telefone, cpf, endereco, email,
					dataNasc, usuarioSalvo, crm);
			MedicoController medicoController = new MedicoController();
			medicoController.salvar(medico);
			break;

		case "Funcionário":
			Funcionario funcionario = new Funcionario(nome, telefone, cpf,
					endereco, email, dataNasc, usuarioSalvo);
			FuncionarioController funcionarioController = new FuncionarioController();
			funcionarioController.salvar(funcionario);
			break;

		case "Paciente":
			Paciente paciente = new Paciente(nome, telefone, cpf, endereco,
					email, dataNasc, usuarioSalvo);
			PacienteController pacienteController = new PacienteController();
			pacienteController.salvar(paciente);
			break;

		default:
			break;
		}
	}

	/**
	 * Método que contém a ação do botão limpar.
	 * 
	 * @throws Exception
	 */
	public void actionBtnLimpar() {

		txtConfirmarSenha.setText("");
		txtCpf.setText("");
		txtCrm.setText("");
		txtEmail.setText("");
		txtEndereco.setText("");
		txtLogin.setText("");
		txtNome.setText("");
		txtSenha.setText("");
		txtTelefone.setText("");
		cmbEspecialidade.setSelectedIndex(-1);
		cmbPerfil.setSelectedIndex(-1);
	}

	/**
	 * Método que contém a ação do comboBox perfil.
	 * 
	 * @throws Exception
	 */
	public void actionCmbPerfil(int index) {

		if (index == 1) {

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

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel
	 *            the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @return the groupLayout
	 */
	public GroupLayout getGroupLayout() {
		return groupLayout;
	}

	/**
	 * @param groupLayout
	 *            the groupLayout to set
	 */
	public void setGroupLayout(GroupLayout groupLayout) {
		this.groupLayout = groupLayout;
	}

	/**
	 * @return the gl_panel
	 */
	public GroupLayout getGl_panel() {
		return gl_panel;
	}

	/**
	 * @param gl_panel
	 *            the gl_panel to set
	 */
	public void setGl_panel(GroupLayout gl_panel) {
		this.gl_panel = gl_panel;
	}

	/**
	 * @return the lblNome
	 */
	public JLabel getLblNome() {
		return lblNome;
	}

	/**
	 * @param lblNome
	 *            the lblNome to set
	 */
	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	/**
	 * @return the lblTelefone
	 */
	public JLabel getLblTelefone() {
		return lblTelefone;
	}

	/**
	 * @param lblTelefone
	 *            the lblTelefone to set
	 */
	public void setLblTelefone(JLabel lblTelefone) {
		this.lblTelefone = lblTelefone;
	}

	/**
	 * @return the lblCpf
	 */
	public JLabel getLblCpf() {
		return lblCpf;
	}

	/**
	 * @param lblCpf
	 *            the lblCpf to set
	 */
	public void setLblCpf(JLabel lblCpf) {
		this.lblCpf = lblCpf;
	}

	/**
	 * @return the lblEndereco
	 */
	public JLabel getLblEndereco() {
		return lblEndereco;
	}

	/**
	 * @param lblEndereco
	 *            the lblEndereco to set
	 */
	public void setLblEndereco(JLabel lblEndereco) {
		this.lblEndereco = lblEndereco;
	}

	/**
	 * @return the lblEmail
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * @param lblEmail
	 *            the lblEmail to set
	 */
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	/**
	 * @return the lblDataNascimento
	 */
	public JLabel getLblDataNascimento() {
		return lblDataNascimento;
	}

	/**
	 * @param lblDataNascimento
	 *            the lblDataNascimento to set
	 */
	public void setLblDataNascimento(JLabel lblDataNascimento) {
		this.lblDataNascimento = lblDataNascimento;
	}

	/**
	 * @return the lblLogin
	 */
	public JLabel getLblLogin() {
		return lblLogin;
	}

	/**
	 * @param lblLogin
	 *            the lblLogin to set
	 */
	public void setLblLogin(JLabel lblLogin) {
		this.lblLogin = lblLogin;
	}

	/**
	 * @return the lblSenha
	 */
	public JLabel getLblSenha() {
		return lblSenha;
	}

	/**
	 * @param lblSenha
	 *            the lblSenha to set
	 */
	public void setLblSenha(JLabel lblSenha) {
		this.lblSenha = lblSenha;
	}

	/**
	 * @return the lblConfirmarSenha
	 */
	public JLabel getLblConfirmarSenha() {
		return lblConfirmarSenha;
	}

	/**
	 * @param lblConfirmarSenha
	 *            the lblConfirmarSenha to set
	 */
	public void setLblConfirmarSenha(JLabel lblConfirmarSenha) {
		this.lblConfirmarSenha = lblConfirmarSenha;
	}

	/**
	 * @return the lblPerfil
	 */
	public JLabel getlblPerfil() {
		return lblPerfil;
	}

	/**
	 * @param lblPerfil
	 *            the lblPerfil to set
	 */
	public void setlblPerfil(JLabel lblPerfil) {
		this.lblPerfil = lblPerfil;
	}

	/**
	 * @return the lblCrm
	 */
	public JLabel getLblCrm() {
		return lblCrm;
	}

	/**
	 * @param lblCrm
	 *            the lblCrm to set
	 */
	public void setLblCrm(JLabel lblCrm) {
		this.lblCrm = lblCrm;
	}

	/**
	 * @return the lblEspecialidade
	 */
	public JLabel getLblEspecialidade() {
		return lblEspecialidade;
	}

	/**
	 * @param lblEspecialidade
	 *            the lblEspecialidade to set
	 */
	public void setLblEspecialidade(JLabel lblEspecialidade) {
		this.lblEspecialidade = lblEspecialidade;
	}

	/**
	 * @return the cmbPerfil
	 */
	public JComboBox getCmbPerfil() {
		return cmbPerfil;
	}

	/**
	 * @param cmbPerfil
	 *            the cmbPerfil to set
	 */
	public void setCmbPerfil(JComboBox cmbPerfil) {
		this.cmbPerfil = cmbPerfil;
	}

	/**
	 * @return the cmbEspecialidade
	 */
	public JComboBox getCmbEspecialidade() {
		return cmbEspecialidade;
	}

	/**
	 * @param cmbEspecialidade
	 *            the cmbEspecialidade to set
	 */
	public void setCmbEspecialidade(JComboBox cmbEspecialidade) {
		this.cmbEspecialidade = cmbEspecialidade;
	}

	/**
	 * @return the txtCrm
	 */
	public JTextField getTxtCrm() {
		return txtCrm;
	}

	/**
	 * @param txtCrm
	 *            the txtCrm to set
	 */
	public void setTxtCrm(JTextField txtCrm) {
		this.txtCrm = txtCrm;
	}

	/**
	 * @return the txtNome
	 */
	public JTextField getTxtNome() {
		return txtNome;
	}

	/**
	 * @param txtNome
	 *            the txtNome to set
	 */
	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	/**
	 * @return the txtTelefone
	 */
	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	/**
	 * @param txtTelefone
	 *            the txtTelefone to set
	 */
	public void setTxtTelefone(JTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}

	/**
	 * @return the txtCpf
	 */
	public JTextField getTxtCpf() {
		return txtCpf;
	}

	/**
	 * @param txtCpf
	 *            the txtCpf to set
	 */
	public void setTxtCpf(JTextField txtCpf) {
		this.txtCpf = txtCpf;
	}

	/**
	 * @return the txtEndereco
	 */
	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	/**
	 * @param txtEndereco
	 *            the txtEndereco to set
	 */
	public void setTxtEndereco(JTextField txtEndereco) {
		this.txtEndereco = txtEndereco;
	}

	/**
	 * @return the txtEmail
	 */
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	/**
	 * @param txtEmail
	 *            the txtEmail to set
	 */
	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	/**
	 * @return the lblPerfil
	 */
	public JLabel getLblPerfil() {
		return lblPerfil;
	}

	/**
	 * @param lblPerfil
	 *            the lblPerfil to set
	 */
	public void setLblPerfil(JLabel lblPerfil) {
		this.lblPerfil = lblPerfil;
	}

	/**
	 * @return the lblEmpresa
	 */
	public JLabel getLblEmpresa() {
		return lblEmpresa;
	}

	/**
	 * @param lblEmpresa
	 *            the lblEmpresa to set
	 */
	public void setLblEmpresa(JLabel lblEmpresa) {
		this.lblEmpresa = lblEmpresa;
	}

	/**
	 * @return the cmbEmpresa
	 */
	public JComboBox getCmbEmpresa() {
		return cmbEmpresa;
	}

	/**
	 * @param cmbEmpresa
	 *            the cmbEmpresa to set
	 */
	public void setCmbEmpresa(JComboBox cmbEmpresa) {
		this.cmbEmpresa = cmbEmpresa;
	}

	/**
	 * @return the datePicker
	 */
	public JXDatePicker getDatePicker() {
		return datePicker;
	}

	/**
	 * @param datePicker
	 *            the datePicker to set
	 */
	public void setDatePicker(JXDatePicker datePicker) {
		this.datePicker = datePicker;
	}

	/**
	 * @return the txtLogin
	 */
	public JTextField getTxtLogin() {
		return txtLogin;
	}

	/**
	 * @param txtLogin
	 *            the txtLogin to set
	 */
	public void setTxtLogin(JTextField txtLogin) {
		this.txtLogin = txtLogin;
	}

	/**
	 * @return the txtSenha
	 */
	public JTextField getTxtSenha() {
		return txtSenha;
	}

	/**
	 * @param txtSenha
	 *            the txtSenha to set
	 */
	public void setTxtSenha(JTextField txtSenha) {
		this.txtSenha = txtSenha;
	}

	/**
	 * @return the txtConfirmarSenha
	 */
	public JTextField getTxtConfirmarSenha() {
		return txtConfirmarSenha;
	}

	/**
	 * @param txtConfirmarSenha
	 *            the txtConfirmarSenha to set
	 */
	public void setTxtConfirmarSenha(JTextField txtConfirmarSenha) {
		this.txtConfirmarSenha = txtConfirmarSenha;
	}

	/**
	 * @return the btnCancelar
	 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	/**
	 * @param btnCancelar
	 *            the btnCancelar to set
	 */
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	/**
	 * @return the btnSalvar
	 */
	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	/**
	 * @param btnSalvar
	 *            the btnSalvar to set
	 */
	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	/**
	 * @return the btnLimpar
	 */
	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	/**
	 * @param btnLimpar
	 *            the btnLimpar to set
	 */
	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}
}
