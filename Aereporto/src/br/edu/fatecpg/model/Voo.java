package br.edu.fatecpg.model;

import java.util.Objects;

public class Voo {

    private String numVoo;
    private String origemCidade;
    private String destinoCidadde;
    private int assentosDisponiveis = 30;

    private double valorPassagem = 1550.50; // Valor para todas passagens padrão


    public Voo(String numVoo, String origem, String destino, int assentD) {
        this.numVoo = numVoo;
        this.origemCidade = origem;
        this.destinoCidadde = destino;
        this.assentosDisponiveis = assentD;
    }

    public double getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    public String getNumVoo() {
        return numVoo;
    }

    public void setNumVoo(String numVoo) {
        this.numVoo = numVoo;
    }

    public String getOrigemCidade() {
        return origemCidade;
    }

    public void setOrigemCidade(String origemCidade) {
        this.origemCidade = origemCidade;
    }

    public String getDestinoCidadde() {
        return destinoCidadde;
    }

    public void setDestinoCidadde(String destinoCidadde) {
        this.destinoCidadde = destinoCidadde;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public boolean verificaDisponibilidade(int qtdAssentos) {
        if (qtdAssentos >= this.assentosDisponiveis) {
            return true;
        } else {
            return false;
        }
    }

    public void realizarReserva(int quantidadeAssentos) {
        if (verificaDisponibilidade(quantidadeAssentos)) {
            System.out.println("Número de assentos indisponiveis");
        } else {
            System.out.println("Reserva concluida");
            this.assentosDisponiveis -= quantidadeAssentos;
        }
    }

    public String realizarPagamento(String tipoViagem, boolean pontosT, int qtdPassagens) {
        double valor;

        if (Objects.equals(tipoViagem, "ida")) {
            if (pontosT) {
                valor = (this.valorPassagem * qtdPassagens) + 150; // 150 valor extra por pontos
            } else {
                valor = this.valorPassagem * qtdPassagens;
            }
        } else {
            if (pontosT) {
                valor = ((this.valorPassagem * qtdPassagens) + 150) * 1.5; // 1.5 é o valor de ida e volta
            } else {
                valor = (this.valorPassagem * qtdPassagens) * 1.5;
            }
        }
        realizarReserva(qtdPassagens);

       return "Informações do pagamento:{ " +
               "Tipo de viagem='" + tipoViagem + '\'' +
               "Possui pontos turisticos=' " + pontosT + '\'' +
                "Quantida de passagens=' " + qtdPassagens + '\'' +
               "Valor:=' " + valor + '\'' + "Pagamento realizado";


    }

    @Override
    public String toString() {
        return "Voo{" +
                "Número do voo='" + numVoo + '\'' +
                ", Cidade de Origem='" + origemCidade + '\'' +
                ", Cidade de Destino='" + destinoCidadde + '\'' +
                ", Quantidade de assentos dispiniveis=" + assentosDisponiveis +
                ", Valor da passagem=" + valorPassagem +
                '}';
    }





}

