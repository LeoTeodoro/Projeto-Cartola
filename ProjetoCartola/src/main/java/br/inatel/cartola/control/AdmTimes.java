package br.inatel.cartola.control;

import br.inatel.cartola.DAO.JogadorDAO;
import br.inatel.cartola.DAO.TimeDAO;
import br.inatel.cartola.model.Jogador;
import br.inatel.cartola.model.Time;


public class AdmTimes {
    TimeDAO timeDAO = new TimeDAO();


    public void insereTimes(Time time){
        timeDAO.insertTime(time);
    }

    public void mostraTimes(){
        timeDAO.selectTimes();
    }
    public void deletaTimes(Time time){
        timeDAO.deleteTime(time);
    }
    public void atualizaTimes(Time time){
        timeDAO.updateTime(time.id,time);
    }

    public void mostraJogadores(Time time){
        System.out.println(time.jogadores);
    }
    public void insereJogador(Time time, Jogador jogador){
        time.jogadores.add(jogador.nome);
        timeDAO.updateTime(time.id,time);
    }

    public void pontos(Time time, Jogador jogador) {
        time.pontuacaoTime = time.pontuacaoTime + jogador.pontuacao;
    }
}
