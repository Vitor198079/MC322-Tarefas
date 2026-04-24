package jogo;
import java.util.ArrayList;

/**
 * DTO (Data Transfer Object) para serialização do estado do jogo.
 * Contém apenas os dados que precisam ser guardados no save.json.
 */
public class EstadoJogo {
    public int vida;
    public int horasDeSono;
    public String localAtual;
    // Guardamos apenas os nomes das cartas ou IDs para simplificar
    public ArrayList<String> nomescartasMao; 
    public int ouro;

    public EstadoJogo(int vida, int horasDeSono, String localAtual, ArrayList<String> nomescartas, int ouroganho) {
        this.vida = vida;
        this.horasDeSono = horasDeSono;
        this.localAtual = localAtual;
        this.nomescartasMao = nomescartas;
        this.ouro = ouroganho;
    }
}
