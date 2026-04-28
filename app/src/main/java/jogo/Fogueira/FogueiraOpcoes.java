package jogo;
import entidades.*;
import cartas.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

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
            melhorarCarta(baralho);
        }
    }
    public void melhorarCarta(Baralho baralho){
        Scanner scanner = new Scanner(System.in);
        ArrayList<CartaDano> opcoesDano = new ArrayList<>();
        System.out.println("Escolha uma carta de dano para 'dar um grau':");

    for (Carta c : baralho.getMao()) {
            if (c instanceof CartaDano) {
                opcoesDano.add((CartaDano) c);
            }
        }

        if (opcoesDano.isEmpty()) {
            System.out.println("[ Você não possui cartas de dano no baralho! ]");
            return;
        }

        for (int i = 0; i < opcoesDano.size(); i++) {
            System.out.println((i + 1) + " - " + opcoesDano.get(i).getNome() + 
                            " (Dano Atual: " + opcoesDano.get(i).GetDano() + ")");
        }

        System.out.print(">>> ");
        int escolha = scanner.nextInt();
        int idx = escolha - 1;

        if (idx >= 0 && idx < opcoesDano.size()) {
            CartaDano cartaSelecionada = opcoesDano.get(idx);
            cartaSelecionada.setDano(cartaSelecionada.GetDano() + 5);
            System.out.println("A carta [" + cartaSelecionada.getNome() + "] agora causa " + cartaSelecionada.GetDano() + " de dano!");
        } else {
            System.out.println("Opção inválida!");
        }
    }
}

