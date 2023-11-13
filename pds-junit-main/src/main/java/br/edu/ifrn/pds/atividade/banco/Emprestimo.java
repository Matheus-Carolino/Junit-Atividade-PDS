package br.edu.ifrn.pds.atividade.banco;

import java.util.Objects;

public class Emprestimo {

    private float valorTotal, taxaJurosDecimal, valorParcela;
    private int qtdParcelas;

    public Emprestimo(float valorTotal, float taxaJurosDecimal, float valorParcela, int qtdParcelas) {
        this.valorTotal = valorTotal;
        this.taxaJurosDecimal = taxaJurosDecimal;
        this.valorParcela = valorParcela;
        this.qtdParcelas = qtdParcelas;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public float getTaxaJurosDecimal() {
        return taxaJurosDecimal;
    }

    public float getValorParcela() {
        return valorParcela;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Emprestimo))
            return false;

        Emprestimo that = (Emprestimo) o;
        return that.valorTotal == valorTotal &&
               that.taxaJurosDecimal == taxaJurosDecimal &&
               that.valorParcela == valorParcela &&
               that.qtdParcelas == qtdParcelas;
    }

}
