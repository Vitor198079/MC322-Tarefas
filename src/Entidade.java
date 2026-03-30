import java.util.ArrayList;

public abstract class Entidade {
    //atributos privados da superclasse
    private String nome;
    private int vida;
    private int escudo;

    private ArrayList<Efeito> efeitos;
    //construtor da superclasse
    public Entidade(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = 0;
        this.efeitos = new ArrayList<>();

    }
    public void aplicarEfeito(Efeito novoefeito){
        boolean ja_tem_o_efeito = false;
        for(Efeito e : this.efeitos){
            if(e.getNome().equals(novoefeito.getNome())){
                e.adicionarAcumulos(novoefeito.getAcumulos());
                System.out.println("O efeito " + "[" + novoefeito.getNome() + "]" +   this.nome + " foi acumulado" + " Total: " + novoefeito.getAcumulos());
                ja_tem_o_efeito = true;
                break;
            }
        }
        if(!ja_tem_o_efeito){
            this.efeitos.add(novoefeito);
            System.out.println(this.nome + " foi atingido por " + "[" + novoefeito.getNome() +"] com " + novoefeito.getAcumulos() + " acúmulos");
        }
    }
    public ArrayList<Efeito> getefeito(){
        return this.efeitos;
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
