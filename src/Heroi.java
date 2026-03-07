public class Heroi {
    private String nome;
    private int vida;
    private int escudo;

    public void receberdano(int dano){
        if(dano < escudo){
            this.escudo -= dano;
            System.out.println("O brasileiro perdeu" + dano + "% de caféina e agora está mais vulnerável!");
        }
        else{
            this.escudo = 0;
            System.out.println("O brasileiro não tem mais cafeína no sangue para aguentar o trampo");
            if(dano >= this.vida){
                this.vida = 0;
                System.out.println("Você teve seu score do Serasa zerado! Fim de Jogo!");
                System.out.println("Você se tornou um brasileiro Nutella!");
            }
        else{
                this.vida -= dano;
                System.out.println(this.nome + "recebeu" + dano + "de dano");
                System.out.println("Ainda restam" + this.vida + "de vida para ir de comes e bebes!");
            }
        }
    }

    public void atacar(CartaDano ataque, Inimigo inimigo){
        System.out.println(this.nome + "usou o jeitinho brasileiro para atacar!");
        inimigo.receberdano(ataque.GetDano());
    }
    public void ganharEscudo(int valor_migue){
        this.escudo += valor_migue;
        System.out.println(this.nome + "deu o migué do século e recebeu" + valor_migue + "escudo!");
    }
    public boolean esta_vivo(){
       return this.vida > 0;                                                                                                           
    }
    
}
