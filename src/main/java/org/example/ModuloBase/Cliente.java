package org.example.ModuloBase;

public class Cliente {
    private String bairro;
    private String tipo;
    private String nome;
    private double fidelidade;
    private String logradouro;
    private String cidade;

    public Cliente(String bairro, String tipo, String nome, double fidelidade, String logradouro, String cidade) {
        this.bairro = bairro;
        this.tipo = tipo;
        this.nome = nome;
        this.fidelidade = fidelidade;
        this.logradouro = logradouro;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public double getFidelidade() {
        return fidelidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setFidelidade(double fidelidade) {
        this.fidelidade = fidelidade;
    }

    public String getTipo() {
        return tipo;
    }

    public String getBairro() {
        return bairro;
    }
}
