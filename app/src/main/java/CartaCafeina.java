public class CartaCafeina extends Carta {
    private int quantidade_cafe;
    public CartaCafeina(String nome, String descricao, int custo, int quantidade_cafe){
        super(nome, descricao, custo);
        this.quantidade_cafe = quantidade_cafe;
    }

    public void usar(Heroi heroi, Inimigo alvo, Publisher publisher){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você virou um copão de café inteiro usando [" + this.getNome() +"]!");
            Cafeina buff = new Cafeina(heroi, this.quantidade_cafe);
            heroi.aplicarEfeito(buff);

            publisher.inscrever(buff);
        }else{
            System.out.println("O brasileiro tá virado! Não tem energia nem para fazer o café.");
        }
    }
}
