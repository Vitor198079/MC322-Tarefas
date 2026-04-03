import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Arte{
    public static String imprimir(String path){
        try {
            return  Files.readString(Path.of(path));
        } catch(IOException e){
            return "";
        }
    }
}