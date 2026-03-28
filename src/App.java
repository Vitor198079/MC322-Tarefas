import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class App{
    public static void main(String[] args){
        //recebr informações e declarar os personagens participantes
        Scanner teclado = new Scanner(System.in);
        Heroi Silvio_Santos = new Heroi("Silvio Santos", 100, 24);
        ArrayList<Inimigo> Inimigos = new ArrayList<>();
        Inimigos.add(new Boleto("Fatura de Cartão", 80, 45));
        Inimigos.add(new Boleto("Boleto Vencido", 100, 30));

        GameManager gerenciador = new GameManager(Silvio_Santos, Inimigos);

        ArrayList<Carta> compra = new ArrayList<>();
        ArrayList<Carta> mao = new ArrayList<>();
        ArrayList<Carta> descarte = new ArrayList<>();


         //declarar as cartas de dano e escudo
        compra.add(new CartaDano("Jogar no Paredão", "Coloca o inimigo pra votação popular da casa mais vigiada do Brasil", 3, 8));
        compra.add(new CartaDano("Esqueceu a senha do GOV", "Faz o inimigo perder tempo recuperando a senha do GOV", 2, 5));
        compra.add(new CartaDano("Chuva no Litoral", "Atrapalha todos os planos e deixa tudo um caos", 4, 12));
        compra.add(new CartaDano("Greve de Ônibus", "O inimigo fica preso e perde produtividade", 5, 15));
        compra.add(new CartaDano("Fila do SUS", "Faz o inimigo esperar por horas intermináveis", 6, 18));
        compra.add(new CartaDano("Prova Surpresa", "Pega desprevenido e causa desespero imediato", 3, 10));
        compra.add(new CartaDano("Trânsito na Marginal", "Paralisa completamente o inimigo", 7, 20));
        compra.add(new CartaDano("Internet Caiu", "Interrompe tudo no pior momento possível", 2, 6));
        compra.add(new CartaDano("Calor de 40 Graus", "Drena energia e causa sofrimento", 4, 11));
        compra.add(new CartaDano("Golpe do Pix", "Confunde o inimigo e causa prejuízo", 5, 14));

        compra.add(new CartaEscudo("Atestado Médico", "O famoso migué de não precisar ter que trabalhar por questões de 'saúde'", 1, 8));
        compra.add(new CartaEscudo("Vale Refeição", "Garante energia pra continuar o dia", 2, 10));
        compra.add(new CartaEscudo("Cafezinho", "Recupera um pouco das forças com um clássico brasileiro", 1, 5));
        compra.add(new CartaEscudo("Feriado Prolongado", "Permite descanso extra e recuperação", 5, 20));
        compra.add(new CartaEscudo("13º Salário", "Dá aquele alívio financeiro salvador", 4, 18));
        compra.add(new CartaEscudo("Churrasco de Domingo", "Cervejinha e carne recuperam a vitalidade", 6, 22));
        compra.add(new CartaEscudo("Rede na Varanda", "Descanso garantido e tranquilo", 3, 12));
        compra.add(new CartaEscudo("Pix Recebido", "Recuperação instantânea de ânimo", 2, 9));
        compra.add(new CartaEscudo("Delivery Chegou", "Evita esforço e recupera energia", 2, 8));
        compra.add(new CartaEscudo("Bolsa Família", "Garante uma ajuda essencial nos momentos difíceis", 3, 15));

        compra.add(new CartaAnsiedade("Falar em público", "Aplica 5 de ansiedade no alvo", 2, 5));
        compra.add(new CartaAnsiedade("Mandar DM pra 10/10", "Aplica 8 de ansiedade no alvo", 5, 8));
        compra.add(new CartaCafeina("Café da tarde", "Aplica 5 de cafeína para si mesmo", 1, 3));


        Collections.shuffle(compra);

        //Início da batalha
        System.out.println("===QUE COMECE A BADERNA!===");

        //loop ocorre conforme o herói ainda está vivo
        while(Silvio_Santos.estaVivo() && Inimigos_estao_vivos(Inimigos)){
            gerenciador.IniciarTurno();
            boolean turno_acontecendo = true;

            System.out.println("\n[Comprando cartas...]");
            for(int i = 0; i < 3; i++){
                if(compra.isEmpty()){
                    System.out.println("Acabou o baralho! O estagiário reciclou o lixo...");
                    compra.addAll(descarte);
                    descarte.clear();
                    Collections.shuffle(compra);
                }
                if(!compra.isEmpty()){
                    mao.add(compra.remove(0));
                }
            }
            while(turno_acontecendo && Inimigos_estao_vivos(Inimigos)){
                System.out.println("\n--- SEU TURNO ---");
                System.out.println(Silvio_Santos.getNome()+ ": " +  "(" + Silvio_Santos.getVida() + "/100)" + " (" + Silvio_Santos.getEscudo() + " de escudo)");
                System.out.println("Horas de Sono disponíveis: " + Silvio_Santos.getHorasdeSono() + "/24");
                System.out.println("\nPerregues à vista:");
                for(int i = 0; i < Inimigos.size(); i++){
                    Inimigo in = Inimigos.get(i);
                    if(in.estaVivo()){
                        System.out.println((i+1) + " - " + in.getNome() + " (" + in.getVida() + " pontos de vida");
                    }
                }


                System.out.println("\nEscolha sua gambiarra:");
                int escolha = 1;
                for (Carta c : mao){
                    System.out.println(escolha + " - Usar [" + c.getNome() + "] (Custa " + c.getCusto() + " horas de sono | " + c.getDescricao() + ")");
                    escolha++;
                }
                int escolha_encerrar = escolha;
                System.out.println(escolha_encerrar + " - Encerrar turno (Dormir)");
                System.out.println(">>> ");
                
                int input = teclado.nextInt();
                System.out.println("-------------------------------");
                if (input >= 1 && input < escolha_encerrar) {
                    Carta cartaEscolhida = mao.get(input - 1);
                    Inimigo alvo = null;
                    if(contaInimigos(Inimigos)> 1){
                        System.out.println("\nQuem você quer vai alvejar?");
                        for(int i = 0; i < Inimigos.size(); i++){
                            if(Inimigos.get(i).estaVivo()){
                                System.out.println((i+1) + " - " + Inimigos.get(i).getNome());
                            }
                        }
                        System.out.println(">>> ");
                        int alvoId = teclado.nextInt() - 1;
                        if(alvoId >= 0 && alvoId < Inimigos.size() && Inimigos.get(alvoId).estaVivo()){
                            alvo = Inimigos.get(alvoId);
                        }else{
                            System.out.println("Alvo inválido!");
                        }
                    }else{
                        for(Inimigo in : Inimigos){
                            if(in.estaVivo()){
                                alvo = in;
                            }
                        }
                    }
                    if(alvo != null){
                        cartaEscolhida.usar(Silvio_Santos, alvo, gerenciador);
                        descarte.add(mao.remove(input - 1));
                    }
                }else if(escolha == escolha_encerrar){
                    turno_acontecendo = false;
                }else{
                    System.out.println("Opção inválida!");

                }
                if(mao.isEmpty() && turno_acontecendo){
                    System.out.println("Ficou sem gambiarras! Fim do turno");
                    turno_acontecendo = false;
                }
            }
        if(!mao.isEmpty()){
            descarte.addAll(mao);
            mao.clear();
            System.out.println("Gambiarras que sobraram na sua mão foram descartadas");
        }
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