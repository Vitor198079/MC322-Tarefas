public abstract class Inimigo extends Entidade {
    protected int dano;
    //Construtor do Herói
    public Inimigo(String nome, int vida, int dano){
        super(nome, vida, 0);
        this.dano = dano;
    }
    public abstract void anunciar_ataque();
    public abstract void atacar(Heroi heroi, Publisher publisher);

}
