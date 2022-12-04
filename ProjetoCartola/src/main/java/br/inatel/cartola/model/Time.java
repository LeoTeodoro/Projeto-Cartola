package br.inatel.cartola.model;

import java.util.ArrayList;

public class Time {

    public int id;
    public String nome;
    private float dinheiro;

    public String Liga_idLiga;
    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public float pontuacaoTime;

    public Time(int id, String nome, float dinheiro, float pontuacaoTime, String Liga_idLiga) {
        this.id = id;
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.pontuacaoTime = pontuacaoTime;
        this.Liga_idLiga = Liga_idLiga;
    }

    public ArrayList<String> jogadores = new ArrayList<>();
}
