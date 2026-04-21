package cartas;
import entidades.Heroi;
import entidades.Inimigo;
import padroes.Publisher;
import efeitos.Ansiedade;
import efeitos.Cafeina;
/**
 * Representa a famosa técnica brasileira de "dar um migué" para se proteger.
 * Concede escudo imediato para absorver danos futuros.
 */
public class CartaEscudo extends Carta{
    private int valor_migue; 
    
    /**
     * Construtor da carta de defesa.
     * @param nome Nome da desculpa ou manobra defensiva.
     * @param descricao Como o herói evita o trabalho/dano.
     * @param custo Horas de sono gastas planejando o migué.
     * @param migue Valor da proteção (escudo) concedida.
     */
    public CartaEscudo(String nome, String descricao, int custo, int migue){
        super(nome, descricao, custo);
        this.valor_migue = migue;
    }

    /**
     * Ativa a defesa do herói, convertendo sono em proteção.
     */
    public void usar(Heroi heroi, Inimigo inimigo, Publisher publisher){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você deu o migué e usou " + this.getNome() + "!");
            heroi.ganharEscudo(this.valor_migue);
        }
        else{
            System.out.println("O brasileiro tá virado! E não tem horas de sono o sufiente para dar um migué!");
        }
    }
}