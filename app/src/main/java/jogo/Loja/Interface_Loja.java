package jogo;
import entidades.Heroi;
import cartas.Baralho;

public interface Interface_Loja {
    /**
     * Executa a ação específica do item comprado.
     * @return true se a compra foi bem-sucedida.
     */
    boolean aplicar(Heroi heroi, Baralho baralho);
    String getDescricao();  
}
