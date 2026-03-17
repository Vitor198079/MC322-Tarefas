public abstract class Entidade {
    //atributos privados da superclasse
    private String nome;
    private int vida;
    private int escudo;

    //construtor da superclasse
    public Entidade(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = 0;

    }
    //Método de Receber dano
    public void receberDano(int dano){
        if(dano <= this.escudo){
            this.escudo -= dano;
            System.out.println(this.nome + " perdeu "  + dano + "% de cafeína e agora está mais vulnerável!");
            System.out.println("Escudo restante: " + this.escudo);
        }
        else{
            System.out.println(this.nome + " não tem mais cafeína no sangue para aguentar o trampo");
            int dano_restante = dano - this.escudo;
            this.escudo = 0;
            this.vida -= dano_restante;
            if(this.vida <= 0){
                this.vida = 0;  
            }
            System.out.println(this.nome + " recebeu " + dano + " de Lapada seca.");

        }
    }
    public boolean estaVivo(){
        return this.vida > 0;
    }
    public void ganharEscudo(int valor_migue){
        this.escudo += valor_migue;
        System.out.println(this.nome + " ganhou " + valor_migue + " de escudo!" );
    }
    public String getNome(){
        return this.nome;
    }
    public int getVida(){
        return this.vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public int getEscudo(){
        return this.escudo;
    }
    public void setEscudo(int escudo){
        this.escudo = escudo;
    }
}
