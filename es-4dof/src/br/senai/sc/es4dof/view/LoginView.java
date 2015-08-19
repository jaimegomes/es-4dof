package br.senai.sc.es4dof.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.senai.sc.es4dof.dao.UsuarioDAO;
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
	private GroupLayout groupLayout;
	private GroupLayout gl_panel;
	private JLabel lblEsdof;

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

		setBounds(300, 300, 400, 300);
		setForeground(Color.BLUE);
		setTitle("::ES-4DoF:: Enterprise System - 4 Do Fast");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();

		lblBemVindo = new JLabel("Bem Vindo ao Sistema");
		lblBemVindo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);

		lblEsdof = new JLabel("ES-4DoF");
		lblEsdof.setFont(new Font("Dialog", Font.BOLD, 14));

		lblUsuario = new JLabel("Usu\u00E1rio:");

		lblSenha = new JLabel("Senha:");

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO dao = new UsuarioDAO();

				try {
					Usuario usuario = (Usuario) dao.getPorLogin(txtUsuario
							.getText());

					if(usuario != null) {
						if (usuario.getSenha().equals(txtSenha.getText())) {
								dispose();
								PrincipalView principal = new PrincipalView();
								principal.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Senha inválida.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Dados inválidos.");
					}
					
					
						
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE));

		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(65)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblUsuario)
												.addComponent(lblSenha))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														txtSenha,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														txtUsuario,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnOk)
								.addContainerGap(77, Short.MAX_VALUE))
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap(107, Short.MAX_VALUE)
								.addComponent(lblBemVindo).addGap(112))
				.addGroup(
						gl_panel.createSequentialGroup().addGap(159)
								.addComponent(lblEsdof)
								.addContainerGap(178, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(42)
								.addComponent(lblBemVindo)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblEsdof)
								.addGap(38)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblUsuario)
												.addComponent(
														txtUsuario,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														btnOk,
														GroupLayout.PREFERRED_SIZE,
														19,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(
														gl_panel.createParallelGroup(
																Alignment.BASELINE)
																.addComponent(
																		lblSenha)
																.addComponent(
																		txtSenha,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(109, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
