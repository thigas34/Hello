import java.util.Scanner;

public class Configuraçoes {

    public static String apelido1;
    public static String apelido2;
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
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }

            if (opcao >= 1 && opcao <= 4) {
                break;
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }

        System.out.println("QUAL O APELIDO DA(O) PARTICIPANTE 1? ");
        System.out.println("DIGITE O APELIDO: ");
        String apelido1 = sc.nextLine();

        System.out.println("QUAL O APELIDO DA(O) PARTICIPANTE 2? ");
        System.out.println("DIGITE O APELIDO: ");
        apelido2 = sc.nextLine();

        System.out.println("TABULEIRO CONFIGURADO! JOGADORES: " + apelido1 + " vs " + apelido2);
    }
}
