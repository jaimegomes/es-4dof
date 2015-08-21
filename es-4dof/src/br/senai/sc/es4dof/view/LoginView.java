package br.senai.sc.es4dof.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.senai.sc.es4dof.controller.UsuarioController;
import br.senai.sc.es4dof.model.Empresa;
import br.senai.sc.es4dof.model.Usuario;
import javax.swing.JEditorPane;
import java.awt.Component;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblBemVindo;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JButton btnOk;
	private GroupLayout groupLayout;
	private GroupLayout gl_panel;
	private JLabel lblEsdof;
	private JComboBox cmbEmpresa;
	private JLabel lblEmpresa;
	private JLabel background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() throws Exception {

		setBounds(500, 200, 400, 300);
		setForeground(Color.BLUE);
		setTitle("::ES-4DoF:: Enterprise System - 4 Do Fast");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		panel = new JPanel();

		lblBemVindo = new JLabel("Bem Vindo ao Sistema");
		lblBemVindo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);

		lblEsdof = new JLabel("ES-4DoF");
		lblEsdof.setFont(new Font("Dialog", Font.BOLD, 14));

		cmbEmpresa = new JComboBox();

		lblEmpresa = new JLabel("Empresa:");

		lblUsuario = new JLabel("Usu\u00E1rio:");

		lblSenha = new JLabel("Senha:");

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);

		btnOk = new JButton("OK");
		btnOk.setIcon(new ImageIcon("images/ok_16x16.png"));
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				Empresa empresa = (Empresa) cmbEmpresa.getSelectedItem();

				actionBtnOk(txtUsuario.getText(), txtSenha.getText(), empresa);

			}
		});

		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE));
		
		background = new JLabel();
		background.setHorizontalAlignment(SwingConstants.CENTER);
//		background.setIcon(new ImageIcon("images/background_estetoscopio.jpg"));

		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addComponent(lblBemVindo)
					.addGap(112))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(159)
					.addComponent(lblEsdof)
					.addContainerGap(170, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addComponent(lblUsuario))
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEmpresa)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbEmpresa, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOk)))
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(background)
					.addContainerGap(394, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(background)
					.addGap(27)
					.addComponent(lblBemVindo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEsdof)
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmpresa))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * Método que executa a ação do botão ok.
	 * 
	 * @param text
	 */
	private void actionBtnOk(String login, String senha, Empresa empresa) {
		UsuarioController controller = new UsuarioController();

		try {
			Usuario usuario = (Usuario) controller.getPorLoginEmpresa(login,
					empresa);

			if (usuario != null) {
				if (usuario.getSenha().equals(txtSenha.getText())) {

					dispose();

					switch (usuario.getPerfil()) {
					case "Médico":
						PrincipalMedicoView principalMedico = new PrincipalMedicoView();
						principalMedico.setVisible(true);
						break;

					case "Funcionário":
						PrincipalFuncionarioView principalFuncionario = new PrincipalFuncionarioView();
						principalFuncionario.setVisible(true);
						break;

					case "Paciente":
						PrincipalPacienteView principalPaciente = new PrincipalPacienteView();
						principalPaciente.setVisible(true);
						break;

					default:
						break;
					}

				} else {

					JOptionPane.showMessageDialog(null, "Senha inválida.");
					txtSenha.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Dados inválidos.");
				txtSenha.setText("");
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
