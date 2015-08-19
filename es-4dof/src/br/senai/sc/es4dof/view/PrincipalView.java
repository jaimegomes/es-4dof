package br.senai.sc.es4dof.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PrincipalView extends JFrame {

	private static final long serialVersionUID = 1L;

	private static PrincipalView instancia;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnUsuarios;
	private JMenuItem mnitCadastro;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PrincipalView frame = getInstancia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalView() throws Exception {

		setExtendedState(Frame.MAXIMIZED_BOTH);
		setForeground(Color.BLUE);
		setTitle("::ES-4DoF:: Enterprise System - 4 Do Fast");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// cria a barra de menu
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// cria o menu Usuários e adiciona o icone
		mnUsuarios = new JMenu("Usuários");
		mnUsuarios.setIcon(new ImageIcon("images/10680_16x16.png"));

		// cria o menu item cadastro e adiciona funcionalidade ao clicar
		mnitCadastro = new JMenuItem("Cadastro");
		mnitCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadUsuarioView cadUsuView = new CadUsuarioView(null, null);
				cadUsuView.requestFocus(true);
				cadUsuView.setFocusable(true);
				cadUsuView.moveToFront();
				getContentPane().add(cadUsuView, 0);
				cadUsuView.setVisible(true);

			}
		});

		mnUsuarios.add(mnitCadastro);
		// adiciona o menu Usuários a barra de menu
		menuBar.add(mnUsuarios);
		
		

	}

	public static PrincipalView getInstancia() throws Exception {

		if (instancia == null) {
			instancia = new PrincipalView();
		}

		return instancia;
	}

	public static void setInstancia(PrincipalView instancia) {
		PrincipalView.instancia = instancia;
	}

}
