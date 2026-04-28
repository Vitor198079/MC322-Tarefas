package jogo;
import entidades.Entidade;
import entidades.Heroi;
/**
 * Classe que define os acontecimentos do mapa durante o jogo (Batalhas, Lojas, Escolhas...)
 */
public abstract class Evento {
    private String nome;

    public Evento(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    /**
     * Inicia a execução do evento.
     * @param heroi O jogador, para que o evento modifique seu estado atual.
     * @return true se o herói sobreviveu ao evento, caso contrário false.
     */
    public abstract boolean iniciar(Heroi heroi);
}
