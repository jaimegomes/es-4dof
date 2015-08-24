package br.senai.sc.es4dof.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.senai.sc.es4dof.controller.UsuarioController;
import br.senai.sc.es4dof.model.Empresa;
import br.senai.sc.es4dof.model.Usuario;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblBemVindo;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JButton btnOk;
	private JComboBox cmbEmpresa;
	private JLabel lblEmpresa;
	private JLabel lblBackground;

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

		lblEmpresa = new javax.swing.JLabel();
		cmbEmpresa = new javax.swing.JComboBox();
		lblUsuario = new javax.swing.JLabel();
		txtUsuario = new javax.swing.JTextField();
		lblSenha = new javax.swing.JLabel();
		txtSenha = new javax.swing.JPasswordField();
		btnOk = new javax.swing.JButton();
		lblBackground = new javax.swing.JLabel();

		setForeground(Color.BLUE);
		setTitle("::ES-4DoF:: Enterprise System - 4 Do Fast");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 622);
		setResizable(false);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblEmpresa.setText("Empresa:");
		getContentPane().add(lblEmpresa);
		lblEmpresa.setBounds(450, 430, 70, 15);

		cmbEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		getContentPane().add(cmbEmpresa);
		cmbEmpresa.setBounds(530, 420, 140, 24);

		lblUsuario.setText("Usuário:");
		getContentPane().add(lblUsuario);
		lblUsuario.setBounds(450, 457, 70, 15);
		getContentPane().add(txtUsuario);
		txtUsuario.setBounds(530, 455, 140, 19);

		lblSenha.setText("Senha:");
		getContentPane().add(lblSenha);
		lblSenha.setBounds(450, 485, 50, 15);
		getContentPane().add(txtSenha);
		txtSenha.setBounds(530, 483, 140, 19);

		btnOk.setText("OK");
		getContentPane().add(btnOk);
		btnOk.setBounds(682, 483, 88, 19);
		btnOk.setIcon(new ImageIcon("images/ok_16x16.png"));
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnOk(txtUsuario.getText(), txtSenha.getText(),
						(Empresa) cmbEmpresa.getSelectedItem());

			}
		});

		lblBackground.setIcon(new javax.swing.ImageIcon(
				"/home/jaime/Área de Trabalho/background.png")); // NOI18N
		getContentPane().add(lblBackground);
		lblBackground.setBounds(0, 0, 1200, 622);

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
