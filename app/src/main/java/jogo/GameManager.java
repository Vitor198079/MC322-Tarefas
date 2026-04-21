package jogo;
import padroes.Publisher;
import padroes.Subscriber;
import entidades.Heroi;
import entidades.Inimigo;
import java.util.ArrayList;

/**
 * Orquestrador central do jogo. Gerencia o fluxo de turnos e a 
 * comunicação entre entidades através do padrão Observer (Publisher/Subscriber).
 */
public class GameManager implements Publisher {
    private ArrayList<Subscriber> inscritos;
    private Heroi heroi;
    private ArrayList<Inimigo> inimigos;

    /**
     * Inicializa o gerenciador com os participantes da batalha.
     * @param heroi O jogador.
     * @param inimigos Lista de perrengues a serem enfrentados.
     */
    public GameManager(Heroi heroi, ArrayList<Inimigo> inimigos ){
        this.inscritos = new ArrayList<>();
        this.heroi = heroi;
        this.inimigos = inimigos;
    }

    public void inscrever(Subscriber inscrito){
        if(!this.inscritos.contains(inscrito)){
            this.inscritos.add(inscrito);
        }
    }

    public void desinscrever(Subscriber inscrito){
        this.inscritos.remove(inscrito);
    }
    
    /**
     * Envia uma mensagem para todos os inscritos (efeitos, etc) 
     * sobre uma mudança de estado no jogo.
     * @param evento Identificador do evento ocorrido.
     */
    public void notificar(String evento){
        ArrayList<Subscriber> temp = new ArrayList <>(this.inscritos);
        for(Subscriber ins : temp){
            ins.serNotificado(evento);
        }
    }

    /**
     * Prepara o ambiente e notifica os sistemas para o início do turno do herói.
     */
    public void IniciarTurno(){
        System.out.println("\n================================");
        System.out.println("=== INíCIO DO TURNO DE " + heroi.getNome().toUpperCase() + " ===");
        notificar("INICIO_BADERNA_" + heroi.getNome());
        heroi.IniciarTurno();
    }

    /**
     * Finaliza as ações do jogador e notifica o fim do turno.
     */
    public void finalizarTurno(){
        System.out.println("\n================================");
        System.out.println("=== FIM DO TURNO DE " + heroi.getNome().toUpperCase() + " ===");
        notificar("FIM_BADERNA_" + heroi.getNome());
    }

    /**
     * Executa a lógica de ataque de todos os inimigos vivos.
     */
    public void turno_inimigos(){
        System.out.println("\n================================");
        System.out.println("=== TURNO DOS PERRENGUES ===");

        for(Inimigo inimigo : inimigos){
            if(inimigo.estaVivo()){
                System.out.println("\n Vez de " + inimigo.getNome());
                notificar("INICIO_BADERNA_" + inimigo.getNome());

                inimigo.atacar(heroi, this);
                notificar("FIM_BADERNA_" + inimigo.getNome());
            }
        }
    }
}