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

public class PrincipalFuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;

	private static PrincipalFuncionarioView instancia;
	private JPanel contentPane;
	private JMenuBar menuBar;

	private JMenu mnUsuarios;
	private JMenuItem mnitCadastarUsuario;
	private JMenuItem mnitListarUsuarios;

	private JMenu mnConsultas;
	private JMenuItem mnitAgendarConsulta;
	private JMenuItem mnitListarConsultas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PrincipalFuncionarioView frame = getInstancia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalFuncionarioView() throws Exception {

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
		mnUsuarios.setIcon(new ImageIcon("images/usuario_16x16.png"));

		// cria o menu item cadastro e adiciona funcionalidade ao clicar
		mnitCadastarUsuario = new JMenuItem("Cadastar Usuário");
		mnitCadastarUsuario.setIcon(new ImageIcon("images/add_16x16.png"));
		mnitCadastarUsuario.addActionListener(new ActionListener() {

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

		// cria o menu item consultar e adiciona funcionalidade ao clicar
		mnitListarUsuarios = new JMenuItem("Listar Usuários");
		mnitListarUsuarios.setIcon(new ImageIcon("images/usuarios_16x16.png"));
		mnitListarUsuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConUsuarioView conUsuView = new ConUsuarioView(null);
				conUsuView.requestFocus(true);
				conUsuView.setFocusable(true);
				conUsuView.moveToFront();
				getContentPane().add(conUsuView, 0);
				conUsuView.setVisible(true);

			}
		});

		// adiciona itens ao menu usuário
		mnUsuarios.add(mnitCadastarUsuario);
		mnUsuarios.add(mnitListarUsuarios);

		// cria o menu Consultas e adiciona o icone
		mnConsultas = new JMenu("Consultas");
		mnConsultas.setIcon(new ImageIcon("images/cruz_vermelha_16x16.png"));

		// cria o menu item agendar consulta e adiciona funcionalidade ao clicar
		mnitAgendarConsulta = new JMenuItem("Agendar Consultas");
		mnitAgendarConsulta.setIcon(new ImageIcon("images/agenda_16x16.png"));
		mnitAgendarConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AgendarConsultaView agendarConsutaView = new AgendarConsultaView(null, null);
				agendarConsutaView.requestFocus(true);
				agendarConsutaView.setFocusable(true);
				agendarConsutaView.moveToFront();
				getContentPane().add(agendarConsutaView, 0);
				agendarConsutaView.setVisible(true);

			}
		});

		// cria o menu item verificar consultas agendadas e adiciona
		// funcionalidade ao clicar
		mnitListarConsultas = new JMenuItem("Listar Consultas");
		mnitListarConsultas.setIcon(new ImageIcon("images/arquivo_16x16.png"));
		mnitListarConsultas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		// adiciona itens ao menu consultas
		mnConsultas.add(mnitAgendarConsulta);
		mnConsultas.add(mnitListarConsultas);

		// adiciona itens na barra de menu
		menuBar.add(mnUsuarios);
		menuBar.add(mnConsultas);

	}

	public static PrincipalFuncionarioView getInstancia() throws Exception {

		if (instancia == null) {
			instancia = new PrincipalFuncionarioView();
		}

		return instancia;
	}

	public static void setInstancia(PrincipalFuncionarioView instancia) {
		PrincipalFuncionarioView.instancia = instancia;
	}

}
