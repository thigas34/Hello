public class tabuleiro {
    public static void mostrartabuleiro(String[] args) {
        // Código ANSI para as cores
        String azul = "\033[44m";  // Fundo azul
        String vermelho = "\033[41m";  // Fundo vermelho
        String reset = "\033[0m";  // Reseta a cor para o padrão

        System.out.println(apelido1);
        System.out.println(azul + "    "+ reset);
        System.out.println(azul + "    " + reset);

        // Espaço entre os quadrados
        System.out.println();

        // Quadrado vermelho
        System.out.println(vermelho + "    " + reset);
        System.out.println(vermelho+ "    " + reset);

    }
}
