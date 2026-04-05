/**
 * Uma carta versátil que combina agressividade direta com pressão psicológica.
 * Causa dano imediato e ainda deixa o inimigo com o status de ansiedade.
 */
public class CartaHibrida extends Carta {
    private int dano;
    private int quantidade_ansiedade;

    /**
     * Construtor para cartas de efeito misto.
     * @param nome Nome da carta.
     * @param descricao Descrição do "hate" ou da ação mista.
     * @param custo Horas de sono consumidas pela complexidade da ação.
     * @param dano Dano direto à vida.
     * @param quantidade_ansiedade Acúmulos de ansiedade aplicados.
     */
    public CartaHibrida(String nome, String descricao, int custo, int dano, int quantidade_ansiedade){
        super(nome, descricao, custo);
        this.dano = dano;
        this.quantidade_ansiedade = quantidade_ansiedade;
    }

    /**
     * Executa o ataque e inscreve o efeito de ansiedade no gerenciador de eventos.
     */
    public void usar(Heroi heroi, Inimigo inimigo, Publisher publisher){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você usou [" + this.getNome() + "] no " + inimigo.getNome() + "!");
            System.out.println("O seu hate causou " + this.dano + " de dano!");
            inimigo.receberDano(this.dano);

            Ansiedade debuff = new Ansiedade(inimigo, this.quantidade_ansiedade);
            inimigo.aplicarEfeito(debuff);
            publisher.inscrever(debuff);
        }else{
            System.out.println("O brasileiro está exausto demais para dar hate em alguém!");
        }
    }
}