package efeitos;

import entidades.Heroi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CafeinaTest {

    @Test
    public void testCafeinaDaEscudo() {
        Heroi silvio = new Heroi("Silvio", 100, 12);
        Cafeina cafe = new Cafeina(silvio, 2);
        
        cafe.serNotificado("INICIO_BADERNA_Silvio");
        assertEquals(2, silvio.getEscudo(), "O herói deveria ter ganho 2 de escudo da Cafeína");
        assertEquals(1, cafe.getAcumulos(), "Os acúmulos da Cafeína deveriam ter reduzido em 1");
    }
}

