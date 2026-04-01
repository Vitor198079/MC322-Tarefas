public abstract class Efeito implements Subscriber {
    private String nome;
    private Entidade dono;
    private int acumulos;

    public Efeito(String nome, Entidade dono, int acumulos){
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;

    }

    public String getString(){
        return this.nome + " (" + this.acumulos + ")";
    }
    public String getNome(){
        return this.nome;
    }

    public Entidade getDono(){
        return this.dono;
    }

    public int getAcumulos(){
        return this.acumulos;
    }
    public void setAcumulos(int acumulos){
        this.acumulos = acumulos;
    }
    public void adicionarAcumulos(int valor){
        this.acumulos += valor;
    }

    public abstract void serNotificado(String evento);
    
}
