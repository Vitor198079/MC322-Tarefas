import entidades.*;
import cartas.*;
import jogo.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
        GerenciadorJogo gj = new GerenciadorJogo();
        EstadoJogo save = null;
        System.out.println("================================");
        System.out.println("       HUEHUE BR! Duel Games!    ");
        System.out.println("================================");
        System.out.println("1 - Novo Jogo");
        System.out.println("2 - Continuar Jogo Anterior");
        System.out.print("Escolha uma opção: ");

        int opcao = teclado.nextInt();
        teclado.nextLine();

        if (opcao == 2) {
            save = gj.carregar();
            if (save == null) {
                System.out.println("Nenhum save encontrado! Iniciando novo jogo...");
            } else {
                System.out.println("Carregando progresso de: " + save.localAtual);
            }
        } else {
            gj.deletarSave();
            save = null;
            System.out.println("Iniciando uma nova jornada!");
        }

        Heroi Silvio_Santos;
        Baralho baralho = new Baralho();
        NoMapa inicio;
        NoMapa atual;
        String silvio = Arte.imprimir("src/main/resources/terminal_artstle/Silvio.txt");
        String boleto = Arte.imprimir("src/main/resources/terminal_artstle/Boleto.txt");
        String cartao = Arte.imprimir("src/main/resources/terminal_artstle/Cartao.txt");

        
        ArrayList<Inimigo> Inimigos = new ArrayList<>();
        Inimigos.add(new Boleto("Fatura de Cartão", 80, 35));
        Inimigos.add(new Boleto("Boleto Vencido", 100, 20));
        

        ArrayList<Inimigo> inimigosno1 = new ArrayList<>();
        inimigosno1.add(new Boleto("Boleto Vencido (Nível 1)", 50, 15));
        Batalha batalha1 = new Batalha("Batalha do Nubank", null, inimigosno1, baralho, silvio, cartao, boleto);
        inicio = new NoMapa("Guarujá", batalha1);

        ArrayList<Inimigo> inimigosno2 = new ArrayList<>();
        inimigosno2.add(new Boleto("Fatura de Cartão (Nível 1)", 80, 25));
        Batalha batalha2 = new Batalha("Batalha do CLT", null, inimigosno2, baralho, silvio, cartao, boleto);
        NoMapa Acre = new NoMapa("Vila dos Dinossauros - Acre", batalha2);

        ArrayList<Inimigo> inimigosno3 = new ArrayList<>();
        inimigosno3.add(new Boleto("Boleto Vencido(Nível 3)", 80, 20));
        inimigosno3.add(new Boleto("Fatura de Cartão (Nível 2)", 100, 30));
        Batalha batalha3 = new Batalha("Batalha do 6x1", null, inimigosno3, baralho, silvio, cartao, boleto);
        NoMapa Taubate = new NoMapa("Taubaté - SP", batalha3);

        Fogueira fogueira = new FogueiraOpcoes("Fogueira do Silvio", baralho);
        NoMapa descanso = new NoMapa("Área do Descanso", fogueira);
        Escolha evento = new Escolha("Perigo, do Todo Mundo Odeia o Chris", "No meio do caminho, um sujeito negro de óculos escuros que usava crocs te aborda.\n" + "'Aí, chefe! Tenho uns esquemas bons aqui pra curar esse seu cansaço. Vai encarar?'");
        NoMapa vinte_cinco_marco = new NoMapa("25 de Março", evento);
        Loja loja = new Loja("Baú do Silvio", baralho);
        NoMapa noLoja = new NoMapa("Camelódromo da Loja", loja);
        inicio.adiciona_caminho(vinte_cinco_marco);
        vinte_cinco_marco.adiciona_caminho(noLoja);
        vinte_cinco_marco.adiciona_caminho(descanso);
        descanso.adiciona_caminho(Acre);
        descanso.adiciona_caminho(Taubate);
        Taubate.adiciona_caminho(descanso);
        Taubate.adiciona_caminho(Acre);

        atual = inicio;
        if (save != null) {
            System.out.println(Cores.VERDE + "Carregando baderna anterior de " + save.localAtual + "..." + Cores.RESET);
            Silvio_Santos = new Heroi("Silvio Santos", save.vida, save.horasDeSono);
            Silvio_Santos.setOuro(save.ouro);
            if (save.nomescartasMao != null) {
                for (String nomeCarta : save.nomescartasMao) {
                    baralho.adicionaCarta(criarCartaPeloNome(nomeCarta));
                }
            }     
            atual = buscarNoPeloNome(save.localAtual, inicio);
            if (atual == null) {
                System.out.println("Local salvo não encontrado. Reiniciando do Guarujá.");
                atual = inicio;
            }
        } else {
            Silvio_Santos = new Heroi("Silvio Santos", 100, 12);
            atual = inicio;
        }
        boolean jogo = true;
        while(jogo && atual != null){
            Terminal.limparTela();
            System.out.println(Cores.CIANO + ">>> VOCÊ CHEGOU EM: " + atual.getlocal() + " <<<" + Cores.RESET);
            Terminal.pausar(1500);

            boolean sobreviveu = atual.getEvento().iniciar(Silvio_Santos);

            if (!sobreviveu) {
                System.out.println(Cores.VERMELHO + "\nDERROTA! O sistema te venceu. Espere pela contratação do Vasco." + Cores.RESET);
                jogo = false;
            } else {
                System.out.println(Cores.VERDE + "\nVITÓRIA!" + Cores.RESET);
                Terminal.pausar(2000);

                
                Silvio_Santos.setHorasdeSono(12);

                if (atual.ehfimdomapa()) {
                    System.out.println(Cores.AMARELO + "\nPARABÉNS! VOCÊ SOBREVIVEU AO MAPA E VENCEU A BADERNA" + Cores.RESET);
                    jogo = false;
                } else {
                    System.out.println("\nEscolha sua traquinagem");
                    System.out.println("0 - Salvar e sair");
                    ArrayList<NoMapa> opcoes = atual.getCaminhos();
                    
                    for (int i = 0; i < opcoes.size(); i++) {
                        System.out.println((i + 1) + " - Ir para " + opcoes.get(i).getlocal());
                    }
                    System.out.print(">>> ");
                    
                    int escolha = teclado.nextInt();
                    if(escolha == 0){
                        ArrayList<String> nomesCartas = new ArrayList<>();
                        for(Carta c : baralho.getMao()){
                            nomesCartas.add(c.getNome());
                        }
                    
                        // Cria o objeto e salva
                        EstadoJogo estado = new EstadoJogo(
                            Silvio_Santos.getVida(), 
                            Silvio_Santos.getHorasdeSono(), 
                            atual.getlocal(), 
                            nomesCartas,
                            Silvio_Santos.getOuro()
                        );
                        gj.salvar(estado);
                    
                        System.out.println("Progresso guardado. Até a próxima baderna!");
                        jogo = false;
                    }
                    else if (escolha >= 1 && escolha <= opcoes.size()) {
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
/**
     * Método auxiliar para buscar um nó no mapa pelo nome (Busca em Largura).
     */
    private static NoMapa buscarNoPeloNome(String nome, NoMapa raiz) {
        if (raiz == null) return null;
        
        Queue<NoMapa> fila = new LinkedList<>();
        ArrayList<NoMapa> visitados = new ArrayList<>();
        
        fila.add(raiz);
        while (!fila.isEmpty()) {
            NoMapa atual = fila.poll();
            if (atual.getlocal().equals(nome)) return atual;
            
            visitados.add(atual);
            for (NoMapa filho : atual.getCaminhos()) {
                if (!visitados.contains(filho)) {
                    fila.add(filho);
                }
            }
        }
        return null;
    }
    /**
     * Recupera os atributos originais (dano, escudo, custo, descricao) de uma carta pelo nome.
     */
    private static Carta criarCartaPeloNome(String nome) {
        switch (nome) {
            // ================= CARTAS DE DANO =================
            case "Jogar no Paredão": return new CartaDano("Jogar no Paredão", "Coloca o inimigo pra votação popular da casa", 3, 30);
            case "Esqueceu a senha do GOV": return new CartaDano("Esqueceu a senha do GOV", "Faz o inimigo perder tempo recuperando a senha", 2, 45);
            case "Chuva no Litoral": return new CartaDano("Chuva no Litoral", "Atrapalha todos os planos e deixa tudo um caos", 4, 30);
            case "Greve de Ônibus": return new CartaDano("Greve de Ônibus", "O inimigo fica preso e perde produtividade", 5, 30);
            case "Fila do SUS": return new CartaDano("Fila do SUS", "Faz o inimigo esperar por horas intermináveis", 6, 25);
            case "Prova Surpresa": return new CartaDano("Prova Surpresa", "Pega desprevenido e causa desespero imediato", 3, 35);
            case "Trânsito na Marginal": return new CartaDano("Trânsito na Marginal", "Paralisa completamente o inimigo", 7, 40);
            case "Internet Caiu": return new CartaDano("Internet Caiu", "Interrompe tudo no pior momento possível", 2, 25);
            case "Calor de 40 Graus": return new CartaDano("Calor de 40 Graus", "Drena energia e causa sofrimento", 4, 25);
            case "Golpe do Pix": return new CartaDano("Golpe do Pix", "Confunde o inimigo e causa prejuízo", 5, 50);
            case "RunTimeError": return new CartaDano("RunTimeError", "Causa 40 de dano e faz você ficar insano", 8, 40);
            
            // ================= CARTAS DE ESCUDO =================
            case "Atestado Médico": return new CartaEscudo("Atestado Médico", "O famoso migué de não trabalhar por 'saúde'", 1, 8);
            case "Vale Refeição": return new CartaEscudo("Vale Refeição", "Garante energia pra continuar o dia", 2, 10);
            case "Cafezinho": return new CartaEscudo("Cafezinho", "Recupera forças com um clássico brasileiro", 1, 5);
            case "Feriado Prolongado": return new CartaEscudo("Feriado Prolongado", "Permite descanso extra e recuperação", 5, 20);
            case "13º Salário": return new CartaEscudo("13º Salário", "Dá aquele alívio financeiro salvador", 4, 18);
            case "Churrasco de Domingo": return new CartaEscudo("Churrasco de Domingo", "Cervejinha e carne recuperam a vitalidade", 6, 22);
            case "Rede na Varanda": return new CartaEscudo("Rede na Varanda", "Descanso garantido e tranquilo", 3, 12);
            case "Pix Recebido": return new CartaEscudo("Pix Recebido", "Recuperação instantânea de ânimo", 2, 9);
            case "Delivery Chegou": return new CartaEscudo("Delivery Chegou", "Evita esforço e recupera energia", 2, 8);
            case "Bolsa Família": return new CartaEscudo("Bolsa Família", "Garante ajuda essencial nos momentos difíceis", 3, 15);
            case "Fone com Cancelamento de Ruído": return new CartaEscudo("Fone com Cancelamento de Ruído", "Ignora o mundo externo e ganha 20 de escudo", 3, 20);
            
            // ================= CARTAS DE EFEITO (Ansiedade / Cafeína) =================
            case "Falar em público": return new CartaAnsiedade("Falar em público", "Aplica 5 de ansiedade no alvo", 2, 5);
            case "Mandar DM pra mina 10/10": return new CartaAnsiedade("Mandar DM pra mina 10/10", "Aplica 8 de ansiedade no alvo", 5, 8);
            case "Reunião com o chefe": return new CartaAnsiedade("Reunião com o chefe", "Aplica 4 de ansiedade no alvo", 2, 4);
            case "Café da tarde": return new CartaCafeina("Café da tarde", "Aplica 5 de cafeína para si mesmo", 1, 3);
            case "Energético da Shopee": return new CartaCafeina("Energético da Shopee", "Aplica 5 de Cafeína em si mesmo", 1, 5);
            
            // ================= CARTA HÍBRIDA =================
            case "Expor no Twitter/X": return new CartaHibrida("Expor no Twitter/X", "Causa 12 de dano e aplica 5 de Ansiedade", 3, 12, 5);
            default:
                return null;
        }
    }
}