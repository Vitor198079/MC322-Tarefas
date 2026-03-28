public class CartaAnsiedade extends Carta {
    private int quantidade_ansiedade;

    public CartaAnsiedade(String nome, String descricao, int custo, int quantidade_ansiedade){
        super(nome, descricao, custo);
        this.quantidade_ansiedade = quantidade_ansiedade;
    }

    public void usar(Heroi heroi, Inimigo alvo, Publisher publisher){
        if(this.getCusto() <= heroi.getHorasdeSono()){
            heroi.perderHorasdeSono(this.getCusto());
            System.out.println("Você induziu um gatilho mental usando [" + this.getNome() +"] no " + alvo.getNome() +"!");
            Ansiedade debuff = new Ansiedade(alvo, this.quantidade_ansiedade);
            alvo.aplicarEfeito(debuff);

            publisher.inscrever(debuff);
        }else{
            System.out.println("Você está muito exausto para colocar pressão nos outros!");
        }
    }
}
