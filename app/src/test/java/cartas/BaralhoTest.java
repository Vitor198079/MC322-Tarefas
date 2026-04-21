package cartas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaralhoTest {

    @Test
    public void testInicializacaoECompra() {
        Baralho baralho = new Baralho();

        assertTrue(baralho.maoEstaVazia(), "A mão deve começar vazia");

        baralho.comprarCartas(5);
        assertEquals(5, baralho.getMao().size(), "A mão deve ter 5 cartas após a compra");
        assertFalse(baralho.maoEstaVazia(), "A mão já não pode estar vazia");
    }

    @Test
    public void testUsoEDescarteDeCartas() {
        Baralho baralho = new Baralho();
        baralho.comprarCartas(3);

        baralho.cartaUsadaParaDescarte(0);
        assertEquals(2, baralho.getMao().size(), "A mão deve ter 2 cartas após usar uma");
        baralho.descartarMaoRestante();
        assertTrue(baralho.maoEstaVazia(), "A mão deve ficar completamente vazia após o descarte do turno");
    }

    @Test
    public void testReciclagemDoLixo() {
        Baralho baralho = new Baralho();
        
        baralho.comprarCartas(25);
        baralho.descartarMaoRestante();
        assertTrue(baralho.maoEstaVazia());
        baralho.comprarCartas(5);
        assertEquals(5, baralho.getMao().size(), "O estagiário deve ter reciclado o lixo com sucesso e dado 5 cartas");
    }
}