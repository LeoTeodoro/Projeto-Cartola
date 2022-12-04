package br.inatel.cartola.model;

public interface Pontua {
    void ChuteGol(Jogador jogador);
    void PasseCerto(Jogador jogador);
    void Desarme(Jogador jogador);
    void Assistencia(Jogador jogador);
    void PenaltiDefendido(Jogador jogador);
    void PenaltiPerdido(Jogador jogador);
    void PasseErrado(Jogador jogador);
    void BolaPerdida(Jogador jogador);
    void CartaoAmarelo(Jogador jogador);
    void CartaoVermelho(Jogador jogador);
    void GolTomado(Jogador jogador);
    void GolContra(Jogador jogador);
}
