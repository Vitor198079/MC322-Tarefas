package jogo;
import entidades.*;
import cartas.*;
import java.util.Scanner;

public class FogueiraOpcoes extends Fogueira {
    public FogueiraOpcoes(String nome, Baralho baralho){
        super(nome, baralho);
    }
    protected void executarAcao(int escolha, Heroi heroi){
        if(escolha == 1){
            int cura = 30;
            heroi.setVida(heroi.getVida() + cura);
            if(heroi.getVida() > 100){
                heroi.setVida(100);
            }
            System.out.println("Você dormir um pouco. Vida atual " + heroi.getVida());
        }else if (escolha == 2){
            melhorarCarta();
        }
    }
    private void melhorarCarta(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma carta de dano para 'dar um grau':");

        for(int i = 0; i < baralho.getMao().size(); i++){
            Carta c = baralho.getMao().get(i);
            if(c instanceof CartaDano){
                System.out.println((i+1) + " - " + c.getNome());
            }
        }
        System.out.println(">>> ");
        int idx = scanner.nextInt() - 1;

        if(idx >= 0 && idx < baralho.getMao().size()){
            Carta c = baralho.getMao().get(idx);
            if(c instanceof CartaDano){
                CartaDano carta_dano = (CartaDano) c;
                carta_dano.setDano(carta_dano.getDano() + 5);
                System.out.println("A carta [" + carta_dano.getNome() + "] agora causa " + carta_dano.getDano() + " de dano!");
            }
        }
    }
}
