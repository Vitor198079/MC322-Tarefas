package jogo;

import entidades.Heroi;
import entidades.Inimigo;
import entidades.Boleto;
import efeitos.Cafeina;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class GameManagerTest {

    @Test
    public void testIniciarTurnoLimpaEscudoEAplicaEfeitos() {
        Heroi silvio = new Heroi("Silvio Santos", 100, 12);
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        inimigos.add(new Boleto("Boleto Vencido", 50, 10));
        
        GameManager gm = new GameManager(silvio, inimigos);

        Cafeina cafe = new Cafeina(silvio, 2);
        gm.inscrever(cafe);
        
        silvio.perderHorasdeSono(5); 
        silvio.setEscudo(15);

        gm.IniciarTurno();

        assertEquals(12, silvio.getHorasdeSono(), "O sono deveria ter sido restaurado para 12");
        
        assertEquals(2, silvio.getEscudo(), "O escudo final deve ser apenas o da Cafeína, pois o antigo zera");

        assertEquals(1, cafe.getAcumulos(), "A Cafeína deveria ter gasto 1 acúmulo ao agir");
    }
}
