import entidades.*;
import cartas.*;
import jogo.*;

import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner teclado = new Scanner(System.in);
        Heroi Silvio_Santos = new Heroi("Silvio Santos", 100, 12);

        
        ArrayList<Inimigo> Inimigos = new ArrayList<>();
        Inimigos.add(new Boleto("Fatura de Cartão", 80, 35));
        Inimigos.add(new Boleto("Boleto Vencido", 100, 20));
        
        Baralho baralho = new Baralho();
        String silvio = Arte.imprimir("src/main/resources/terminal_artstle/Silvio.txt");
        String boleto = Arte.imprimir("src/main/resources/terminal_artstle/Boleto.txt");
        String cartao = Arte.imprimir("src/main/resources/terminal_artstle/Cartao.txt");

        ArrayList<Inimigo> inimigosno1 = new ArrayList<>();
        inimigosno1.add(new Boleto("Boleto Vencido (Nível 1)", 50, 15));
        Batalha batalha1 = new Batalha(Silvio_Santos, inimigosno1, baralho, silvio, cartao, boleto);
        NoMapa inicio = new NoMapa("Guarujá", batalha1);

        ArrayList<Inimigo> inimigosno2 = new ArrayList<>();
        inimigosno2.add(new Boleto("Fatura de Cartão (Nível 1)", 80, 25));
        Batalha batalha2 = new Batalha(Silvio_Santos, inimigosno2, baralho, silvio, cartao, boleto);
        NoMapa Acre = new NoMapa("Vila dos Dinossauros - Acre", batalha2);

        ArrayList<Inimigo> inimigosno3 = new ArrayList<>();
        inimigosno3.add(new Boleto("Boleto Vencido(Nível 3)", 80, 20));
        inimigosno3.add(new Boleto("Fatura de Cartão (Nível 2)", 100, 30));
        Batalha batalha3 = new Batalha(Silvio_Santos, inimigosno3, baralho, silvio, cartao, boleto);
        NoMapa Taubate = new NoMapa("Taubaté - SP", batalha3);

        inicio.adiciona_caminho(Acre);
        inicio.adiciona_caminho(Taubate);
        NoMapa atual = inicio;
        boolean jogo = true;
        while(jogo && atual != null){
            Terminal.limparTela();
            System.out.println(Cores.CIANO + ">>> VOCÊ CHEGOU EM: " + atual.getlocal() + " <<<" + Cores.RESET);
            Terminal.pausar(2000);

            boolean sobreviveu = atual.getBatalha().executar();

            if (!sobreviveu) {
                System.out.println(Cores.VERMELHO + "\nDERROTA! O sistema te venceu. Espere pela contratação do Vasco." + Cores.RESET);
                jogo = false;
            } else {
                System.out.println(Cores.VERDE + "\nVITÓRIA NESTE PERRENGUE!" + Cores.RESET);
                Terminal.pausar(2000);

                
                Silvio_Santos.setHorasdeSono(12);

                if (atual.ehfimdomapa()) {
                    System.out.println(Cores.AMARELO + "\nPARABÉNS! VOCÊ SOBREVIVEU AO MAPA E VENCEU A BADERNA" + Cores.RESET);
                    jogo = false;
                } else {
                    System.out.println("\nPara onde você quer ir agora?");
                    ArrayList<NoMapa> opcoes = atual.getCaminhos();
                    
                    for (int i = 0; i < opcoes.size(); i++) {
                        System.out.println((i + 1) + " - Ir para " + opcoes.get(i).getlocal());
                    }
                    System.out.print(">>> ");
                    
                    int escolha = teclado.nextInt();
                    
                    if (escolha >= 1 && escolha <= opcoes.size()) {
                        atual = opcoes.get(escolha - 1);
                    } else {
                        System.out.println("Você se perdeu... E acabou indo para a opção 1 por acidente.");
                        atual = opcoes.get(0);
                        Terminal.pausar(2000);
                    }
                }
            }
        }

        teclado.close();
    }
}