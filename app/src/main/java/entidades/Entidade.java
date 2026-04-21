package entidades;
import java.util.ArrayList;
import padroes.Publisher;
import efeitos.Efeito;
import efeitos.Ansiedade;

/**
 * Representa qualquer ser vivo ou "entidade" no campo de batalha.
 * Gerencia atributos vitais como vida, escudo e a lista de efeitos ativos.
 */
public abstract class Entidade {
    private String nome;
    private int vida;
    private int escudo;
    private ArrayList<Efeito> efeitos;

    /**
     * Construtor para heróis e inimigos.
     * @param nome Identificação da entidade.
     * @param vida Pontos de vida iniciais.
     * @param escudo Proteção inicial (normalmente começa em 0).
     */
    public Entidade(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = 0;
        this.efeitos = new ArrayList<>();
    }

    /**
     * Adiciona um novo efeito ou acumula intensidade caso o efeito já exista.
     * @param novoefeito O objeto de efeito a ser aplicado.
     */
    public void aplicarEfeito(Efeito novoefeito){
        boolean ja_tem_o_efeito = false;
        for(Efeito e : this.efeitos){
            if(e.getNome().equals(novoefeito.getNome())){
                e.adicionarAcumulos(novoefeito.getAcumulos());
                System.out.println("O efeito " + "[" + novoefeito.getNome() + "] " +   this.nome + " foi acumulado" + " Total: " + novoefeito.getAcumulos() + " acúmulos");
                ja_tem_o_efeito = true;
                break;
            }
        }
        if(!ja_tem_o_efeito){
            this.efeitos.add(novoefeito);
            System.out.println(this.nome + " foi atingido por " + "[" + novoefeito.getNome() +"] com " + novoefeito.getAcumulos() + " acúmulos");
        }
    }

    public ArrayList<Efeito> getefeito(){
        return this.efeitos;
    }

    /**
     * Processa a redução de recursos vitais, priorizando o escudo (cafeína) 
     * antes de afetar a vida diretamente.
     * @param dano Valor bruto do ataque recebido.
     */
    public void receberDano(int dano){
        if(dano <= this.escudo){
            this.escudo -= dano;
            System.out.println(this.nome + " perdeu "  + dano + "% de cafeína e agora está mais vulnerável!");
            System.out.println("Escudo restante: " + this.escudo);
        }
        else{
            System.out.println(this.nome + " não tem mais cafeína no sangue para aguentar o trampo");
            int dano_restante = dano - this.escudo;
            this.escudo = 0;
            this.vida -= dano_restante;
            if(this.vida <= 0){
                this.vida = 0;  
            }
            System.out.println(this.nome + " recebeu " + dano + " de Lapada seca.");

        }
    }

    public boolean estaVivo(){
        return this.vida > 0;
    }

    /**
     * Aumenta o valor de defesa da entidade.
     * @param valor_migue Pontos de proteção adicionados.
     */
    public void ganharEscudo(int valor_migue){
        this.escudo += valor_migue;
        System.out.println(this.nome + " ganhou " + valor_migue + " de escudo!" );
    }

    public String getNome(){
        return this.nome;
    }

    public int getVida(){
        return this.vida;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getEscudo(){
        return this.escudo;
    }

    public void setEscudo(int escudo){
        this.escudo = escudo;
    }
    /**
     * Remove os efeitos que já expiraram (acúmulos <= 0)
     */
    public void limparEfeitos(){
        this.efeitos.removeIf(e -> e.getAcumulos() <= 0);
    }
    /** *
     * Formata a lista de efeitos ativos para exibição
     */ 
    public String listarEfeitos(){
        if(this.efeitos.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder("[Efeitos: ");
        for (Efeito e : this.efeitos){
            sb.append(e.getString()).append("");
        }
        sb.append("]");
        return sb.toString();
    }
}
