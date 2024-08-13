package br.edu.fatecpg.view;

import br.edu.fatecpg.model.Aeroporto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JPanel contentPane;
    private JButton BtnVerV;
    private JButton BtnAddVoos;
    private JButton realizarOperaçõesBuscaEButton;

    public Principal(Aeroporto a) {

        JFrame frame = new JFrame("Pagina Principal");
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
                ;

        BtnAddVoos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddVoos(a);
                frame.dispose();
            }
        });
        BtnVerV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AeroportoTabela(a);
                frame.dispose();
            }
        });
        realizarOperaçõesBuscaEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Operacoes(a);
                frame.dispose();
            }
        });
    }


}
