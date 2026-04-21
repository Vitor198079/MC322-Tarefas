package cartas;
import entidades.Heroi;
import entidades.Inimigo;
import padroes.Publisher;
import efeitos.Ansiedade;
import efeitos.Cafeina;
/**
 * Carta focada em causar dano direto aos "perrengues" do cotidiano.
 * Representa o esforço físico ou mental convertido em ataque.
 */
public class CartaDano extends Carta{
    private int dano;

    /**
     * Construtor para cartas de ataque.
     * @param nome_carta Nome da ação ofensiva.
     * @param descricao Detalhes sobre o impacto do ataque.
     * @param custo_horas_de_sono Horas sacrificadas para o ataque.
     * @param dano Valor numérico reduzido da vida do inimigo.
     */
    public CartaDano(String nome_carta, String descricao, int custo_horas_de_sono, int dano){
        super(nome_carta, descricao, custo_horas_de_sono);
        this.dano = dano;
    }

    public int GetDano(){
        return dano;
    }

    /**
     * Realiza o ataque, sacrificando o sono do herói para ferir o oponente.
     */
    public void usar(Heroi heroi, Inimigo inimigo, Publisher publisher){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você sacrificou " + this.getCusto() + " horas de sono para usar " + this.getNome() + "!");
            inimigo.receberDano(this.GetDano());

        }
        else{
            System.out.println("O brasileiro tá virado! E não tem horas de sono o sufiente para usar "  + this.getNome() + ".");
        }
    }
}