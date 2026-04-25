package jogo;
import entidades.Heroi;
import java.util.Scanner;
import java.util.Random;

/** Representa um evento narrativo no mapa onde o jogador deve tomar uma decisão que afeta seus atributos
 */
public class Escolha extends Evento {
    private String descricao;
    public Escolha(String nome, String descricao){
        super(nome);
        this.descricao = descricao;
    }
    public boolean iniciar(Heroi heroi){
        Scanner teclado = new Scanner(System.in);
        System.out.println(Cores.ROXO + "\n=== EVENTO: " + this.getNome().toUpperCase() + " ===" + Cores.RESET);
        System.out.println(this.descricao);

        
    }
}
