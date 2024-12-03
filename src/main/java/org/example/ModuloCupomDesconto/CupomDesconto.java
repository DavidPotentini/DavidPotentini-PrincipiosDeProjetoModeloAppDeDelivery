package org.example.ModuloCupomDesconto;

public abstract class CupomDesconto {
    private String nomeMetodo;
    private Double porcentagemDesconto;

    public CupomDesconto(String nomeMetodo, Double porcentagemDesconto) {
        this.nomeMetodo = nomeMetodo;
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public Double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    @Override
    public String toString() {
        return "CupomDesconto.CupomDescontoEntrega{" +
                "nomeMetodo='" + nomeMetodo + '\'' +
                ", porcentagemDesconto=" + porcentagemDesconto +
                '}';
    }

}
