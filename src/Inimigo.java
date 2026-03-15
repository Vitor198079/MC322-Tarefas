public class Inimigo extends Entidade {
    protected int dano;
    //Construtor do Herói
    public Inimigo(String nome, int vida, int dano){
        super(nome, vida, 0);
        this.dano = dano;
    }
    
    public abstract void anunciarintencao();
    public abstract void atacar(Heroi heroi);
//     public void atacar(Heroi heroi){
//         System.out.println(this.getNome() + " atacou e causou " + this.dano + " de dano para te levar ao Vasco da Gama!");

//         heroi.receberDano(this.dano);
//     }
// }
