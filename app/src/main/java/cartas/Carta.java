package cartas;
import entidades.Heroi;
import entidades.Inimigo;
import padroes.Publisher;
import efeitos.Ansiedade;
import efeitos.Cafeina;

/**
 * Classe abstrata que define a estrutura base de uma carta no jogo.
 * Representa uma ação que o jogador pode realizar, consumindo horas de sono como recurso.
 */
public abstract class Carta {
    private String nome;
    private String descricao;
    private int custo_horas_de_sono;

    /**
     * Construtor base para uma carta.
     * @param nome Título da carta.
     * @param descricao Texto explicativo do efeito.
     * @param custo Quantidade de horas de sono necessárias para o uso.
     */
    public Carta(String nome, String descricao, int custo){
        this.nome = nome;
        this.descricao = descricao;
        this.custo_horas_de_sono = custo;
    }

    /**
     * Define o comportamento específico da carta ao ser jogada.
     * @param heroi O protagonista que utiliza a carta.
     * @param inimigo O alvo do efeito da carta.
     * @param publisher O gerenciador de eventos para registro de novos efeitos.
     */
    public abstract void usar(Heroi heroi, Inimigo inimigo, Publisher publisher);

    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getCusto(){
        return this.custo_horas_de_sono;
    }
}