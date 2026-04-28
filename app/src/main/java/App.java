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
        EstadoJogo save = gj.carregar();
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
        Batalha batalha1 = new Batalha("Batalha do Nubank", Silvio_Santos, inimigosno1, baralho, silvio, cartao, boleto);
        inicio = new NoMapa("Guarujá", batalha1);

        ArrayList<Inimigo> inimigosno2 = new ArrayList<>();
        inimigosno2.add(new Boleto("Fatura de Cartão (Nível 1)", 80, 25));
        Batalha batalha2 = new Batalha("Batalha do CLT", Silvio_Santos, inimigosno2, baralho, silvio, cartao, boleto);
        NoMapa Acre = new NoMapa("Vila dos Dinossauros - Acre", batalha2);

        ArrayList<Inimigo> inimigosno3 = new ArrayList<>();
        inimigosno3.add(new Boleto("Boleto Vencido(Nível 3)", 80, 20));
        inimigosno3.add(new Boleto("Fatura de Cartão (Nível 2)", 100, 30));
        Batalha batalha3 = new Batalha("Batalha do 6x1", Silvio_Santos, inimigosno3, baralho, silvio, cartao, boleto);
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
        descanso.adiciona_caminho(Acre);
        descanso.adiciona_caminho(Taubate);
        atual = inicio;
        if (save != null) {
            System.out.println(Cores.VERDE + "Carregando baderna anterior de " + save.localAtual + "..." + Cores.RESET);
            Silvio_Santos = new Heroi("Silvio Santos", save.vida, save.horasDeSono);
            Silvio_Santos.setOuro(save.ouro);
            
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
                            Silvio_Santos.getOuro() + "",
                            atual.getlocal(), 
                            nomesCartas
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
}