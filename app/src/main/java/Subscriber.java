/**
 * Interface que define o papel de um assinante no padrão Observer.
 * Permite que objetos reajam passivamente a mudanças globais no estado do jogo.
 */
public interface Subscriber {
    /**
     * Método chamado quando um publicador notifica um evento relevante.
     * @param acontecimento Mensagem ou identificador do evento.
     */
    void serNotificado(String acontecimento);
}