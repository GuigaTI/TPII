package br.edu.fatecpg.apigemini.services;
import java.io.*;

public class txtMaker {
    public static void gerarLog(String resposta){
        try {
            FileWriter escrita = new FileWriter("respostas.txt",true);
            String respostaC = formatarResposta(resposta);
            escrita.write(respostaC);
            escrita.close();
            System.out.println("Resposta salva com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar sua resposta.");
            e.printStackTrace();
        }
    }
        public static String formatarResposta(String resposta) {
            // Adiciona espaçamento entre parágrafos
            String respostaFormatada = resposta;
            respostaFormatada = resposta.replace("\n\n"," ");
            respostaFormatada = resposta.replace(" ** "," ");
            respostaFormatada = resposta.replace(" * "," ");
            return respostaFormatada;
        }

        public static void gerarResumo() throws IOException, InterruptedException {
        File del = new File("respostas.txt");
        FileReader leitura = new FileReader("respostas.txt");
        FileWriter escrita = new FileWriter("resumo.txt",true);
            BufferedReader bufferedReader = new
                    BufferedReader(leitura);
            String linha;
            StringBuilder resumoSujo = new StringBuilder(" ");
            while ((linha = bufferedReader.readLine()) != null) {
                resumoSujo.append(linha).append(" ");
            }
            String resumo = "Me de um resumo desses textos " + resumoSujo;
            escrita.write(ConsomeAPI.fazerPergunta(formatarResposta(resumo)));
            bufferedReader.close();
            del.deleteOnExit();
            escrita.close();
            System.out.println("Resumo criado");
        }
    }

