import java.util.Scanner;

public class Configuracoes {

    public static String player1;
    public static String player2;
    public static int tamanhoTabuleiro;

    public static void mostrarConfiguraçoes() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
    
        System.out.println("===== Configurações do Jogo =====");
    
        while (true) {
            System.out.println("QUAL O TAMANHO DE TABULEIRO DESEJA JOGAR? ");
            System.out.println("1. 4x4");
            System.out.println("2. 6x6");
            System.out.println("3. 8x8");
            System.out.println("4. 10x10");
            System.out.println("Digite a opção: ");
    
            int opcao = sc.nextInt();
            sc.nextLine();
    
            switch (opcao) {
                case 1:
                    tamanhoTabuleiro = 4;
                    break;
                case 2:
                    tamanhoTabuleiro = 6;
                    break;
                case 3:
                    tamanhoTabuleiro = 8;
                    break;
                case 4:
                    tamanhoTabuleiro = 10;
                    break;
                default:
                    System.out.println("Por favor, escolha uma das opções de tamanho de tabuleiro disponíveis.");
                    continue;
            }
    
            break; 
        }
    
        System.out.println("QUAL O APELIDO DA(O) PARTICIPANTE 1? ");
        System.out.println("DIGITE O APELIDO: ");
        player1 = sc.nextLine();
        if (player1.length() == 0) {
            player1 = "Participante1";
        }
    
        System.out.println("QUAL O APELIDO DA(O) PARTICIPANTE 2? ");
        System.out.println("DIGITE O APELIDO: ");
        player2 = sc.nextLine();
        if (player2.length() == 0) {
            player2 = "Participante2";
        }
    
        System.out.println("TABULEIRO CONFIGURADO! JOGADORES: " + player1 + " vs " + player2);
    }
}
