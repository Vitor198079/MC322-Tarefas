package jogo;
import entidades.Heroi;
import cartas.Baralho;
import java.util.Scanner;


public abstract class Fogueira extends Evento {
    protected Baralho baralho;

    public Fogueira(String nome, Baralho baralho){
        super(nome);
        this.baralho = baralho;
    }
    /**
     * Template Method
     * Define o esqueleto do ritual da fogueira.
     */
    public final boolean iniciar(Heroi heroi){
        exibirArteFogueira();
        int escolha = solicitaEscolha();
        executarAcao(escolha, heroi);
        finalizarEvento();
        return true;
    }

    private void exibirArteFogueira(){
        System.out.println(Cores.AMARELO + "\n       ( V )   " + Cores.RESET);
        System.out.println(Cores.AMARELO + "      (  V  )       " + Cores.RESET);
        System.out.println(Cores.VERMELHO + "     [======] " + Cores.RESET);
        System.out.println("Você encontrou uma fogueira improvisada. O calor te traz paz.");
    }
    private int solicitaEscolha(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nO que deseja fazer?");
        System.out.println("1 - Descansar (Recupera 30% da Vida Máxima)");
        System.out.println("2 - Treinar (Melhorar o dano de uma carta em +5%)");
        System.out.println(">>> ");
        return scanner.nextInt();
    }

    protected abstract void executarAcao(int escolha, Heroi heroi);
    private void finalizarEvento(){
        System.out.println("As cinzas esfriam. É hora de voltar a baderna.");
        Terminal.pausar(2500);
    }
}
