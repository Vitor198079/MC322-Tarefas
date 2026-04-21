package cartas;
import entidades.Heroi;
import entidades.Inimigo;
import padroes.Publisher;
import efeitos.Ansiedade;
import efeitos.Cafeina;
/**
 * Implementa uma carta que aplica o efeito negativo de Ansiedade ao inimigo.
 * Representa o uso de pressão psicológica ou gatilhos mentais contra os oponentes.
 */
public class CartaAnsiedade extends Carta {
    private int quantidade_ansiedade;

    /**
     * Inicializa uma carta de ansiedade com atributos de debuff.
     * @param nome Nome da carta.
     * @param descricao Descrição do gatilho mental.
     * @param custo Horas de sono consumidas.
     * @param quantidade_ansiedade Intensidade do efeito aplicado ao alvo.
     */
    public CartaAnsiedade(String nome, String descricao, int custo, int quantidade_ansiedade){
        super(nome, descricao, custo);
        this.quantidade_ansiedade = quantidade_ansiedade;
    }

    /**
     * Executa a ação de aplicar ansiedade caso o herói tenha horas de sono suficientes.
     */
    public void usar(Heroi heroi, Inimigo alvo, Publisher publisher){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você induziu um gatilho mental usando [" + this.getNome() +"] no " + alvo.getNome() +"!");
            Ansiedade debuff = new Ansiedade(alvo, this.quantidade_ansiedade);
            alvo.aplicarEfeito(debuff);

            publisher.inscrever(debuff);
        }else{
            System.out.println("Você está muito exausto para colocar pressão nos outros!");
        }
    }
}