public class Cafeina extends Efeito {
    public Cafeina(Entidade dono, int acumulos){
        super("Cafeína", dono, acumulos);
    }

    public void serNotificado(String evento){
        if(evento.equals("INICIAR_BADERNA_" + this.getDono().getNome())) {
            if(this.getAcumulos() > 0){
                System.out.println("PODER DA CAFEÍNA! " + this.getDono().getNome() +  " ganhou " + this.getAcumulos() + " de escudo extra do café.");
                this.getDono().ganharEscudo(this.getAcumulos());

                this.setAcumulos(this.getAcumulos() - 1);
            }
        }
    }
}
