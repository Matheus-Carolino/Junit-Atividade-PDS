package br.edu.ifrn.pds.atividade.test.calculadora;

import br.edu.ifrn.pds.atividade.calculadora.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {

    @Test
    public void deveriaSomar1E2() {
        Calculadora calculadora = new Calculadora();

        assertEquals(3, calculadora.somar(1, 2));
    }

    @Test
    public void deveriaSubtrair5De10() {
        Calculadora calculadora = new Calculadora();

        assertEquals(5, calculadora.subtrair(10, 5));
    }

    @Test
    public void deveriaMultiplicar8E4() {
        Calculadora calculadora = new Calculadora();

        assertEquals(32, calculadora.multiplicar(8, 4));
    }

    @Test
    public void deveriaDividir9Para3() {
        Calculadora calculadora = new Calculadora();

        assertEquals(3, calculadora.dividir(9, 3));
    }

    @Test
    public void deveriaLancarArithmeticException() {
        assertThrows(ArithmeticException.class, () -> new Calculadora().dividir(10, 0));
    }

}
