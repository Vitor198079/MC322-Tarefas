import java.util.ArrayList;
public class GameManager implements Publisher {
    private ArrayList<Subscriber> inscritos;
    private Heroi heroi;
    private ArrayList<Inimigo> inimigos;

    public GameManager(Heroi heroi, ArrayList<Inimigo> inimigos){
        this.inscritos = new ArrayList<>();
        this.heroi = heroi;
        this.inimigos = inimigos;
    }

    public void inscrever(Subscriber inscrito){
        if(!this.inscritos.contains(inscrito)){
            this.inscritos.add(inscrito);
        }
    }
    public void desinscrever(Subscriber inscrito){
        this.inscritos.remove(inscrito);
    }
    
    public void notificar(String evento){
        ArrayList<Subscriber> temp = new ArrayList <>(this.inscritos);
        for(Subscriber ins : temp){
            ins.serNotificado(evento);
        }
    }

    public void IniciarTurno(){
        System.out.println("\n================================");
        System.out.println("=== INíCIO DO TURNO DE " + heroi.getNome().toUpperCase() + " ===");
        notificar("INICIO_BADERNA_" + heroi.getNome());
        heroi.IniciarTurno();
    }

    public void finalizarTurno(){
        System.out.println("\n================================");
        System.out.println("=== FIM DO TURNO DE " + heroi.getNome().toUpperCase() + " ===");
        notificar("FIM_BADERNA_" + heroi.getNome());
        heroi.IniciarTurno();
    }

    public void turno_inimigos(){
        System.out.println("\n================================");
        System.out.println("=== TURNO DOS PERRENGUES ===");

        for(Inimigo inimigo : inimigos){
            if(inimigo.estaVivo()){
                System.out.println("\n Vez de " + inimigo.getNome());
                notificar("INICIO_BADERNA " + inimigo.getNome());

                inimigo.atacar(heroi);
                notificar("FIM_BADERNA " + inimigo.getNome());
            }
        }
    }
}
