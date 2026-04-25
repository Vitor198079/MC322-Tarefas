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

        System.out.println("\nO que você faz?");
        System.out.println("1 - Aceitar caneta azul do Manoel Gomes (Recupera 30 de vida, mas perde 20 de Ouro)");
        System.out.println("2 - Trabalhar na escala 6x1 (Ganha 40 de Ouro, mas perde 15 de Vida pelo cansaço)");
        System.out.println("3 - Ignorar e seguir em frente (Nada acontece)");
        System.out.println(">>> ");

        int opcao = teclado.nextInt();
        System.out.println("-------------------------------------");

        switch (opcao){
            case 1:
                if(heroi.getOuro() >= 20){
                    System.out.println("Você pega a caneta. Recebe uma aura imediata de poder que o faz ouvir repetidamente 'Caneta Azul, Azul Caneta...tá marcada com minha letra'.");
                    heroi.setVida(heroi.getVida() + 30);
                    if(heroi.getVida() > 100) heroi.setVida(100);
                    heroi.adicionarOuro(-20);
                }else{
                    System.out.println("Você não tem ouro suficiente. O vendedor ri da sua cara e você vai embora triste.");
                }
                break;
            case 2:
                System.out.println("O sol estava rachando! Você ganhou um trocado, mas quase desmaiou.");
                heroi.adicionarOuro(40);
                heroi.receberDano(15);
                break;
            case 3:
                System.out.println("Você abaixa a cabeça, finge que tá no celular e passa direto.");
                break;
            default:
                System.out.println("Você demorou tanto pra responder que a oportunidade passou.");
                break;
        }
        Terminal.pausar(3000);
        return heroi.estaVivo();
    }
}
