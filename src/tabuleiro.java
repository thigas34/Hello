public class tabuleiro {
    public static void mostrartabuleiro() {
        // Código ANSI para as cores
        String azul = "\033[44m";  // Fundo azul
        String vermelho = "\033[41m";  // Fundo vermelho
        String reset = "\033[0m";  // Reseta a cor para o padrão

        for(int linha = 0; linha < Configuraçoes.tamanhoTabuleiro; linha++) {
            for(int coluna = 0; coluna < Configuraçoes.tamanhoTabuleiro; coluna++) {
                if ((linha + coluna) % 2 == 0) {
                    System.out.print(azul + "   " + reset);
                } else {
                    System.out.print(vermelho + "   " + reset);
                }
            }
            System.out.println();
            
        }

    }
}
