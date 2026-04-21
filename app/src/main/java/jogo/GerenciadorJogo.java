package jogo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorJogo {
    private static final String ARQUIVO_SAVE = "save.json";
    private Gson gson;

    public GerenciadorJogo() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void salvar(EstadoJogo estado) {
        try (FileWriter writer = new FileWriter(ARQUIVO_SAVE)) {
            gson.toJson(estado, writer);
            System.out.println("Progresso salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public EstadoJogo carregar() {
        try (FileReader reader = new FileReader(ARQUIVO_SAVE)) {
            return gson.fromJson(reader, EstadoJogo.class);
        } catch (IOException e) {
            return null;
        }
    }
}
