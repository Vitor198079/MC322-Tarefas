package entidades;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoletoTest {
    @Test
    public void testCriacaoBoleto() {
        Boleto boleto = new Boleto("Boleto Vencido", 100, 20);
        
        assertEquals("Boleto Vencido", boleto.getNome(), "O nome do inimigo deve estar correto");
        assertEquals(100, boleto.getVida(), "A vida inicial deve ser 100");
        assertTrue(boleto.estaVivo(), "O boleto recém-criado deve estar vivo");
    }

    @Test
    public void testBoletoRecebeDano() {
        Boleto boleto = new Boleto("Boleto Vencido", 100, 20);
        boleto.receberDano(30);
        
        assertEquals(70, boleto.getVida(), "A vida do boleto deve cair para 70 após receber 30 de dano");
    }
}

