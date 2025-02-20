import java.util.Scanner;

public class Configuraçoes {
    public static void mostrarConfiguraçoes() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Configurações do Jogo =====");

        while (true) {
            System.out.println("QUAL O TAMANHO DE TABULEIRO DESEJA JOGAR? ");
            System.out.println("1. 4x4");
            System.out.println("2. 6x6");
            System.out.println("3. 8x8");
            System.out.println("4. 10x10");
            System.out.println("\nDigite a opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();


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
        String apelido2 = sc.nextLine();

        System.out.println("\nTABULEIRO CONFIGURADO!JOGADORES: " + apelido1 + " vs " + apelido2);

    
    }
}
