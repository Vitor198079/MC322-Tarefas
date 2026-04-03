public class Terminal {
    public static void pausar(int ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public static void limparTela(){
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }
}
