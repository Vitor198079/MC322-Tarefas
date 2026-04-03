import java.util.Scanner;
import java.util.ArrayList;

public class App{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        

        Heroi Silvio_Santos = new Heroi("Silvio Santos", 100, 12);
        
        ArrayList<Inimigo> Inimigos = new ArrayList<>();
        Inimigos.add(new Boleto("Fatura de Cartão", 80, 35));
        Inimigos.add(new Boleto("Boleto Vencido", 100, 20));

        GameManager gerenciador = new GameManager(Silvio_Santos, Inimigos);
        
        Baralho baralho = new Baralho();

        String silvio = Arte.imprimir("src/main/resources/terminal_artstle/Silvio.txt");
        String boleto = Arte.imprimir("src/main/resources/terminal_artstle/Boleto.txt");
        String cartao = Arte.imprimir("src/main/resources/terminal_artstle/Cartao.txt");

        System.out.println(Cores.AMARELO + "===QUE COMECE A BADERNA!===" + Cores.RESET);
        Terminal.pausar(2000);

        while(Silvio_Santos.estaVivo() && Inimigos_estao_vivos(Inimigos)){
            gerenciador.IniciarTurno();
            boolean turno_acontecendo = true;
            baralho.comprarCartas(3);

            while(turno_acontecendo && Inimigos_estao_vivos(Inimigos)){
                Terminal.limparTela();
                System.out.println(Cores.AMARELO + "\n--- SEU TURNO ---" + Cores.RESET);
                System.out.println(Cores.AZUL + silvio + Cores.RESET);
                System.out.println(Cores.AZUL + Silvio_Santos.getNome()+ ": " +  "(" + Silvio_Santos.getVida() + "/100)" + " (" + Silvio_Santos.getEscudo() + " de escudo)" + Cores.RESET);
                System.out.println(Cores.CIANO + "Horas de Sono disponíveis: " + Silvio_Santos.getHorasdeSono() + "/12" + Cores.RESET);
                System.out.println(Cores.VERMELHO + "\nPerrengues à vista:" + Cores.RESET);
                
                for(int i = 0; i < Inimigos.size(); i++){
                    Inimigo in = Inimigos.get(i);
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
                    
                    //Verifica se a carta é de defesa/buff
                    boolean ehCartaDeDefesa = (cartaEscolhida instanceof CartaEscudo) || (cartaEscolhida instanceof CartaCafeina);
                    
                    if (!ehCartaDeDefesa) {
                        //Lógica para cartas de dano e ansiedade
                        if(contaInimigos(Inimigos) > 1){
                            System.out.println("\nQuem você vai alvejar?");
                            for(int i = 0; i < Inimigos.size(); i++){
                                if(Inimigos.get(i).estaVivo()){
                                    System.out.println((i+1) + " - " + Inimigos.get(i).getNome());
                                }
                            }
                            System.out.print(">>> ");
                            int alvoId = teclado.nextInt() - 1;
                            if(alvoId >= 0 && alvoId < Inimigos.size() && Inimigos.get(alvoId).estaVivo()){
                                alvo = Inimigos.get(alvoId);
                            } else {
                                System.out.println("Alvo inválido!");
                                Terminal.pausar(1500);
                            }
                        } else {
                            for(Inimigo in : Inimigos){
                                if(in.estaVivo()){
                                    alvo = in;
                                    break;
                                }
                            }
                        }
                    } else {
                        for(Inimigo in : Inimigos){
                            if(in.estaVivo()){
                                alvo = in;
                                break;
                            }
                        }
                    }
                    
                    if(alvo != null){
                        cartaEscolhida.usar(Silvio_Santos, alvo, gerenciador);
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
            } // Fim Turno do Jogador
            
        //Limpar as cartas que sobraram
        baralho.descartarMaoRestante();
        gerenciador.finalizarTurno();

        if(Inimigos_estao_vivos(Inimigos)){
            System.out.println(Cores.VERMELHO + "\n--- TURNO DOS PERRENGUES ---" + Cores.RESET);
            gerenciador.turno_inimigos();
            Terminal.pausar(3500);
        }
    }
    System.out.println(Cores.AMARELO + "\n=== FIM DA BADERNA ===" + Cores.RESET);
    if(Silvio_Santos.estaVivo()){
        System.out.println(Cores.VERDE + "VITÓRIA! Você venceu o sistema e não vai pro Vasco da Gama!" + Cores.RESET);
    }else{
        System.out.println(Cores.VERMELHO + "DERROTA! O perrengue te derrotou, espere pela contratação do Vasco." + Cores.RESET);
    }

        teclado.close(); 
    }
    
    private static boolean Inimigos_estao_vivos(ArrayList<Inimigo> inimigos){
        for(Inimigo in : inimigos){
            if(in.estaVivo()){
                return true;
            }
        }
        return false;
    }
    
    private static int contaInimigos(ArrayList<Inimigo> inimigos){
        int cont = 0;
        for(Inimigo in : inimigos){
            if(in.estaVivo()){
                cont++;
            }
        }
        return cont;
    }
}