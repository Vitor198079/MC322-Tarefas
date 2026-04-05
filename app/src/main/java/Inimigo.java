/**
 * Classe base abstrata para os oponentes (perrengues) do jogo.
 * Define a estrutura para ataques e anúncios de intenção hostil.
 */
public abstract class Inimigo extends Entidade {
    protected int dano;

    /**
     * Construtor para tipos específicos de inimigos.
     * @param nome Nome do perrengue cotidiano.
     * @param vida Resistência do inimigo.
     * @param dano Potencial de ataque básico.
     */
    public Inimigo(String nome, int vida, int dano){
        super(nome, vida, 0);
        this.dano = dano;
    }

    /**
     * Sinaliza ao jogador a próxima ação que o inimigo pretende realizar.
     */
    public abstract void anunciar_ataque();

    /**
     * Executa a lógica de ataque contra o herói.
     * @param heroi O alvo do ataque.
     * @param publisher Gerenciador para notificação de eventos de combate.
     */
    public abstract void atacar(Heroi heroi, Publisher publisher);

}