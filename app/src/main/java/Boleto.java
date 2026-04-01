import java.util.Random;
public class Boleto extends Inimigo {
    private Random numero;
    public Boleto(String nome, int vida, int dano){
        super(nome, vida, dano);
        this.numero = new Random();

    }

    public void anunciar_ataque(){
        System.out.println("Fofoca do Boleto: eu irei usar meu ataque de juros e causar " + this.dano + " de dano!");
    }

    public void atacar(Heroi heroi, Publisher publisher){
        int random = numero.nextInt(2);
        if (random == 0){

        System.out.println(this.getNome() + " atacou e causou " + this.dano + " de dano para te levar ao Vasco da Gama!");
        heroi.receberDano(this.dano);
        }
        else{
            System.out.println(this.getNome() + " enviou um zap 'Precisamos conversar, amor...'. Recebeu 3 de ansiedade!");
            Ansiedade debuff = new Ansiedade(heroi, 3);
            heroi.aplicarEfeito(debuff);
            publisher.inscrever(debuff);
        }
        
    }
}
