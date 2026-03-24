public class Ansiedade extends Efeito {
    public Ansiedade(Entidade dono, int acumulos){
        super("Ansiedade", dono, acumulos);
    }

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
