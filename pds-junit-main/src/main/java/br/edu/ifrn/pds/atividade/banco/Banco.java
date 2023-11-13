package br.edu.ifrn.pds.atividade.banco;

public class Banco {

    public Emprestimo solicitarEmprestimo(float valorEmprestimo, float taxaJurosPorcentagem) {
        if (taxaJurosPorcentagem <= 0)
            throw new IllegalArgumentException("Taxa de juros inválida.");

        float taxaJurosDecimal = taxaJurosPorcentagem / 100;
        int parcelas = 0;

        if (valorEmprestimo >= 3000 && valorEmprestimo <= 8000) {

            parcelas = 12;

        }
        else if (valorEmprestimo > 8000 && valorEmprestimo <= 25000) {

            parcelas = 36;

        }
        else if (valorEmprestimo > 25000 && valorEmprestimo <= 50000) {

            parcelas = 60;

        }
        else if (valorEmprestimo > 50000 && valorEmprestimo <= 150000) {

            parcelas = 120;

        }
        else {

            throw new IllegalArgumentException("Valor de empréstimo inválido.");

        }
        float valorParcela = valorEmprestimo / parcelas;
        float jurosParcela = valorParcela * taxaJurosDecimal;
        float valorTotalParcela = valorParcela + jurosParcela;

        return new Emprestimo(valorEmprestimo, taxaJurosDecimal, valorTotalParcela, parcelas);
    }

}
