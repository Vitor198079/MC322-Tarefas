package jogo;
/**
 * Utilitário para manipulação da interface de linha de comando.
 * Contém métodos para controle de fluxo visual e limpeza do console.
 */
public class Terminal {
    /**
     * Suspende a execução por um período determinado para facilitar a leitura.
     * @param ms Tempo de pausa em milissegundos.
     */
    public static void pausar(int ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Limpa o console utilizando códigos ANSI para manter a interface organizada.
     */
    public static void limparTela(){
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }
}