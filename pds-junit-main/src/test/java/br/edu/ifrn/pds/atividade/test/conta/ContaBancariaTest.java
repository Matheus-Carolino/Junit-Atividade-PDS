package br.edu.ifrn.pds.atividade.test.conta;

import br.edu.ifrn.pds.atividade.conta.ContaBancaria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    @Test
    public void deveriaRetornarSaldoDe1000() {
        ContaBancaria contaBancaria = new ContaBancaria("123.456.789-00", 1000);

        assertEquals(1000, contaBancaria.consultarSaldo());
    }

    @Test
    public void deveriaDepositar1000() {
        ContaBancaria contaBancaria = new ContaBancaria("123.456.789-00", 1000);
        contaBancaria.depositar(1000);

        assertEquals(2000, contaBancaria.consultarSaldo());
    }

    @Test
    public void deveriaLancarExcecaoAoDepositar() {
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("123.456.789-00", 1000).depositar(-20));
    }

    @Test
    public void deveriaLancarMensagemCorretaAoDepositar() {
        try {

            new ContaBancaria("123.456.789-00", 1000).depositar(-50);

            fail("Não lançou exceção correta");

        } catch (IllegalArgumentException e) {

            assertEquals("Impossível realização operação com valor menor ou igual a zero...", e.getMessage());

        }
    }

    @Test
    public void deveriaSacar400() {
        ContaBancaria contaBancaria = new ContaBancaria("123.456.789-00", 1000);

        assertEquals(400, contaBancaria.sacar(400));
    }

    @Test
    public void deveriaDiminuirSaldoAoSacar400() {
        ContaBancaria contaBancaria = new ContaBancaria("123.456.789-00", 800);
        contaBancaria.sacar(400);

        assertEquals(400, contaBancaria.consultarSaldo());
    }

    @Test
    public void deveriaLancarExcecaoAoSacarValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("123.456.789-00", 1000).sacar(-40));
    }

    @Test
    public void deveriaLancarExcecaoAoSacarValorMaiorQueSaldo() {
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("123.456.789-00", 1000).sacar(1500));
    }

    @Test
    public void deveriaTransferir500ParaConta2() {
        ContaBancaria conta1 = new ContaBancaria("123.456.789-00", 800);
        ContaBancaria conta2 = new ContaBancaria("987.654.321-00", 400);

        conta1.transferir(conta2, 500);

        assertEquals(900, conta2.consultarSaldo());
    }

    @Test
    public void deveriaLancarExcecaoAoTransferirValorNegativo() {
        try {

            ContaBancaria conta1 = new ContaBancaria("123.456.789-00", 800);
            ContaBancaria conta2 = new ContaBancaria("987.654.321-00", 400);

            conta1.transferir(conta2, -500);

            fail("Não lançou exceção correta");

        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void deveriaLancarExcecaoAoTransferirValorMaiorQueSaldo() {
        try {

            ContaBancaria conta1 = new ContaBancaria("123.456.789-00", 800);
            ContaBancaria conta2 = new ContaBancaria("987.654.321-00", 400);

            conta1.transferir(conta2, 1000);

            fail("Não lançou exceção correta");

        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void deveriaLancarExcecaoAoTransferirParaMesmaConta() {
        try {

            ContaBancaria conta1 = new ContaBancaria("123.456.789-00", 800);

            conta1.transferir(conta1, 800);

            fail("Não lançou exceção correta");

        } catch (IllegalArgumentException e) {

        }
    }

}
