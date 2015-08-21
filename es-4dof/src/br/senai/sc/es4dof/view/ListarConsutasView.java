package br.senai.sc.es4dof.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.JXDatePicker;

import br.senai.sc.es4dof.abstracts.AConView;

public class ListarConsutasView extends AConView {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnCancelar;
	private JButton btnInserir;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JPanel panel;
	private JCheckBox chckbxPaciente;
	private JCheckBox chckbxMedico;
	private JCheckBox chckbxData;
	private JCheckBox chckbxEspecialidade;
	private JButton btnPesquisar;
	private JXDatePicker datePicker;
	private JComboBox cmbPaciente;
	private JComboBox cmbEspecialidade;
	private JComboBox cmbMedico;

	@SuppressWarnings("unchecked")
	public ListarConsutasView(JTable tableRefresh) {
		super(tableRefresh);

		setTitle("Consultas Agendadas");

		// filtro de pesquisa
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Filtro de Pesquisa",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		chckbxPaciente = new JCheckBox("Paciente");
		chckbxPaciente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chckbxPaciente.isSelected()) {
					cmbPaciente.setEnabled(true);
					cmbPaciente.setBackground(Color.white);
				} else {
					cmbPaciente.setEnabled(false);
					cmbPaciente.setBackground(Color.LIGHT_GRAY);
				}
			}
		});

		chckbxMedico = new JCheckBox("Medico");
		chckbxMedico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chckbxMedico.isSelected()) {
					cmbMedico.setEnabled(true);
					cmbMedico.setBackground(Color.white);
				} else {
					cmbMedico.setEnabled(false);
					cmbMedico.setBackground(Color.LIGHT_GRAY);
				}
			}
		});

		chckbxData = new JCheckBox("Data");
		chckbxData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chckbxData.isSelected()) {
					datePicker.setEnabled(true);
					datePicker.setBackground(Color.white);
				} else {
					datePicker.setEnabled(false);
					datePicker.setBackground(Color.LIGHT_GRAY);
				}
			}
		});

		chckbxEspecialidade = new JCheckBox("Especialidade");
		chckbxEspecialidade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chckbxEspecialidade.isSelected()) {
					cmbEspecialidade.setEnabled(true);
					cmbEspecialidade.setBackground(Color.white);
				} else {
					cmbEspecialidade.setEnabled(false);
					cmbEspecialidade.setBackground(Color.LIGHT_GRAY);
				}
			}
		});

		datePicker = new JXDatePicker();
		datePicker.setEnabled(false);

		cmbPaciente = new JComboBox();
		cmbPaciente.setEnabled(false);
		cmbEspecialidade = new JComboBox();
		cmbEspecialidade.setEnabled(false);
		cmbMedico = new JComboBox();
		cmbMedico.setEnabled(false);

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

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon("images/lupa_16x16.png"));
		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
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
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnInserir,
																				GroupLayout.PREFERRED_SIZE,
																				100,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnEditar,
																				GroupLayout.PREFERRED_SIZE,
																				99,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnExcluir,
																				GroupLayout.PREFERRED_SIZE,
																				100,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				63,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnPesquisar,
																				GroupLayout.PREFERRED_SIZE,
																				126,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(51)
																		.addComponent(
																				btnCancelar,
																				GroupLayout.PREFERRED_SIZE,
																				123,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																		.addComponent(
																				panel,
																				Alignment.LEADING,
																				0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				table,
																				Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE,
																				673,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(table,
										GroupLayout.PREFERRED_SIZE, 237,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnInserir)
												.addComponent(btnEditar)
												.addComponent(btnExcluir)
												.addComponent(btnPesquisar)
												.addComponent(btnCancelar))
								.addContainerGap()));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(chckbxPaciente)
												.addComponent(
														chckbxEspecialidade))
								.addGap(5)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING, false)
												.addComponent(
														cmbEspecialidade,
														0,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(cmbPaciente, 0,
														205, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		chckbxData)
																.addGap(18)
																.addComponent(
																		datePicker,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		chckbxMedico)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		cmbMedico,
																		GroupLayout.PREFERRED_SIZE,
																		229,
																		GroupLayout.PREFERRED_SIZE)))
								.addGap(34)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(chckbxPaciente)
												.addComponent(
														cmbPaciente,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														cmbMedico,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(chckbxMedico))
								.addPreferredGap(ComponentPlacement.RELATED,
										GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														chckbxEspecialidade)
												.addComponent(
														cmbEspecialidade,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(chckbxData)
												.addComponent(
														datePicker,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))));
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

	public void actionBtnPesquisar() {

	}
}
