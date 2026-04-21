package cartas;
import entidades.Heroi;
import entidades.Inimigo;
import padroes.Publisher;
import efeitos.Ansiedade;
import efeitos.Cafeina;
/**
 * Representa a ação de consumir café para ganhar proteção extra.
 * O café gera acúmulos que se transformam em escudo nos turnos seguintes.
 */
public class CartaCafeina extends Carta {
    private int quantidade_cafe;

    /**
     * Construtor da carta de cafeína.
     * @param nome Nome da marca ou tipo de café.
     * @param descricao Texto sobre a "disposição" gerada.
     * @param custo Custo em horas de sono para realizar a ação.
     * @param quantidade_cafe Número de doses/acúmulos concedidos.
     */
    public CartaCafeina(String nome, String descricao, int custo, int quantidade_cafe){
        super(nome, descricao, custo);
        this.quantidade_cafe = quantidade_cafe;
    }

    /**
     * Consome a carta, aplicando o efeito de Cafeína ao herói se houver energia disponível.
     */
    public void usar(Heroi heroi, Inimigo alvo, Publisher publisher){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você virou um copão de café inteiro usando [" + this.getNome() +"]!");
            Cafeina buff = new Cafeina(heroi, this.quantidade_cafe);
            heroi.aplicarEfeito(buff);

            publisher.inscrever(buff);
        }else{
            System.out.println("O brasileiro tá virado! Não tem energia nem para fazer o café.");
        }
    }
}