import java.util.Random;

public class Tabuleiro {

    public static String reset = "\u001b[0m";

    public static void mostrartabuleiro() {
        boolean resposta2Valida = Jogo.resposta2 != null && Jogo.resposta2.size() >= 2;
        boolean resposta1Valida = Jogo.resposta1 != null && Jogo.resposta1.size() >= 2;

        String azul = "\u001b[44m";
        String preto = "\u001b[40m";
        String amarelo = "\u001b[43m";
        String branco = "\u001b[47m";

        String vermelho = "\u001b[41m";

        String[] cores = { azul, vermelho, preto, amarelo };

        Random random = new Random();

        for (int linha = 0; linha < (Configuraçoes.tamanhoTabuleiro + 1); linha++) { // Contagem de linhas

            if (linha != 0 && linha < 10) {
                System.out.print(linha + "  ");
            } if (linha == 10) {
                System.out.print(linha + " ");
            }

            for (int coluna = 0; coluna < Configuraçoes.tamanhoTabuleiro; coluna++) { // Contagem de colunas
                String corAleatoria = cores[random.nextInt(cores.length)];

                if (linha == 0) { // Ajusta os caracteres das colunas
                    if (coluna == 0) {
                        System.out.print("    " + (coluna + 1));
                        continue;
                    } else {
                        System.out.print("  " + (coluna + 1));
                        continue;
                    }
                }

                if (resposta1Valida) { // Pinta os espaços que o jogador pedir
                    if (Jogo.resposta1.get(0) == linha && Jogo.resposta1.get(1) == (coluna + 1)) {
                        PrintCor.printCor(corAleatoria);
                    } else if (resposta2Valida && Jogo.resposta2.get(0) == linha
                            && Jogo.resposta2.get(1) == (coluna + 1)) {
                        PrintCor.printCor(corAleatoria);
                    } else {
                        PrintCor.printCor(branco);
                    }
                } else {
                    PrintCor.printCor(branco);
                }

            }
            System.out.println();
        }
    }
}