package jogo;
import java.util.ArrayList;
/**
* Representa um local no mapa do jogo (nó da árvore).
 */
public class NoMapa {
    private String local;
    private Evento evento;
    private ArrayList<NoMapa> caminhos;

    public NoMapa(String local, Batalha batalha){
        this.local = local;
        this.batalha = batalha;
        this.caminhos = new ArrayList<>();
    }
    public void adiciona_caminho(NoMapa proximo){
        this.caminhos.add(proximo);
    }
    public ArrayList<NoMapa> getCaminhos(){
        return this.caminhos;
    }
    public String getlocal(){
        return this.local;
    }
    public Batalha getEvento(){
        return this.evento;
    }
    public boolean ehfimdomapa(){
        return this.caminhos.isEmpty();
    }
}
