public interface Publisher {
    void inscrever(Subscriber inscrito);
    void desincresver(Subscriber inscrito);
    void notificar(String acontecimento);
    
}
