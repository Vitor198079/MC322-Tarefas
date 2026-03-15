public class Heroi extends Entidade {
    private int horas_de_sono;
    private int max_horas_de_sono;

    //Construtor do Herói
    public Heroi(String nome, int vida, int horas_de_sono){
        super(nome, vida, 0);
        this.horas_de_sono = horas_de_sono;
        this.max_horas_de_sono = horas_de_sono;
    }
    public int getHorasdeSono(){
        return this.horas_de_sono;
    }
    public int perderHorasdeSono(int custo_horas_de_sono){
        return this.horas_de_sono -= custo_horas_de_sono;
    }
    public void IniciarTurno(){
        this.horas_de_sono = this.max_horas_de_sono;
        if(this.getEscudo() > 0){
            this.setEscudo(0);
            System.out.println("Um novo turno começou! Seu migué anterior acabou e você está sem escudo!");
        }else{
            System.out.println("Um novo turno começou! Suas horas de sono foram restauradas.");
        }
    }
}
