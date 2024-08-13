package br.edu.fatecpg.view;

import br.edu.fatecpg.model.Aeroporto;
import br.edu.fatecpg.model.Voo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVoos {
    private JPanel panel1;
    private JButton adicionarButton;
    private JTextField txtNumVoo;
    private JLabel lbNumV;
    private JTextField txtOrigem;
    private JLabel lblOrigem;
    private JTextField txtDestino;
    private JLabel lblDestino;
    private JTextField txtNumAssento;
    private JLabel lblAssentos;
    private JButton btnVoltar;
    private String numVoo;
    private String origemCidade;
    private String destinoCidadde;
    private int assentosDisponiveis;

    public AddVoos(Aeroporto aero) {

        JFrame frame = new JFrame("Adicionar Voos");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numVoo = txtNumVoo.getText();
                origemCidade = txtOrigem.getText();
                destinoCidadde = txtDestino.getText();
                assentosDisponiveis = Integer.parseInt(txtNumAssento.getText());
                aero.addVoo(new Voo(numVoo,origemCidade,destinoCidadde,assentosDisponiveis));

                txtNumVoo.setText("");
                txtOrigem.setText("");
                txtDestino.setText("");
                txtNumAssento.setText("");
                JOptionPane.showMessageDialog(null, "Voo adicionado com sucesso!");
            }
        });
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Principal(aero);
                frame.dispose();
            }
        });
    }

}
