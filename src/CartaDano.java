public class CartaDano {
    private String nome_carta;
    private int custo_horas_de_sono;
    private int dano;

    //Construtor da CartaDano
    public CartaDano(String nome_carta, int custo_horas_de_sono, int dano){
        this.nome_carta = nome_carta;
        this.custo_horas_de_sono = custo_horas_de_sono;
        this.dano = dano;

    }

    //declara a função utilizável da carta dano
    public void usar(Heroi heroi, Inimigo inimigo){
        if(this.custo_horas_de_sono <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.custo_horas_de_sono);
            System.out.println("Você sacrificou " + this.custo_horas_de_sono + " horas de sono para usar " + this.nome_carta + "!");
            inimigo.receberdano(this.dano);
        }
        else{
            System.out.println("O brasileiro tá virado! E não tem horas de sono o sufiente para sacrificar com o ataque");
        }
    }
    public String getNome(){
        return this.nome_carta;
    }
    public int getCusto(){
        return this.custo_horas_de_sono;
    }
    public int GetDano(){
        return dano;
    }
    }

