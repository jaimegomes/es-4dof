package br.senai.sc.es4dof.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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

	private CadUsuarioView cadUsuView;
	private ConUsuarioView conUsuView;

	private AgendarConsultaView agendarConsultaView;
	private ListarConsutasView listarConsultaView;
	private JLabel background;

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

		setForeground(Color.BLUE);
		setTitle("::ES-4DoF:: Enterprise System - 4 Do Fast");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);

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
				cadUsuView = new CadUsuarioView(null, null);
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
				conUsuView = new ConUsuarioView(null);
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
				agendarConsultaView = new AgendarConsultaView(null, null);
				agendarConsultaView.requestFocus(true);
				agendarConsultaView.setFocusable(true);
				agendarConsultaView.moveToFront();
				getContentPane().add(agendarConsultaView, 0);
				agendarConsultaView.setVisible(true);

			}
		});

		// cria o menu item verificar consultas agendadas e adiciona
		// funcionalidade ao clicar
		mnitListarConsultas = new JMenuItem("Listar Consultas");
		mnitListarConsultas.setIcon(new ImageIcon("images/arquivo_16x16.png"));
		mnitListarConsultas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ListarConsutasView listarConsutaView = new ListarConsutasView(
						null);
				listarConsutaView.requestFocus(true);
				listarConsutaView.setFocusable(true);
				listarConsutaView.moveToFront();
				getContentPane().add(listarConsutaView, 0);
				listarConsutaView.setVisible(true);

			}
		});

		// adiciona itens ao menu consultas
		mnConsultas.add(mnitAgendarConsulta);
		mnConsultas.add(mnitListarConsultas);

		// adiciona itens na barra de menu
		menuBar.add(mnUsuarios);
		menuBar.add(mnConsultas);

		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		background = new JLabel();
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon("images/background_estetoscopio.jpg"));

		getContentPane().add(background);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addComponent(background)
						.addContainerGap(1164, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addComponent(background)
						.addContainerGap(625, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

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
