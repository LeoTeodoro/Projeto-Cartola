package br.inatel.cartola.model;

import java.util.ArrayList;

public class Liga {
    public String nome;

    public int id;

    public Liga(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public ArrayList<String> times = new ArrayList<>();
}
