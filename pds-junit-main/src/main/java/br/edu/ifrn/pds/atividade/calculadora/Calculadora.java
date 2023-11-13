package br.edu.ifrn.pds.atividade.calculadora;

public class Calculadora {

    public float somar(float a, float b) {
        return a + b;
    }

    public float subtrair(float a, float b) {
        return a - b;
    }

    public float multiplicar(float a, float b) {
        return a * b;
    }

    public float dividir(float a, float b) {
        if (b == 0)
            throw new ArithmeticException("Impossível dividir para 0");

        return a / b;
    }

}
