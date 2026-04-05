import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

/**
 * Classe utilitária para leitura de arquivos de arte em texto.
 */
public class Arte{
    /**
     * Lê e retorna o conteúdo de um arquivo como string.
     *
     * @param path caminho do arquivo
     * @return conteúdo do arquivo ou string vazia em caso de erro
     */
    public static String imprimir(String path){
        try {
            return  Files.readString(Path.of(path));
        } catch(IOException e){
            return "";
        }
    }
}
