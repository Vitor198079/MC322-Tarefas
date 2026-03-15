public class CartaEscudo extends Carta{
    private int valor_migue; 
    
    //Construtor da Carta Escudo que passa os atributos para superclasse
    public CartaEscudo(String nome, String descricao, int custo, int migue){
        super(nome, descricao, custo);
        this.valor_migue = migue;
    }
    

    public void usar(Heroi heroi, Inimigo inimigo){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você de o migué e usou " + this.getNome() + "!");
            heroi.ganharEscudo(this.valor_migue);
        }
        else{
            System.out.println("O brasileiro tá virado! E não tem horas de sono o sufiente para dar um migué!");
        }
    }
}
