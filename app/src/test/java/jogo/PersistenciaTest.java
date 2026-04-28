package jogo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.File;

public class PersistenciaTest {

    @Test
    public void testRoundTripPersistencia() {
        GerenciadorJogo gj = new GerenciadorJogo();
        ArrayList<String> cartasTeste = new ArrayList<>();
        cartasTeste.add("Café da tarde");
        cartasTeste.add("Bolsa Família");

        EstadoJogo estadoOriginal = new EstadoJogo(85, 10, "Vila dos Dinossauros - Acre", cartasTeste, 0);


        gj.salvar(estadoOriginal);
        File arquivoSave = new File("save.json");
        assertTrue(arquivoSave.exists(), "O arquivo save.json deveria ter sido criado.");
        EstadoJogo estadoCarregado = gj.carregar();
        assertNotNull(estadoCarregado, "O estado carregado não deveria ser nulo.");
        assertEquals(85, estadoCarregado.vida, "A vida carregada deve ser 85.");
        assertEquals(10, estadoCarregado.horasDeSono, "As horas de sono devem ser 10.");
        assertEquals("Vila dos Dinossauros - Acre", estadoCarregado.localAtual, "O local deve ser o Acre.");
        assertEquals(2, estadoCarregado.nomescartasMao.size(), "A mão deve conter 2 cartas.");
        assertEquals("Café da tarde", estadoCarregado.nomescartasMao.get(0));
    }
}
