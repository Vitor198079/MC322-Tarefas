public class CartaDano extends Carta{
    private int dano;

    //Construtor da CartaDano passa os atributos para a superclasse
    public CartaDano(String nome_carta, String descricao, int custo_horas_de_sono, int dano){
        super(nome_carta, descricao, custo_horas_de_sono);
        this.dano = dano;
    }
    public int GetDano(){
        return dano;
    }
    //declara a função utilizável da carta dano
    public void usar(Heroi heroi, Inimigo inimigo, Publisher publisher){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você sacrificou " + this.getCusto() + " horas de sono para usar " + this.getNome() + "!");
            inimigo.receberDano(this.GetDano());

        }
        else{
            System.out.println("O brasileiro tá virado! E não tem horas de sono o sufiente para usar "  + this.getNome() + ".");
        }
    }
}

