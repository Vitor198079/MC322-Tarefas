package jogo;
import java.util.ArrayList;
/**
* Representa um local no mapa do jogo (nó da árvore).
 */
public class NoMapa {
    private String local;
    private Batalha batalha;
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
    public Batalha getBatalha(){
        return this.batalha;
    }
    public boolean ehfimdomapa(){
        return this.caminhos.isEmpty();
    }
}
