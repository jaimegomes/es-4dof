package br.senai.sc.es4dof.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.senai.sc.es4dof.abstracts.ACadView;
import br.senai.sc.es4dof.abstracts.Entidade;

import org.jdesktop.swingx.JXDatePicker;

import com.toedter.calendar.JCalendar;

public class AgendarConsultaView extends ACadView {

	private static final long serialVersionUID = 1L;
	// estrutura da janela
	private JPanel panel;
	private GroupLayout groupLayout;
	private GroupLayout gl_panel;

	// campos do formulário
	private JLabel lblPaciente;
	private JLabel lblMedico;
	private JLabel lblData;

	// botões
	private JButton btnCancelar;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JComboBox cmbPaciente;
	private JComboBox cmbMedico;
	private JLabel lblEspecialidade;
	private JComboBox cmbEspecialidade;

	public AgendarConsultaView(Entidade entidade, JTable table) {
		super(entidade, table);

		// título da janela
		setTitle("Agendar Consulta");

		// instanciando o panel
		panel = new JPanel();

		// set configuração da borda
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "Agendar Consulta", TitledBorder.LEADING,
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

			}

		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon("images/borracha_16x16.png"));
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		lblPaciente = new JLabel("Paciente:");
		lblMedico = new JLabel("M\u00E9dico:");
		lblData = new JLabel("Data:");
		
		cmbPaciente = new JComboBox();

		cmbMedico = new JComboBox();
		

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
		
		JComboBox cmbData = new JComboBox();
		
		JLabel lblHora = new JLabel("Hora:");
		
		JComboBox cmbHora = new JComboBox();
		
		lblEspecialidade = new JLabel("Especialidade:");
		
		cmbEspecialidade = new JComboBox();

		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPaciente)
						.addComponent(lblEspecialidade)
						.addComponent(lblMedico)
						.addComponent(lblData)
						.addComponent(lblHora))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(cmbMedico, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cmbPaciente, Alignment.LEADING, 0, 330, Short.MAX_VALUE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(cmbData, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cmbHora, 0, 208, Short.MAX_VALUE))
						.addComponent(cmbEspecialidade, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(202, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(cmbPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPaciente, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbEspecialidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEspecialidade))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMedico))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblData))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHora))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
}
