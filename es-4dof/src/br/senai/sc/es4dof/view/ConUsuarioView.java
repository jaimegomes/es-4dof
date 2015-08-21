package br.senai.sc.es4dof.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import br.senai.sc.es4dof.abstracts.AConView;

@SuppressWarnings("rawtypes")
public class ConUsuarioView extends AConView {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtLogin;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JButton btnCancelar;
	private JButton btnInserir;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JPanel panel;
	private JCheckBox chckbxNome;
	private JCheckBox chckbxLogin;
	private JCheckBox chckbxCpf;
	private JCheckBox chckbxEmail;
	private JCheckBox chckbxPerfil;
	private JComboBox cmbPerfil;
	private JTextField txtNome;
	private JButton btnPesquisar;

	@SuppressWarnings("unchecked")
	public ConUsuarioView(JTable tableRefresh) {
		super(tableRefresh);

		setTitle("Consulta Usuário");

		// filtro de pesquisa
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Filtro de Pesquisa",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		chckbxNome = new JCheckBox("Nome");
		chckbxNome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chckbxNome.isSelected()) {
					txtNome.setEnabled(true);
					txtNome.setBackground(Color.white);
				} else {
					txtNome.setEnabled(false);
					txtNome.setBackground(Color.LIGHT_GRAY);
				}
			}
		});

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setEnabled(false);
		txtNome.setBackground(Color.LIGHT_GRAY);

		chckbxLogin = new JCheckBox("Login");
		chckbxLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chckbxLogin.isSelected()) {
					txtLogin.setEnabled(true);
					txtLogin.setBackground(Color.white);
				} else {
					txtLogin.setEnabled(false);
					txtLogin.setBackground(Color.LIGHT_GRAY);
				}
			}
		});

		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setEnabled(false);
		txtLogin.setBackground(Color.LIGHT_GRAY);

		chckbxCpf = new JCheckBox("CPF");
		chckbxCpf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chckbxCpf.isSelected()) {
					txtCpf.setEnabled(true);
					txtCpf.setBackground(Color.white);
				} else {
					txtCpf.setEnabled(false);
					txtCpf.setBackground(Color.LIGHT_GRAY);
				}
			}
		});

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setEnabled(false);
		txtCpf.setBackground(Color.LIGHT_GRAY);

		chckbxEmail = new JCheckBox("Email");
		chckbxEmail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chckbxEmail.isSelected()) {
					txtEmail.setEnabled(true);
					txtEmail.setBackground(Color.white);
				} else {
					txtEmail.setEnabled(false);
					txtEmail.setBackground(Color.LIGHT_GRAY);
				}
			}
		});

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setEnabled(false);
		txtEmail.setBackground(Color.LIGHT_GRAY);

		chckbxPerfil = new JCheckBox("Perfil");
		chckbxPerfil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chckbxPerfil.isSelected()) {
					cmbPerfil.setEnabled(true);
				} else {
					cmbPerfil.setEnabled(false);
				}
			}
		});

		cmbPerfil = new JComboBox();
		cmbPerfil.setModel(new DefaultComboBoxModel(new String[] { "",
				"M\u00E9dico", "Funcion\u00E1rio", "Paciente" }));
		cmbPerfil.setEnabled(false);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon("images/lupa_16x16.png"));
		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String perfil = cmbPerfil.getSelectedItem() + "";
				actionBtnPesquisar(txtCpf.getText(), txtEmail.getText(),
						txtLogin.getText(), txtNome.getText(), perfil);

			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("images/cancelar_16x16.png"));
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

		btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("images/editar_usuario_16x16.png"));
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnEditar();

			}
		});

		btnInserir = new JButton("Inserir");
		btnInserir.setIcon(new ImageIcon("images/add_usuario_16x16.png"));
		btnInserir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnInserir();

			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("images/excluir_usuario_16x16.png"));

		table = new JTable();

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(table, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnCancelar))
					.addContainerGap())
		);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxEmail)
						.addComponent(chckbxNome))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtNome)
						.addComponent(txtEmail, 154, 154, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxLogin)
						.addComponent(chckbxCpf))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtLogin)
						.addComponent(txtCpf))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxPerfil)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
						.addComponent(cmbPerfil, 0, 142, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxCpf)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbPerfil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxPerfil)
						.addComponent(chckbxNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEmail)
						.addComponent(chckbxLogin)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar)))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}

	private void actionBtnInserir() {
		try {
			CadUsuarioView cadUsuView = new CadUsuarioView(null, null);
			cadUsuView.requestFocus(true);
			cadUsuView.setFocusable(true);
			cadUsuView.moveToFront();
			PrincipalFuncionarioView.getInstancia().getContentPane()
					.add(cadUsuView, 0);
			cadUsuView.setVisible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void actionBtnEditar() {

	}

	public void actionBtnPesquisar(String cpf, String email, String login,
			String nome, String perfil) {

	}
}
