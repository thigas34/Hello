import java.util.*;

public class Tabuleiro {

    public static String reset = "\u001b[0m";
    static String[][] matrizCores;
    public static boolean inicializado = false;
    public static String corResposta1;
    public static String corResposta2;

    static boolean[][] celulasAcertadas;

    public static void inicializarTabuleiro() {
        if (inicializado)
            return;

        String azul = "\u001b[44m";
        String preto = "\u001b[40m";
        String amarelo = "\u001b[43m";
        String vermelho = "\u001b[41m";

        int tamanho = Configuracoes.tamanhoTabuleiro;
        int celulasTabuleiro = tamanho * tamanho;
        int metade = celulasTabuleiro / 2;
        int azulCount = metade / 2;
        int vermelhoCount = metade / 2;
        int pretoCount = 2;
        int amareloCount = celulasTabuleiro - (azulCount + vermelhoCount + pretoCount);

        ArrayList<String> cores = new ArrayList<>();
        for (int i = 0; i < azulCount; i++)
            cores.add(azul);
        for (int i = 0; i < vermelhoCount; i++)
            cores.add(vermelho);
        for (int i = 0; i < pretoCount; i++)
            cores.add(preto);
        for (int i = 0; i < amareloCount; i++)
            cores.add(amarelo);

        Collections.shuffle(cores, new Random());

        matrizCores = new String[tamanho][tamanho];
        int index = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrizCores[i][j] = cores.get(index++);
            }
        }

        celulasAcertadas = new boolean[tamanho][tamanho];

        inicializado = true;
    }

    public static void verificarPontos() {

        if (corResposta1 != null && corResposta2 != null) {
            String cor1 = corResposta1;
            String cor2 = corResposta2;
    

            if (cor1.equals(Respostas.turno == 1 ? "\u001b[41m" : "\u001b[44m")) {
                if (cor1.equals(cor2)) {
                    if (Respostas.turno == 1) {
                        Respostas.player1.pontos += 5;
                        System.out.println(Respostas.player1.nome + " encontrou um par da sua cor! +5 pontos.");
                    } else {
                        Respostas.player2.pontos += 5;
                        System.out.println(Respostas.player2.nome + " encontrou um par da sua cor! +5 pontos.");
                    }
                } else {
                    if (Respostas.turno == 1) {
                        Respostas.player1.pontos = Math.max(0, Respostas.player1.pontos - 2);
                        System.out.println(Respostas.player1.nome + " errou o par da sua cor! -2 pontos.");
                    } else {
                        Respostas.player2.pontos = Math.max(0, Respostas.player2.pontos - 2);
                        System.out.println(Respostas.player2.nome + " errou o par da sua cor! -2 pontos.");
                    }
                }
            }

            else if (cor1.equals(Respostas.turno == 1 ? "\u001b[44m" : "\u001b[41m")) {
                if (cor1.equals(cor2)) {
                    if (Respostas.turno == 1) {
                        Respostas.player1.pontos += 1;
                        System.out.println(Respostas.player1.nome + " encontrou um par da cor do adversário! +1 ponto.");
                    } else {
                        Respostas.player2.pontos += 1;
                        System.out.println(Respostas.player2.nome + " encontrou um par da cor do adversário! +1 ponto.");
                    }
                } else {
                    if (Respostas.turno == 1) {
                        Respostas.player1.pontos = Math.max(0, Respostas.player1.pontos - 2);
                        System.out.println(Respostas.player1.nome + " errou o par da cor do adversário! -2 pontos.");
                    } else {
                        Respostas.player2.pontos = Math.max(0, Respostas.player2.pontos - 2);
                        System.out.println(Respostas.player2.nome + " errou o par da cor do adversário! -2 pontos.");
                    }
                }
            }
            else if (cor1.equals("\u001b[43m")) {
                if (cor1.equals(cor2)) {
                    if (Respostas.turno == 1) {
                        Respostas.player1.pontos += 1;
                        System.out.println(Respostas.player1.nome + " encontrou um par amarelo! +1 ponto.");
                    } else {
                        Respostas.player2.pontos += 1;
                        System.out.println(Respostas.player2.nome + " encontrou um par amarelo! +1 ponto.");
                    }
                }
            }
            else if (cor1.equals("\u001b[40m")) {
                if (cor1.equals(cor2)) {
                    if (Respostas.turno == 1) {
                        Respostas.player1.pontos += 50;
                        System.out.println(Respostas.player1.nome + " encontrou um par preto! +50 pontos.");
                    } else {
                        Respostas.player2.pontos += 50;
                        System.out.println(Respostas.player2.nome + " encontrou um par preto! +50 pontos.");
                    }
                } else {
                    if (Respostas.turno == 1) {
                        Respostas.player1.pontos = Math.max(0, Respostas.player1.pontos - 50);
                        System.out.println(Respostas.player1.nome + " errou o par preto! -50 pontos.");
                    } else {
                        Respostas.player2.pontos = Math.max(0, Respostas.player2.pontos - 50);
                        System.out.println(Respostas.player2.nome + " errou o par preto! -50 pontos.");
                    }
                }
            }
    
            if (cor1.equals(cor2)) {
                celulasAcertadas[Respostas.resposta1.get(0) - 1][Respostas.resposta1.get(1) - 1] = true;
                celulasAcertadas[Respostas.resposta2.get(0) - 1][Respostas.resposta2.get(1) - 1] = true;
            }
        }
    
        Tabuleiro.mostrartabuleiro();
    
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    
        Respostas.resposta1 = new ArrayList<>();
        Respostas.resposta2 = new ArrayList<>();
    
        Respostas.turno = (Respostas.turno == 1) ? 2 : 1;
    }

    public static void mostrartabuleiro() {
        inicializarTabuleiro();

        String vermelho = "\u001b[41m";
        String azul = "\u001b[44m";

        boolean resposta2Valida = Respostas.resposta2 != null && Respostas.resposta2.size() >= 2;
        boolean resposta1Valida = Respostas.resposta1 != null && Respostas.resposta1.size() >= 2;

        String branco = "\u001b[47m";

        System.out.println(vermelho + Respostas.player1.nome + ": " + Respostas.player1.pontos + reset);

        System.out.println(azul + Respostas.player2.nome + ": " + Respostas.player2.pontos + reset);

        for (int linha = 0; linha < (Configuracoes.tamanhoTabuleiro + 1); linha++) { // Contagem de linhas

            if (linha != 0 && linha < 10) {
                System.out.print(linha + "  ");
            }
            if (linha == 10) {
                System.out.print(linha + " ");
            }

            for (int coluna = 0; coluna < Configuracoes.tamanhoTabuleiro; coluna++) { // Contagem de colunas

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
                if (celulasAcertadas[linha - 1][coluna]) {
                    PrintCor.printCor(corAtual);
                } else if (resposta1Valida) { // Pinta os espaços que o jogador pedir
                    if (Respostas.resposta1.get(0) == linha && Respostas.resposta1.get(1) == (coluna + 1)) {
                        PrintCor.printCor(corAtual);
                        corResposta1 = corAtual;
                    } else if (resposta2Valida && Respostas.resposta2.get(0) == linha
                            && Respostas.resposta2.get(1) == (coluna + 1)) {
                        PrintCor.printCor(corAtual);
                        corResposta2 = corAtual;
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