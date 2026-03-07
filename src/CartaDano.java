public class CartaDano {
    private String nome_carta;
    private int custo;
    private int dano;

    public void usar(String carta, Heroi heroi){
        this.nome_carta = carta;

    }

    public int GetDano(){
        return dano;
    }
    }
    
}
