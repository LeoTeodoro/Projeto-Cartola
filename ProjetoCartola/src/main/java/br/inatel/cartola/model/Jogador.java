package br.inatel.cartola.model;

public class Jogador {
    public String time;
    public float preco;
    public String nome;
    public float pontuacao;
    public String posicao;

    public int id;

    public Jogador(String time, float preco, String nome, float pontuacao, String posicao, int id) {
        this.time = time;
        this.preco = preco;
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.posicao = posicao;
        this.id = id;
    }
}
