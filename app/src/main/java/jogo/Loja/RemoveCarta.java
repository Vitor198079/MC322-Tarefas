package jogo;
import entidades.Heroi;
import jogo.Interface_Loja;
import cartas.Baralho;
import java.util.Scanner;

public class RemoveCarta implements Interface_Loja {
    public boolean aplicar(Heroi heroi, Baralho baralho){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma gambiarra para jogar no lixo permanentemente:");
        for(int i = 0; i < baralho.getMao().size(); i++){
            System.out.println((i+1) + " - " + baralho.getMao().get(i).getNome());
        }
        int escolha = scanner.nextInt() - 1;
        if(escolha >= 0 && escolha < baralho.getMao().size()){
            System.out.println("Carta [" + baralho.getMao().get(escolha).getNome() + "] removida!");
            baralho.getMao().remove(escolha);
            return true;
        }
        return false;
    }
    public String getDescricao(){
        return "Remover uma carta do baralho";
    }
}
