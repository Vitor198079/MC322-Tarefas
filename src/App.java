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

        System.out.println("===QUE COMECE A BADERNA!===");

        while(Silvio_Santos.estaVivo() && Inimigos_estao_vivos(Inimigos)){
            gerenciador.IniciarTurno();
            boolean turno_acontecendo = true;
            baralho.comprarCartas(3);

            while(turno_acontecendo && Inimigos_estao_vivos(Inimigos)){
                System.out.println("\n--- SEU TURNO ---");
                System.out.println(Silvio_Santos.getNome()+ ": " +  "(" + Silvio_Santos.getVida() + "/100)" + " (" + Silvio_Santos.getEscudo() + " de escudo)");
                System.out.println("Horas de Sono disponíveis: " + Silvio_Santos.getHorasdeSono() + "/12");
                System.out.println("\nPerrengues à vista:");
                
                for(int i = 0; i < Inimigos.size(); i++){
                    Inimigo in = Inimigos.get(i);
                    if(in.estaVivo()){
                        System.out.println((i+1) + " - " + in.getNome() + " (" + in.getVida() + " pontos de vida)");
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
                    }
                    
                } else if(input == escolha_encerrar) {
                    turno_acontecendo = false;
                }else{
                    System.out.println("Opção inválida!");
                }
                
                if(baralho.maoEstaVazia() && turno_acontecendo){
                    System.out.println("Ficou sem gambiarras! Fim do turno");
                    turno_acontecendo = false;
                }
            } // Fim Turno do Jogador
            
        //Limpar as cartas que sobraram
        baralho.descartarMaoRestante();
        gerenciador.finalizarTurno();

        if(Inimigos_estao_vivos(Inimigos)){
            gerenciador.turno_inimigos();
        }
    }
    System.out.println("\n=== FIM DA BADERNA ===");
    if(Silvio_Santos.estaVivo()){
        System.out.println("VITÓRIA! Você venceu o sistema e não vai pro Vasco da Gama!");
    }else{
        System.out.println("DERROTA! O perrengue te derrotou, espere pela contratação do Vasco.");
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