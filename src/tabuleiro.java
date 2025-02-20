import java.util.Random;

public class tabuleiro {
    public static void mostrartabuleiro() {

        String azul = "\u001b[44m";
        String vermelho = "\u001b[41m";
        String preto = "\u001b[40m";
        String amarelo = "\u001b[43m";
        String branco = "\u001b[47m";
        String reset = "\u001b[0m";

        String[] cores = { azul, vermelho, preto, amarelo };

        Random random = new Random();

        for (int linha = 0; linha < (Configuraçoes.tamanhoTabuleiro + 1); linha++) { // Contagem de linhas

            if (linha != 0) {
                System.out.print(linha + " ");
            }

            for (int coluna = 0; coluna < Configuraçoes.tamanhoTabuleiro; coluna++) { // Contagem de colunas

                if (linha == 0) {
                    System.out.print("   " + (coluna + 1));
                    continue;
                }

                String corAleatoria = cores[random.nextInt(cores.length)];
                System.out.print(corAleatoria + "    " + reset);
            }
            System.out.println();
        }
    }
}