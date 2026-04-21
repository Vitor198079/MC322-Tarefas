package efeitos;
import entidades.Entidade;
/**
 * Implementa o efeito de Cafeína, que converte o estado de alerta em defesa.
 * No início do turno da entidade, os acúmulos de café são transformados 
 * em escudo para mitigar o cansaço da batalha.
 */
public class Cafeina extends Efeito {
    
    /**
     * Construtor da Cafeína.
     * @param dono A entidade que receberá os bônus de escudo.
     * @param acumulos Quantidade de doses que definem a intensidade inicial do efeito.
     */
    public Cafeina(Entidade dono, int acumulos){
        super("Cafeína", dono, acumulos);
    }

    /**
     * Verifica o início do turno da entidade para aplicar o bônus de proteção.
     * Concede escudo baseado nos acúmulos atuais e reduz a carga do efeito em uma unidade.
     * @param evento Nome do evento disparado pelo sistema de jogo.
     */
    public void serNotificado(String evento){
        if(evento.equals("INICIO_BADERNA_" + this.getDono().getNome())) {
            if(this.getAcumulos() > 0){
                System.out.println("PODER DA CAFEÍNA! " + this.getDono().getNome() +  " ganhou " + this.getAcumulos() + " de escudo extra do café.");
                this.getDono().ganharEscudo(this.getAcumulos());

                this.setAcumulos(this.getAcumulos() - 1);
            }
        }
    }
}