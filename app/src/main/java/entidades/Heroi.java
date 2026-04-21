package entidades;
import padroes.Publisher;
import efeitos.Efeito;
import efeitos.Ansiedade;
/**
 * Representa o protagonista controlado pelo jogador.
 * Gerencia o recurso principal do jogo: as horas de sono, que limitam as ações por turno.
 */
public class Heroi extends Entidade {
    private int horas_de_sono;
    private int max_horas_de_sono;

    /**
     * Cria um novo herói com atributos de vitalidade e descanso.
     * @param nome Nome do personagem brasileiro.
     * @param vida Total de pontos de vida.
     * @param horas_de_sono Capacidade máxima de descanso por turno.
     */
    public Heroi(String nome, int vida, int horas_de_sono){
        super(nome, vida, 0);
        this.horas_de_sono = horas_de_sono;
        this.max_horas_de_sono = horas_de_sono;
    }

    public int getHorasdeSono(){
        return this.horas_de_sono;
    }

    /**
     * Deduz o custo de uma ação do total de descanso disponível.
     * @param custo_horas_de_sono Valor a ser subtraído.
     * @return O saldo atual de horas de sono.
     */
    public int perderHorasdeSono(int custo_horas_de_sono){
        return this.horas_de_sono -= custo_horas_de_sono;
    }

    /**
     * Reseta as horas de sono para o valor máximo no início de cada turno.
     * Também remove qualquer escudo (migué) acumulado anteriormente.
     */
    public void IniciarTurno(){
        this.horas_de_sono = this.max_horas_de_sono;
        if(this.getEscudo() > 0){
            this.setEscudo(0);
            System.out.println("Um novo turno começou! Seu migué anterior acabou e você está sem escudo!");
        }else{
            System.out.println("Um novo turno começou! Suas horas de sono foram restauradas.");
        }
    }
}