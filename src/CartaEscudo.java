public class CartaEscudo {
    private String nome;
    private int custo;
    private int valor_migue; 
    
    //Construtor da Carta Escudo
    public CartaEscudo(String nome, int custo, int migue){
        this.nome = nome;
        this.custo = custo;
        this.valor_migue = migue;
    }
    //declara a função utilizável da carta escudo
    public void usar(Heroi heroi){
        if(this.custo <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.custo);
            heroi.ganharEscudo(this.valor_migue);
        }
        else{
            System.out.println("O brasileiro tá virado! E não tem horas de sono o sufiente para dar um migué!");
        }
    }
    //retorna as propriedades da carta dano
    public String getNome(){
        return this.nome;
    }
    public int getCusto(){
        return this.custo;
    }
}
