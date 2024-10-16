package com.exemplo.forca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Forca {
    private List<Palavra> palavras = new ArrayList<>();
    private String palavraSelecionada;
    private String dica;
    private StringBuilder tentativa;
    private int tentativasRestantes;

    public Forca() {
        // Adicionando palavras e dicas
        palavras.add(new Palavra("java", "Uma linguagem de programação"));
        palavras.add(new Palavra("forca", "Um jogo de adivinhação"));
        palavras.add(new Palavra("computador", "Máquina que processa dados"));
        palavras.add(new Palavra("programacao", "A arte de escrever códigos"));
        palavras.add(new Palavra("desenvolvedor", "Profissional que cria software"));
        palavras.add(new Palavra("algoritmo", "Conjunto de regras para resolver problemas"));

        escolherPalavraAleatoria();
    }

    private void escolherPalavraAleatoria() {
        Random random = new Random();
        Palavra palavra = palavras.get(random.nextInt(palavras.size()));
        palavraSelecionada = palavra.getPalavra();
        dica = palavra.getDica();
        tentativa = new StringBuilder("_".repeat(palavraSelecionada.length()));
        tentativasRestantes = 6; // Número de tentativas permitidas
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("Dica: " + dica);

        while (tentativasRestantes > 0 && tentativa.toString().contains("_")) {
            System.out.println("Palavra: " + tentativa);
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().charAt(0);

            if (!verificarTentativa(letra)) {
                tentativasRestantes--;
                System.out.println("Letra não encontrada!");
            }

            if (!tentativa.toString().contains("_")) {
                System.out.println("Parabéns! Você adivinhou a palavra: " + palavraSelecionada);
                break;
            }
        }

        if (tentativasRestantes == 0) {
            System.out.println("Você perdeu! A palavra era: " + palavraSelecionada);
        }

        scanner.close();
    }

    private boolean verificarTentativa(char letra) {
        boolean encontrado = false;
        for (int i = 0; i < palavraSelecionada.length(); i++) {
            if (palavraSelecionada.charAt(i) == letra) {
                tentativa.setCharAt(i, letra);
                encontrado = true;
            }
        }
        return encontrado;
    }

    public static void main(String[] args) {
        Forca jogo = new Forca();
        jogo.jogar();
    }
}

class Palavra {
    private String palavra;
    private String dica;

    public Palavra(String palavra, String dica) {
        this.palavra = palavra;
        this.dica = dica;
    }

    public String getPalavra() {
        return palavra;
    }

    public String getDica() {
        return dica;
    }
}
