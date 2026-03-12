public class Inimigo {
    private String nome;
    private int vida;
    private int escudo;

    //Construtor do Inimigo
    public Inimigo(String nome, int vida){
        this.nome = nome;
        this.vida = vida;
        this.escudo = 0;
    }

    //função que altera os atributos do inimigo conforme o dano é recebido
    public void receberDano(int dano){
        if(dano < this.escudo){
            this.escudo -= dano;
            System.out.println("O perrengue perdeu " + dano + " de prazo de dias úteis e agora está mais vulnerável!");
        }
        else{

            System.out.println("O perrengue não tem mais prazo de dias úteis para se defender do brasileiro!");
            this.escudo = 0;
            if(dano >= this.vida + this.escudo){
                this.vida = 0;
                System.out.println("Você derrotou " + this.nome + " e sobreviveu a mais um perrengue!");
                System.out.println("Você ganhou +1 de XP de brasileiro raiz!");
            }
            else{
                    int dano_restante = dano - this.escudo;
                    this.vida -= dano_restante;
                    System.out.println(this.nome + " recebeu " + dano + " de dano de Lapada Seca.");
                    System.out.println("Ainda restam " + this.vida + " de vida para superar o perrengue!");
                }
        }
    }
    //retorna os atributos do herói
    public int getVida(){
        return this.vida;
    }
    public String GetNome(){
        return this.nome;
    }
    public int getEscudo(){
        return this.escudo;
    }
    //função que possibilita o ataque do inimigo
    public void atacar(CartaDano ataque, Heroi heroi){
        System.out.println("O ataque do " + this.nome + " te empurrou " + ataque.GetDano() + " pontos em direção ao Vasco da Gama!");
        heroi.receberDano(ataque.GetDano());
    }
    //caso vida < 0, o herói ganha e o jogo termina
    public boolean estaVivo(){
        return this.vida > 0;                                                                                                         
    }
}
