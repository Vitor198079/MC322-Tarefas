public interface Publisher {
    void inscrever(Subscriber inscrito);
    void desinscrever(Subscriber inscrito);
    void notificar(String acontecimento);
    
}
