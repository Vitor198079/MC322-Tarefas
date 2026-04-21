package efeitos;
import entidades.Entidade;
/**
 * Efeito "Ansiedade" que causa dano direto ao dono ao final de certos eventos,
 * reduzindo seus acúmulos a cada ativação.
 */
public class Ansiedade extends Efeito {

    /**
     * Inicializa o efeito com a entidade dona e seus acúmulos iniciais.
     *
     * @param dono a entidade afetada
     * @param acumulos quantidade inicial do efeito
     */
    public Ansiedade(Entidade dono, int acumulos){
        super("Ansiedade", dono, acumulos);
    }

    /**
     * Aplica o efeito ao receber o evento de fim de baderna da entidade,
     * causando dano e reduzindo os acúmulos.
     *
     * @param evento o evento recebido
     */
    public void serNotificado(String evento){
        if(evento.equals("FIM_BADERNA_" + this.getDono().getNome())){
            if(this.getAcumulos() > 0){
                System.out.println("CRISE DE ANSIEDADE! " + this.getDono().getNome() + " sofreu " + this.getAcumulos() + " de dano direto");
                this.getDono().receberDano(this.getAcumulos());
                this.setAcumulos(this.getAcumulos() - 1);
            }
        }
    }
}
