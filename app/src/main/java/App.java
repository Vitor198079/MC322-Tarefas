import entidades.*;
import cartas.*;
import jogo.*;
import java.util.ArrayList;

/**
 * Classe principal responsável por executar o jogo e controlar o fluxo geral
 * da partida, incluindo turnos do jogador e dos inimigos.
 */
public class App{
    /**
     * Ponto de entrada do programa. Inicializa os elementos do jogo e executa o loop principal.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args){
        
        Heroi Silvio_Santos = new Heroi("Silvio Santos", 100, 12);
        
        ArrayList<Inimigo> Inimigos = new ArrayList<>();
        Inimigos.add(new Boleto("Fatura de Cartão", 80, 35));
        Inimigos.add(new Boleto("Boleto Vencido", 100, 20));
        
        Baralho baralho = new Baralho();

        String silvio = Arte.imprimir("src/main/resources/terminal_artstle/Silvio.txt");
        String boleto = Arte.imprimir("src/main/resources/terminal_artstle/Boleto.txt");
        String cartao = Arte.imprimir("src/main/resources/terminal_artstle/Cartao.txt");

        System.out.println(Cores.AMARELO + "===QUE COMECE A BADERNA!===" + Cores.RESET);
        Terminal.pausar(2000);

        Batalha batalha = new Batalha(Silvio_Santos, Inimigos, baralho, silvio, cartao, boleto);
        boolean sobreviveu = batalha.executar();
    System.out.println(Cores.AMARELO + "\n=== FIM DA BADERNA ===" + Cores.RESET);
    if(sobreviveu){
        System.out.println(Cores.VERDE + "VITÓRIA! Você venceu o sistema e não vai pro Vasco da Gama!" + Cores.RESET);
        System.out.println("Preparando para avançar no mapa e subir a régua...");
        }else{
        System.out.println(Cores.VERMELHO + "DERROTA! O perrengue te derrotou, espere pela contratação do Vasco." + Cores.RESET);
    }

    }
    
}