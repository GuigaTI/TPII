package br.edu.fatecpg.view;

import br.edu.fatecpg.model.Aeroporto;
import br.edu.fatecpg.model.Voo;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AeroportoTabela extends JFrame {
    private JPanel painel;
    private JButton btnAtualizar;
    private JTable tbHistorico;
    private JButton voltarButton;

    private static class AeroportoModel extends AbstractTableModel {
        private ArrayList<Voo> voos;
        private final String[] colunas = {"Número Voo", "Origem", "Destino", "Assentos Disponíveis", "Preço por passagem"};

        public AeroportoModel(ArrayList<Voo> voos) {
            this.voos = voos;
        }

        @Override
        public int getRowCount() {
            return voos.size();
        }

        @Override
        public int getColumnCount() {
            return colunas.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Voo voo = voos.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> voo.getNumVoo();
                case 1 -> voo.getOrigemCidade();
                case 2 -> voo.getDestinoCidadde();
                case 3 -> voo.getAssentosDisponiveis();
                case 4 -> voo.getValorPassagem();
                default -> null;
            };
        }

        @Override
        public String getColumnName(int column) {
            return colunas[column];
        }

        // Método para atualizar os dados da tabela
        public void setVoos(ArrayList<Voo> novosVoos) {
            this.voos = novosVoos;
            fireTableDataChanged(); // Notifica a tabela que os dados mudaram
        }
    }

    public AeroportoTabela(Aeroporto aeroporto) {
        setTitle("Voos"); // Define o título da janela
        setContentPane(painel);
        painel.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela atual
        JScrollPane scrollPane = new JScrollPane(tbHistorico);
        painel.add(scrollPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(voltarButton);
        bottomPanel.add(btnAtualizar);
        painel.add(bottomPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        AeroportoModel tableModel = new AeroportoModel(aeroporto.getVoos());
        tbHistorico.setModel(tableModel);


        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Principal(aeroporto); // Chama a interface principal
                dispose(); // Fecha a janela atual
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setVoos(aeroporto.getVoos()); // Atualiza o modelo com os novos dados
            }
        });
    }
}