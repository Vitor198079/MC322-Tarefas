public class CartaHibrida extends Carta {
    private int dano;
    private int quantidade_ansiedade;

    public CartaHibrida(String nome, String descricao, int custo, int dano, int quantidade_ansiedade){
        super(nome, descricao, custo);
        this.dano = dano;
        this.quantidade_ansiedade = quantidade_ansiedade;
    }

    public void usar(Heroi heroi, Inimigo inimigo, Publisher publisher){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você usou [" + this.getNome() + "] no " + inimigo.getNome() + "!");
            System.out.println("O seu hate causou " + this.dano + " de dano!");
            inimigo.receberDano(this.dano);

            Ansiedade debuff = new Ansiedade(inimigo, this.quantidade_ansiedade);
            inimigo.aplicarEfeito(debuff);
            publisher.inscrever(debuff);
        }else{
            System.out.println("O brasileiro está exausto demais para dar hate em alguém!");
        }
    }
}
