package br.edu.fatecpg.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.fatecpg.model.Aeroporto;

public class Operacoes {
    private JTextField txtBusca;
    private JButton btnBuscar;
    private JPanel painelOp;
    private JTextField txtTipoV;
    private JRadioButton rdBtnPontosT;
    private JTextField txtQuantidade;
    private JButton btnPagamento;
    private JButton voltarButton;
    private String busca;

    public Operacoes(Aeroporto aero)  {
        JFrame frame = new JFrame("Pagina de Operações");
        frame.setContentPane(painelOp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busca = txtBusca.getText();
                if(aero.buscarVoo(busca) != -1){
                    JOptionPane.showMessageDialog(null,aero.imprimirVoo(aero.buscarVoo(busca)));;
                }else{
                    JOptionPane.showMessageDialog(null,"Voo não foi localizado");
                }
            }
        });
        btnPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qtd = Integer.parseInt(txtQuantidade.getText());
                boolean pontos = rdBtnPontosT.isSelected();
                String tipoV = txtTipoV.getText();

                JOptionPane.showMessageDialog(null,aero.getVoo(busca).realizarPagamento(tipoV,pontos,qtd));
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Principal(aero); // Chama a interface principal
                frame.dispose(); // Fecha a janela atual
            }
        });
    }
}
