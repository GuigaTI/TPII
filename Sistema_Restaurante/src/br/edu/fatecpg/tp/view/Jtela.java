package br.edu.fatecpg.tp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;

import br.edu.fatecpg.tp.model.*;

public class Jtela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblAdicioneItemAo = new JLabel("Restaurante");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jtela frame = new Jtela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jtela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(86, 27, 703, 572);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Prato");
		lblNewLabel.setBounds(49, 129, 105, 15);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Adicionar Item");
		btnNewButton.setBounds(38, 309, 163, 25);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		textField = new JTextField();
		textField.setBounds(38, 156, 163, 19);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Remover Item");
		btnNewButton_1.setBounds(38, 391, 163, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Criar Novo Pedido");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_3.getText()!=null && textField_3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton_2, "Pedido Criado");

				}
					
					
					
			}
		});
		btnNewButton_2.setBounds(38, 76, 163, 25);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setBounds(49, 187, 116, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblPreoUnitrio = new JLabel("Preço Unitário");
		lblPreoUnitrio.setBounds(49, 250, 105, 15);
		panel.add(lblPreoUnitrio);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(38, 214, 163, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(38, 278, 163, 19);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("Numero do Pedido");
		lblNewLabel_2.setBounds(49, 22, 152, 15);
		panel.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(38, 49, 163, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Exibir Pedido");
		btnNewButton_3.setBounds(321, 311, 152, 21);
		panel.add(btnNewButton_3);
		lblAdicioneItemAo.setBackground(Color.BLACK);
		lblAdicioneItemAo.setBounds(364, 2, 170, 15);
		contentPane.add(lblAdicioneItemAo);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
