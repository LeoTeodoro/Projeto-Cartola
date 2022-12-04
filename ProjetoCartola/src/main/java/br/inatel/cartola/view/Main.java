package br.inatel.cartola.view;

import javax.swing.*;
import br.inatel.cartola.control.AdmJogadores;
import br.inatel.cartola.control.AdmLigas;
import br.inatel.cartola.control.AdmTimes;
import br.inatel.cartola.model.Jogador;
import br.inatel.cartola.model.Liga;
import br.inatel.cartola.model.Time;

public class Main {
    public static void main(String[] args) {

        int operacao;
        int ID;
        float PRECO ;
        String NOME;
        String POSICAO;
        String TIME;
        boolean sair = false;

        AdmJogadores admJogadores = new AdmJogadores();
        AdmTimes admTimes = new AdmTimes();
        AdmLigas admLigas = new AdmLigas();
        Jogador jogador = null;
        Time time = null;
        Liga liga = null;
        String op;

        while(!sair) {
            op = JOptionPane.showInputDialog("1-Cadastrar jogador" + "\n" + "2-Cadastrar time" + "\n" + "3-Criar liga" +
                    "\n" + "4- Mostrar jogadores" + "\n" + "5- Mostrar seu time" + "\n" + "6- Mostrar Liga" + "\n" + "7- Inserir Jogador no Time" +
                    "\n" + "8- Inserir Time na Liga" + "\n" + "9- Deletar jogadores" + "\n" + "10- Deletar time" + "\n" + "11- Deletar liga" +
                    "\n" + "12- Sair");
            operacao = Integer.valueOf(op).intValue();
            switch (operacao) {
                case 1:
                    String idJogador = JOptionPane.showInputDialog("Indique o id do jogador");
                    ID = Integer.valueOf(idJogador).intValue();
                    NOME = JOptionPane.showInputDialog("Digite o nome do jogador");
                    TIME = JOptionPane.showInputDialog("Digite o time do jogador");
                    POSICAO = JOptionPane.showInputDialog("Digite a posicao do jogador");
                    String preco = JOptionPane.showInputDialog("Digite o preço do jogador");
                    PRECO = Float.valueOf(preco).floatValue();
                    try {
                        jogador = new Jogador(TIME, PRECO, NOME, 0, POSICAO, ID);
                        admJogadores.InsereJogadores(jogador);
                        System.out.println(jogador.nome + " adicionado");
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 2:
                    String idTime = JOptionPane.showInputDialog("Indique o id do time");
                    ID = Integer.valueOf(idTime).intValue();
                    NOME = JOptionPane.showInputDialog("Digite o nome do time");
                    try {
                        time = new Time(ID, NOME, 100, 0, null);
                        admTimes.insereTimes(time);
                        System.out.println(time.nome + " adicionado");
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 3:
                    String idLiga = JOptionPane.showInputDialog("Indique o id da liga");
                    ID = Integer.valueOf(idLiga).intValue();
                    NOME = JOptionPane.showInputDialog("Digite o nome da liga");
                    try {
                        liga = new Liga(NOME, ID);
                        admLigas.insereLigas(liga);
                        System.out.println(liga.nome + " adicionado");
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Jogadores: \n");
                        admJogadores.mostraJogadores();
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Jogadores do time: \n");
                        admTimes.mostraJogadores(time);
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Times na liga: \n");
                        admLigas.mostraTimes(liga);
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 7:
                    try {
                        admTimes.insereJogador(time, jogador);
                        System.out.println(jogador.nome + " foi adicionado ao " + time.nome);
                        time.setDinheiro(time.getDinheiro() - jogador.preco);
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 8:
                    try {
                        admLigas.insereTime(liga, time);
                        System.out.println(time.nome + " foi adicionado a liga "+liga.nome);
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 9:
                    try {
                        admJogadores.deletaJogadores(jogador);
                        System.out.println(jogador.nome + " removido");
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 10:
                    try {
                        admTimes.deletaTimes(time);
                        System.out.println(time.nome + " removido");
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 11:
                    try {
                        admLigas.deletaLigas(liga);
                        System.out.println(liga.nome + " removido");
                    } catch (Exception e) {
                        System.out.println("Erro");
                    }
                    break;
                case 12:
                    sair = true;
            }
        }
/*
        Jogador Vini = new Jogador("Real Madrid", 27f, "Vinicius Junior", 8f, "Atacante", 2);
        Time LeleoFC = new Time(1, "Leleo Futebol Clube", 100, 0,null);
        Liga ligaA = new Liga("Liga dos amigos", 1);

        admJogadores.InsereJogadores(Vini);
        admJogadores.mostraJogadores();
        admJogadores.Assistencia(Vini);
        admJogadores.mostraJogadores();
        admJogadores.deletaJogadores(Vini);
        admTimes.insereTimes(LeleoFC);
        admTimes.mostraTimes();
        admTimes.insereJogador(LeleoFC, Vini);
        admTimes.mostraJogadores(LeleoFC);
        admLigas.insereLigas(ligaA);
        admLigas.mostraLigas();
        admLigas.insereTime(ligaA,LeleoFC);
        admLigas.mostraTimes(ligaA);

*/


    }
}
