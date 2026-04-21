package padroes;
/**
 * Interface que define o papel de um publicador no padrão Observer.
 * Responsável por gerenciar assinantes e distribuir notificações de eventos.
 */
public interface Publisher {
    /**
     * Adiciona um novo assinante à lista de interessados em eventos.
     * @param inscrito Objeto que implementa Subscriber.
     */
    void inscrever(Subscriber inscrito);

    /**
     * Remove um assinante da lista de notificações.
     * @param inscrito Objeto a ser removido.
     */
    void desinscrever(Subscriber inscrito);

    /**
     * Dispara uma mensagem para todos os assinantes ativos.
     * @param acontecimento Descrição ou código do evento ocorrido.
     */
    void notificar(String acontecimento);
}