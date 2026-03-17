public class Boleto extends Inimigo {
    public Boleto(String nome, int vida, int dano){
        super(nome, vida, dano);
    }

    public void anunciar_ataque(){
        System.out.println("Fofoca do Boleto: eu irei usar meu ataque de juros e causar " + this.dano + "!");
    }

    public void atacar(Heroi heroi){
        System.out.println(this.getNome() + " atacou e causou " + this.getVida() + " de dano para te levar ao Vasco da Gama!");
        heroi.receberDano(this.dano);
    }
}
