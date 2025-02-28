import java.util.*;

public class Tabuleiro {

    public static String reset = "\u001b[0m";
    private static String[][] matrizCores;
    public static boolean inicializado = false;

    public static void inicializarTabuleiro() {
        if (inicializado) return;

        String azul = "\u001b[44m";
        String preto = "\u001b[40m";
        String amarelo = "\u001b[43m";
        String vermelho = "\u001b[41m";

        //contagem de cores do tabuleiro
        int tamanho = Configuraçoes.tamanhoTabuleiro;
        int celulasTabuleiro = tamanho * tamanho;
        int metade = celulasTabuleiro / 2;
        int azulCount = metade / 2;
        int vermelhoCount = metade / 2;
        int pretoCount = 2;
        int amareloCount = celulasTabuleiro - (azulCount + vermelhoCount+ pretoCount);

        ArrayList<String> cores = new ArrayList<>();
        for (int i = 0; i < azulCount; i++) cores.add(azul);
        for (int i = 0; i < vermelhoCount; i++) cores.add(vermelho);
        for (int i = 0; i < pretoCount; i++) cores.add(preto);
        for (int i = 0; i < amareloCount; i++) cores.add(amarelo);

        Collections.shuffle(cores, new Random());

        matrizCores = new String[tamanho][tamanho];
        int index = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrizCores[i][j] = cores.get(index++);
            }
        }

        inicializado = true;
    }

    public static void mostrartabuleiro() {
        inicializarTabuleiro();

        boolean resposta2Valida = Respostas.resposta2 != null && Respostas.resposta2.size() >= 2;
        boolean resposta1Valida = Respostas.resposta1 != null && Respostas.resposta1.size() >= 2;

        String branco = "\u001b[47m";
        
        for (int linha = 0; linha < (Configuraçoes.tamanhoTabuleiro + 1); linha++) { // Contagem de linhas

            if (linha != 0 && linha < 10) {
                System.out.print(linha + "  ");
            } if (linha == 10) {
                System.out.print(linha + " ");
            }

            for (int coluna = 0; coluna < Configuraçoes.tamanhoTabuleiro; coluna++) { // Contagem de colunas

                if (linha == 0) { // Ajusta os caracteres das colunas
                    if (coluna == 0) {
                        System.out.print("    " + (coluna + 1));
                        continue;
                    } else {
                        System.out.print("  " + (coluna + 1));
                        continue;
                    }
                }

                String corAtual = matrizCores[linha - 1][coluna];
                if (resposta1Valida) { // Pinta os espaços que o jogador pedir
                    if (Respostas.resposta1.get(0) == linha && Respostas.resposta1.get(1) == (coluna + 1)) {
                        PrintCor.printCor(corAtual);
                    } else if (resposta2Valida && Respostas.resposta2.get(0) == linha
                            && Respostas.resposta2.get(1) == (coluna + 1)) {
                        PrintCor.printCor(corAtual);
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