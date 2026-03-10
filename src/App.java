import java.util.Scanner;
public class App{
    public static void main(String[] args){
        //recebr informações e declarar os personagens participantes
        Scanner teclado = new Scanner(System.in);
        Heroi Silvio_Santos = new Heroi("Silvio Santos", 100, 24);
        Inimigo boleto_vencido = new Inimigo("Boleto Vencido", 100);

         //declarar as cartas de dano e escudo
        CartaDano Jogar_no_Paredao = new CartaDano("Jogar no Paredão", 3, 8);
        CartaEscudo atestado_medico = new CartaEscudo("Atestado Médico", 1, 8);

        //Início da batalha
        System.out.println("===QUE COMECE A BADERNA!===");
        System.out.println("O " + boleto_vencido.GetNome() + " apareceu para cortar seu barato!");
        System.out.println("-------------------------");

        //loop ocorre conforme o herói ainda está vivo
        while(Silvio_Santos.estaVivo() && boleto_vencido.estaVivo()){
            Silvio_Santos.IniciarTurno();
            boolean turno_acontecendo = true;

            //loop que ocorre conforme o inimigo ainda está vivo
            while(turno_acontecendo && boleto_vencido.estaVivo()){
                System.out.println("\n--- SEU TURNO ---");
                System.out.println(Silvio_Santos.GetNome()+ ": " +  "(" + Silvio_Santos.GetVida() + "/100)" + " (" + Silvio_Santos.getEscudo() + " de escudo)");
                System.out.println("vs.");
                System.out.println(boleto_vencido.GetNome() + ": " + "(" + boleto_vencido.getVida() + "/100)" + " (" + boleto_vencido.getEscudo() + " de escudo)");
                System.out.println("Horas de Sono disponíveis: " + Silvio_Santos.getHorasdeSono() + "/24");
                System.out.println("1 - Usar [" + Jogar_no_Paredao.getNome() + "] (Custa 3 horas de sono | Dano: 8)");
                System.out.println("2 - Usar[" + atestado_medico.getNome() + "] (Custa 1 hora de sono | Escudo: 8)");
                System.out.println("3 - Encerrar turno (Dormir)");
                System.out.println("Escolha seu movimento frio e calculista: ");
                
                int input = teclado.nextInt();

                if (input == 1) {
                    System.out.println("-------------------------------");
                    if (Silvio_Santos.getHorasdeSono() >= Jogar_no_Paredao.getCusto()) {
                        Silvio_Santos.atacar(Jogar_no_Paredao, boleto_vencido, Silvio_Santos);
                    } else {
                        System.out.println("Você tá muito cansado para jogar alguém no paredão agora! Durma mais!");
                    }
                    System.out.println("-------------------------------");
                } 
                else if (input == 2) {
                    System.out.println("-------------------------------");
                    if (Silvio_Santos.getHorasdeSono() >= atestado_medico.getCusto()) {
                        atestado_medico.usar(Silvio_Santos);
                    } else {
                        System.out.println("Você não tem energia nem pra dar um migué!");
                    }
                    System.out.println("-------------------------------");
                } 
                else if (input == 3) {
                    System.out.println("-------------------------------");
                    System.out.println("Você encerrou o seu turno.");
                    turno_acontecendo = false;
                    System.out.println("-------------------------------");
                } 
                else {
                    System.out.println("-------------------------------");
                    System.out.println("Opção inválida! A ansiedade bateu!, digite 1, 2 ou 3.");
                    System.out.println("-------------------------------");
                }

                if (!boleto_vencido.estaVivo()) {
                    break;
                }
            }

            //verificar se o inimigo ainda está vivo
            if (boleto_vencido.estaVivo()) {
                System.out.println("\n--- TURNO DO PERRENGUE ---");
                CartaDano ataqueInimigo = new CartaDano("Juros Abusivos", 0, 20);
                boleto_vencido.atacar(ataqueInimigo, Silvio_Santos);
                System.out.println("-------------------------------");
            }
        }

        //declara o fim da batalha
        System.out.println("\n=== FIM DA BADERNA ===");
        if (Silvio_Santos.estaVivo()) {
            System.out.println("VITÓRIA! Você venceu o sistema e não vai pro Vasco da Gama");
        } else {
            System.out.println("DERROTA! O perrengue te derrotou, espere pela contratação do Vasco");
        }

        teclado.close(); 
    }
}