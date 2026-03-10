public class Heroi {
    private String nome;
    private int vida;
    private int escudo;
    private int horas_de_sono;
    private int max_horas_de_sono;

    //Construtor do Herói
    public Heroi(String nome, int vida, int horas_de_sono){
        this.nome = nome;
        this.vida = vida;
        this.escudo = 0;
        this.horas_de_sono = horas_de_sono;
        this.max_horas_de_sono = horas_de_sono;
    }
    //função que altera os atributos do herói conforme dano é recebido
    public void receberdano(int dano){
        if(dano < this.escudo){
            this.escudo -= dano;
            System.out.println("O brasileiro perdeu"  + dano + "% de cafeína e agora está mais vulnerável!");
        }
        else{
            System.out.println("O brasileiro não tem mais cafeína no sangue para aguentar o trampo");
            if(dano >= this.vida + this.escudo){
                this.vida = 0;
                System.out.println("Você teve seu score do Serasa zerado! Fim de Jogo!");
                System.out.println("Você se tornou um brasileiro Nutella!");
            }
            else{
                    int dano_restante = dano - this.escudo;
                    this.vida -= dano_restante;
                    System.out.println(this.nome + " recebeu " + dano + " de dano");
                    System.out.println("Ainda restam " + this.vida + " de vida para ir de comes e bebes!");
                }
            }
    }
    //função que retorna os atributos do herói em funções públicas (Getters)
    public String GetNome(){
        return this.nome;
    }
    public int GetVida(){
        return this.vida;
    }
    public int getEscudo(){
        return this.escudo;
    }
    public int getHorasdeSono(){
        return horas_de_sono;
    }
    public void perderHorasdeSono(int custo){
        this.horas_de_sono -= custo;
    }

    //função que possibilita o herói de atacar
    public void atacar(CartaDano ataque, Inimigo inimigo, Heroi heroi){
        System.out.println(this.nome + " usou o jeitinho brasileiro para atacar!");
        ataque.usar(heroi, inimigo);
    }
    public void ganharEscudo(int valor_migue){
        this.escudo += valor_migue;
        System.out.println(this.nome + " deu o migué do século e recebeu " + valor_migue + " escudo!");
    }
    //O escudo do jogador é descartado no começo de cada turno
    public void IniciarTurno(){
        this.horas_de_sono = max_horas_de_sono;
        if(this.escudo > 0) {
            this.escudo = 0;
            System.out.println("Um novo turno começou! Seu migué expirou e você está sem escudo!");
        }else{
            System.out.println("Um novo turno começou!");
        }
    }
    //caso vida < 0, o herói perde e a batalha é encerrada
    public boolean estaVivo(){
       return this.vida > 0;                                                                                                           
    }
    
}
