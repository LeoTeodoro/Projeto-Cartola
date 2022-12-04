package br.inatel.cartola.control;

import br.inatel.cartola.DAO.JogadorDAO;
import br.inatel.cartola.model.Pontua;
import br.inatel.cartola.model.Jogador;

public class AdmJogadores implements Pontua {
    JogadorDAO jogadorDAO = new JogadorDAO();

    public void InsereJogadores(Jogador jogador){
        jogadorDAO.insertJogador(jogador);
    }

    public void mostraJogadores(){
        jogadorDAO.selectJogadores();
    }

    public void deletaJogadores(Jogador jogador){
        jogadorDAO.deleteJogador(jogador);
    }

    public void atualizaJogadores(Jogador jogador){
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void ChuteGol(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao + 1;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void PasseCerto(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao + 0.3f;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void Desarme(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao + 0.75f;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void Assistencia(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao + 5;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void PenaltiDefendido(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao + 8;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void PenaltiPerdido(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao - 4;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void PasseErrado(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao - 0.3f;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void BolaPerdida(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao - 0.5f;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void CartaoAmarelo(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao - 3;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void CartaoVermelho(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao - 5;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void GolTomado(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao - 3;
        jogadorDAO.updateJogador(jogador.id, jogador);
    }

    @Override
    public void GolContra(Jogador jogador) {
        jogador.pontuacao = jogador.pontuacao - 5;
        jogadorDAO.updateJogador(jogador.id, jogador);

    }
}
