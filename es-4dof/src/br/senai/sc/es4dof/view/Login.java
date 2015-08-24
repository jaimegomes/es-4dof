package br.senai.sc.es4dof.view;

import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaime
 */
public class Login extends javax.swing.JFrame {

	private javax.swing.JButton btnOk;
	private javax.swing.JLabel lblUsuario;
	private javax.swing.JLabel lblSenha;
	private javax.swing.JLabel lblBackground;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField txtUsuario;
	private javax.swing.JPasswordField txtSenha;

	public Login() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		lblUsuario = new javax.swing.JLabel();
		txtUsuario = new javax.swing.JTextField();
		txtSenha = new javax.swing.JPasswordField();
		btnOk = new javax.swing.JButton();
		lblSenha = new javax.swing.JLabel();
		lblBackground = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setLayout(null);

		lblUsuario.setText("Usuário:");
		jPanel1.add(lblUsuario);
		lblUsuario.setBounds(50, 300, 80, 15);
		txtUsuario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});
		jPanel1.add(txtUsuario);
		txtUsuario.setBounds(120, 290, 140, 30);
		jPanel1.add(txtSenha);
		txtSenha.setBounds(120, 330, 140, 30);

		btnOk.setText("Ok");
		jPanel1.add(btnOk);
		btnOk.setBounds(270, 340, 65, 20);
		btnOk.setIcon(new ImageIcon("images/ok_16x16.png"));

		lblSenha.setText("Senha:");
		jPanel1.add(lblSenha);
		lblSenha.setBounds(50, 340, 51, 15);

		lblBackground.setIcon(new javax.swing.ImageIcon(
				"/home/jaime/Área de Trabalho/Sem título1.png")); // NOI18N
		jPanel1.add(lblBackground);
		lblBackground.setBounds(-110, 0, 520, 400);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 400,
								Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 419,
								Short.MAX_VALUE).addContainerGap()));

		pack();
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginView.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginView.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginView.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginView.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

}
