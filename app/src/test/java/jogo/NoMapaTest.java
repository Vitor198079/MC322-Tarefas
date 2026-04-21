package jogo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import entidades.Heroi;
import entidades.Inimigo;
import cartas.Baralho;
import java.util.ArrayList;

public class NoMapaTest {

    @Test
    public void testCriacaoECaminhosDoMapa() {
        Heroi silvio = new Heroi("Silvio", 100, 12);
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        Baralho baralho = new Baralho();
        Batalha batalha = new Batalha(silvio, inimigos, baralho, "arte_silvio", "arte_cartao", "arte_boleto");

        NoMapa inicio = new NoMapa("Guarujá", batalha);
        NoMapa destino = new NoMapa("Acre", batalha);
        assertEquals("Guarujá", inicio.getlocal(), "O nome do local deve estar correto");
        assertEquals(batalha, inicio.getBatalha(), "A batalha associada deve ser a mesma que passámos no construtor");

        inicio.adiciona_caminho(destino);
        assertEquals(1, inicio.getCaminhos().size(), "Deve haver 1 caminho disponível a partir do início");
        assertEquals(destino, inicio.getCaminhos().get(0), "O caminho deve levar ao Acre");
    }
}
