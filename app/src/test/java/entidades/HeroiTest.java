package entidades;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroiTest {
    @Test
    public void testPerderHorasDeSono() {
        Heroi silvio = new Heroi("Silvio Santos", 100, 12);
        
        silvio.perderHorasdeSono(3);
        
        assertEquals(9, silvio.getHorasdeSono(), "O herói deveria ficar com 9 horas de sono");
    }

    @Test
    public void testReceberDanoSemEscudo() {
        Heroi silvio = new Heroi("Silvio Santos", 100, 12);
        
        silvio.receberDano(20);
        
        assertEquals(80, silvio.getVida(), "A vida deveria cair para 80");
    }

    @Test
    public void testReceberDanoComEscudo() {
        Heroi silvio = new Heroi("Silvio Santos", 100, 12);
        
        silvio.setEscudo(15);
        silvio.receberDano(20);
        
        assertEquals(95, silvio.getVida(), "O escudo deveria absorver parte do dano antes de afetar a vida");
        assertEquals(0, silvio.getEscudo(), "O escudo deveria ter sido completamente destruído");
    }
}