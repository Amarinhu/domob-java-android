package com.example.domob;

public class Tarefa {
    private int id;
    private String nome;
    private String observacao;
    private int dificuldade;
    private int atributoId;

    public Tarefa(int id, String nome, String observacao, int dificuldade, int atributoId) {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
        this.dificuldade = dificuldade;
        this.atributoId = atributoId;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public int getAtributoId() {
        return atributoId;
    }
}
