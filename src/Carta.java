public abstract class Carta {
    private String nome;
    private String descricao;
    private int custo_horas_de_sono;

    public Carta(String nome, String descricao, int custo){
        this.nome = nome;
        this.descricao = descricao;
        this.custo_horas_de_sono = custo;
    }
    public abstract void usar(Heroi heroi, Inimigo inimigo, Publisher publisher);

    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getCusto(){
        return this.custo_horas_de_sono;
    }
}

