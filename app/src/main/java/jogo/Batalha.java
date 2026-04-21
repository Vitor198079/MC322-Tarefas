package jogo;

import entidades.Heroi;
import entidades.Inimigo;
import cartas.Carta;
import cartas.CartaEscudo;
import cartas.CartaCafeina;
import cartas.Baralho;
import jogo.Cores;
import jogo.Terminal;
import java.util.Scanner;
import java.util.ArrayList;

public class Batalha{
    private Heroi heroi;
    private ArrayList<Inimigo> inimigos;
    private GameManager gerenciador;
    private Baralho baralho;
    private String silvio;
    private String cartao;
    private String boleto;


    public Batalha(Heroi heroi, ArrayList<Inimigo> inimigos, Baralho baralho, String silvio, String cartao, String boleto){
        this.heroi = heroi;
        this.inimigos = inimigos;
        this.gerenciador = new GameManager(heroi, inimigos);
        this.baralho = baralho;
        this.silvio = silvio;
        this.cartao = cartao;
        this.boleto = boleto;
    }
    public boolean executar(){
        Scanner teclado = new Scanner(System.in);

        while(heroi.estaVivo() && inimigos_estao_vivos(inimigos)){
            gerenciador.IniciarTurno();
            boolean turno_acontecendo = true;
            baralho.comprarCartas(3);

            while(turno_acontecendo && inimigos_estao_vivos(inimigos)){
                System.out.println(Cores.AMARELO + "\n--- SEU TURNO ---" + Cores.RESET);
                System.out.println(Cores.AZUL + silvio + Cores.RESET);
                System.out.println(Cores.AZUL + heroi.getNome()+ ": " +  "(" + heroi.getVida() + "/100)" + " (" + heroi.getEscudo() + " de escudo)" + Cores.RESET);
                System.out.println(Cores.CIANO + "Horas de Sono disponíveis: " + heroi.getHorasdeSono() + "/12" + Cores.RESET);
                System.out.println(Cores.VERMELHO + "\nPerrengues à vista:" + Cores.RESET);
                
                for(int i = 0; i < inimigos.size(); i++){
                    Inimigo in = inimigos.get(i);
                    if(in.estaVivo()){
                        if(in.getNome().equals("Fatura de Cartão")){
                            System.out.println(Cores.VERMELHO + cartao + Cores.RESET);
                        } else if(in.getNome().equals("Boleto Vencido")){
                            System.out.println(Cores.VERMELHO + boleto + Cores.RESET);
                        }
                        System.out.println(Cores.VERMELHO + (i+1) + " - " + in.getNome() + " (" + in.getVida() + " pontos de vida)" + Cores.RESET);
                    }
                }

                System.out.println("\nEscolha sua gambiarra:");
                int escolha = 1;
                for (Carta c : baralho.getMao()){
                    System.out.println(escolha + " - Usar [" + c.getNome() + "] (Custa " + c.getCusto() + " horas de sono | " + c.getDescricao() + ")");
                    escolha++;
                }
                int escolha_encerrar = escolha;
                System.out.println(escolha_encerrar + " - Encerrar turno (Dormir)");
                System.out.print(">>> ");
                
                int input = teclado.nextInt();
                System.out.println("-------------------------------");
                
                if (input >= 1 && input < escolha_encerrar) {
                    Carta cartaEscolhida = baralho.getMao().get(input - 1);
                    Inimigo alvo = null;
                    
                    boolean ehCartaDeDefesa = (cartaEscolhida instanceof CartaEscudo) || (cartaEscolhida instanceof CartaCafeina);
                    
                    if (!ehCartaDeDefesa) {
                        if(containimigos(inimigos) > 1){
                            System.out.println("\nQuem você vai alvejar?");
                            for(int i = 0; i < inimigos.size(); i++){
                                if(inimigos.get(i).estaVivo()){
                                    System.out.println((i+1) + " - " + inimigos.get(i).getNome());
                                }
                            }
                            System.out.print(">>> ");
                            int alvoId = teclado.nextInt() - 1;
                            if(alvoId >= 0 && alvoId < inimigos.size() && inimigos.get(alvoId).estaVivo()){
                                alvo = inimigos.get(alvoId);
                            } else {
                                System.out.println("Alvo inválido!");
                                Terminal.pausar(1500);
                            }
                        } else {
                            for(Inimigo in : inimigos){
                                if(in.estaVivo()){
                                    alvo = in;
                                    break;
                                }
                            }
                        }
                    } else {
                        for(Inimigo in : inimigos){
                            if(in.estaVivo()){
                                alvo = in;
                                break;
                            }
                        }
                    }
                    
                    if(alvo != null){
                        cartaEscolhida.usar(heroi, alvo, gerenciador);
                        baralho.cartaUsadaParaDescarte(input - 1);
                        Terminal.pausar(2500);
                    }
                    
                } else if(input == escolha_encerrar) {
                    turno_acontecendo = false;
                }else{
                    System.out.println("Opção inválida!");
                    Terminal.pausar(1500);
                }
                
                if(baralho.maoEstaVazia() && turno_acontecendo){
                    System.out.println("Ficou sem gambiarras! Fim do turno");
                    Terminal.pausar(2000);
                    turno_acontecendo = false;
                }
            }
            
        baralho.descartarMaoRestante();
        gerenciador.finalizarTurno();

        if(inimigos_estao_vivos(inimigos)){
            System.out.println(Cores.VERMELHO + "\n--- TURNO DOS PERRENGUES ---" + Cores.RESET);
            gerenciador.turno_inimigos();
            Terminal.pausar(3500);
        }
    }
    return heroi.estaVivo();
    }
    /**
     * Verifica se ainda há inimigos vivos.
     */
    private static boolean inimigos_estao_vivos(ArrayList<Inimigo> inimigos){
        for(Inimigo in : inimigos){
            if(in.estaVivo()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Conta quantos inimigos ainda estão vivos.
     */
    private static int containimigos(ArrayList<Inimigo> inimigos){
        int cont = 0;
        for(Inimigo in : inimigos){
            if(in.estaVivo()){
                cont++;
            }
        }
        return cont;
    }
    public void setHeroi(Heroi heroi){
        this.heroi= heroi;
        this.gerenciador = new GameManager(heroi, this.inimigos);
    }
}
