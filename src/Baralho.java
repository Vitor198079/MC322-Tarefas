import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    private ArrayList<Carta> compra;
    private ArrayList<Carta> mao;
    private ArrayList<Carta> descarte;

    public Baralho() {
        this.compra = new ArrayList<>();
        this.mao = new ArrayList<>();
        this.descarte = new ArrayList<>();
        inicializarBaralho();
    }

    //Inicializa embaralhado
    private void inicializarBaralho() {
        //Cartas Dano
        compra.add(new CartaDano("Jogar no Paredão", "Coloca o inimigo pra votação popular da casa", 3, 20));
        compra.add(new CartaDano("Esqueceu a senha do GOV", "Faz o inimigo perder tempo recuperando a senha", 2, 15));
        compra.add(new CartaDano("Chuva no Litoral", "Atrapalha todos os planos e deixa tudo um caos", 4, 21));
        compra.add(new CartaDano("Greve de Ônibus", "O inimigo fica preso e perde produtividade", 5, 30));
        compra.add(new CartaDano("Fila do SUS", "Faz o inimigo esperar por horas intermináveis", 6, 25));
        compra.add(new CartaDano("Prova Surpresa", "Pega desprevenido e causa desespero imediato", 3, 35));
        compra.add(new CartaDano("Trânsito na Marginal", "Paralisa completamente o inimigo", 7, 40));
        compra.add(new CartaDano("Internet Caiu", "Interrompe tudo no pior momento possível", 2, 12));
        compra.add(new CartaDano("Calor de 40 Graus", "Drena energia e causa sofrimento", 4, 25));
        compra.add(new CartaDano("Golpe do Pix", "Confunde o inimigo e causa prejuízo", 5, 50));

        //Cartas Escudo
        compra.add(new CartaEscudo("Atestado Médico", "O famoso migué de não trabalhar por 'saúde'", 1, 8));
        compra.add(new CartaEscudo("Vale Refeição", "Garante energia pra continuar o dia", 2, 10));
        compra.add(new CartaEscudo("Cafezinho", "Recupera forças com um clássico brasileiro", 1, 5));
        compra.add(new CartaEscudo("Feriado Prolongado", "Permite descanso extra e recuperação", 5, 20));
        compra.add(new CartaEscudo("13º Salário", "Dá aquele alívio financeiro salvador", 4, 18));
        compra.add(new CartaEscudo("Churrasco de Domingo", "Cervejinha e carne recuperam a vitalidade", 6, 22));
        compra.add(new CartaEscudo("Rede na Varanda", "Descanso garantido e tranquilo", 3, 12));
        compra.add(new CartaEscudo("Pix Recebido", "Recuperação instantânea de ânimo", 2, 9));
        compra.add(new CartaEscudo("Delivery Chegou", "Evita esforço e recupera energia", 2, 8));
        compra.add(new CartaEscudo("Bolsa Família", "Garante ajuda essencial nos momentos difíceis", 3, 15));

        //Cartas Efeito
        compra.add(new CartaAnsiedade("Falar em público", "Aplica 5 de ansiedade no alvo", 2, 5));
        compra.add(new CartaAnsiedade("Mandar DM pra mina 10/10", "Aplica 8 de ansiedade no alvo", 5, 8));
        compra.add(new CartaCafeina("Café da tarde", "Aplica 5 de cafeína para si mesmo", 1, 3));

        Collections.shuffle(compra);
    }

    public void comprarCartas(int quantidade) {
        System.out.println("\n[Comprando cartas...]");
        for (int i = 0; i < quantidade; i++) {
            if (compra.isEmpty()) {
                System.out.println("Acabou o baralho! O estagiário reciclou o lixo...");
                compra.addAll(descarte);
                descarte.clear();
                Collections.shuffle(compra);
            }
            if (!compra.isEmpty()) {
                mao.add(compra.remove(0));
            }
        }
    }

    public ArrayList<Carta> getMao() {
        return this.mao;
    }

    public void cartaUsadaParaDescarte(int index) {
        descarte.add(mao.remove(index));
    }

    public void descartarMaoRestante() {
        if (!mao.isEmpty()) {
            descarte.addAll(mao);
            mao.clear();
            System.out.println("Gambiarras que sobraram na sua mão foram descartadas.");
        }
    }

    public boolean maoEstaVazia() {
        return mao.isEmpty();
    }
}
