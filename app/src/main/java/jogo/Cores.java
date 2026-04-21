package jogo;
/**
 * Utilitário para formatação de texto no terminal via códigos ANSI.
 * Define cores específicas para facilitar a leitura dos recursos e status do jogo.
 */
public class Cores {
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m"; // HP dos perrengues (inimigos)
    public static final String VERDE = "\u001B[32m";   // Escudo (defesa)
    public static final String AZUL = "\u001B[34m";    // HP do herói
    public static final String AMARELO = "\u001B[33m"; // Destaque de cartas
    public static final String CIANO = "\u001B[36m";  // Recurso: horas de sono
}