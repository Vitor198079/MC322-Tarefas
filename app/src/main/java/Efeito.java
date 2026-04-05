/**
 * Classe abstrata que representa modificadores de status (buffs ou debuffs).
 * Implementa o padrão Subscriber para reagir a eventos globais do jogo.
 */
public abstract class Efeito implements Subscriber {
    private String nome;
    private Entidade dono;
    private int acumulos;

    /**
     * Construtor de um efeito.
     * @param nome Nome do status (ex: Cafeína, Ansiedade).
     * @param dono A entidade que está sofrendo/usufruindo do efeito.
     * @param acumulos A intensidade inicial do efeito.
     */
    public Efeito(String nome, Entidade dono, int acumulos){
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;
    }

    /**
     * Retorna uma representação visual do efeito e seus acúmulos.
     */
    public String getString(){
        return this.nome + " (" + this.acumulos + ")";
    }

    public String getNome(){
        return this.nome;
    }

    public Entidade getDono(){
        return this.dono;
    }

    public int getAcumulos(){
        return this.acumulos;
    }

    public void setAcumulos(int acumulos){
        this.acumulos = acumulos;
    }

    public void adicionarAcumulos(int valor){
        this.acumulos += valor;
    }

    /**
     * Método obrigatório da interface Subscriber para processar mudanças de estado no jogo.
     */
    public abstract void serNotificado(String evento);
    
}