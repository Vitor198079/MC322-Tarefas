package jogo;
import entidades.Heroi;
import cartas.Baralho;

public class CompraCura implements Interface_Loja {
    public boolean aplicar(Heroi heroi, Baralho baralho){
        heroi.setVida(heroi.getVida() + 30);
        if(heroi.getVida() > 100){
            heroi.setVida(100);
        }
        System.out.println("Você se perfumou com um Jequiti revigorante e recuperou 30 de vida!");
        return true;
    }
    public String getDescricao(){
        return "Recuperar 30 de vida";
    }
}
