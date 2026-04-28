package jogo;
import entidades.Heroi;
import jogo.CompraCura;
import jogo.Interface_Loja;
import cartas.Baralho;
import java.util.Scanner;
import java.util.ArrayList;

public class Loja extends Evento {
    private Baralho baralho;
    private ArrayList<ItemLoja> prateleira;
    
    public Loja(String nome, Baralho baralho){
        super(nome);
        this.baralho = baralho;
        this.prateleira = new ArrayList<>();
        prateleira.add(new ItemLoja(30, new CompraCura()));
        prateleira.add(new ItemLoja(50, new RemoveCarta()));
        
    }

    public boolean iniciar(Heroi heroi){
        Scanner teclado = new Scanner(System.in);
        boolean explorar = true;

        while(explorar){
            System.out.println(Cores.AMARELO + "\n=== BEM-VINDO AO BAÚ DO SILVIO (LOJA) ===" + Cores.RESET);
            System.out.println("Seu Ouro " + heroi.getOuro());

            for (int i = 0; i < prateleira.size(); i++){
                ItemLoja item = prateleira.get(i);
                System.out.println((i+1) + " - " + item.in.getDescricao() + " | Preço: " + item.preco + " Ouro");
            }
            System.out.println("0 - Sair da loja");
            System.out.println(">>> ");

            int escolha = teclado.nextInt();
            if(escolha == 0){
                explorar = false;
            } else if(escolha > 0 && escolha <= prateleira.size()){
                ItemLoja selecionado = prateleira.get(escolha - 1);
                if(heroi.getOuro() >= selecionado.preco){
                    if(selecionado.in.aplicar(heroi, baralho)){
                        heroi.adicionarOuro(-selecionado.preco);
                        prateleira.remove(escolha - 1);
                    }
                }else{
                    System.out.println("Você não tem Ouro suficiente! Mah oê!");    
                }
            }
            Terminal.pausar(1500);
        }
        return true;
    }
    private class ItemLoja {
        int preco;
        Interface_Loja in;
        ItemLoja(int p, Interface_Loja i){
            this.preco = p;
            this.in = i;
        }
    }
}
