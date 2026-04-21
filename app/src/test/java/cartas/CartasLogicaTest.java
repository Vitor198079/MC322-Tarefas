package cartas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import entidades.Heroi;
import entidades.Boleto;
import jogo.GameManager;
import java.util.ArrayList;

public class CartasLogicaTest {

    @Test
    public void testCartaDanoNoInimigo() {
        Heroi silvio = new Heroi("Silvio", 100, 12);
        Boleto boleto = new Boleto("Boleto", 50, 10);
        GameManager gm = new GameManager(silvio, new ArrayList<>());
        
        CartaDano dano = new CartaDano("Paredão", "Dano", 3, 30);
        dano.usar(silvio, boleto, gm);
        
        assertEquals(20, boleto.getVida(), "O boleto deveria ter 20 de vida após 30 de dano");
        assertEquals(9, silvio.getHorasdeSono(), "O custo de 3 horas de sono deve ser aplicado");
    }

    @Test
    public void testCartaEscudoNoHeroi() {
        Heroi silvio = new Heroi("Silvio", 100, 12);
        Boleto boleto = new Boleto("Boleto", 50, 10);
        GameManager gm = new GameManager(silvio, new ArrayList<>());
        
        CartaEscudo escudo = new CartaEscudo("Cafezinho", "Escudo", 1, 10);
        escudo.usar(silvio, boleto, gm);
        
        assertEquals(10, silvio.getEscudo(), "O herói deveria ganhar 10 de escudo");
    }

    @Test
    public void testCartaHibrida() {
        Heroi silvio = new Heroi("Silvio", 100, 12);
        Boleto boleto = new Boleto("Boleto", 50, 10);
        GameManager gm = new GameManager(silvio, new ArrayList<>());
        
        CartaHibrida hibrida = new CartaHibrida("Twitter", "Dano/Efeito", 3, 10, 5);
        hibrida.usar(silvio, boleto, gm);
        
        assertEquals(40, boleto.getVida(), "Dano da híbrida deve ser aplicado");
    }
}
