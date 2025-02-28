import java.util.*;

public class Respostas {
    public static int userLinha;
    public static int userColuna;
    public static List<Integer> resposta1 = new ArrayList<>();
    public static List<Integer> resposta2 = new ArrayList<>();
    public static void jogo() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while (true) {
            Tabuleiro.mostrartabuleiro();
            index = index + 1;
            System.out.print("Linha");
            userLinha = sc.nextInt();
            System.out.print("Coluna");
            userColuna = sc.nextInt();

            if (index == 1) {
                resposta1.clear();
                resposta2.clear();
                resposta1.add(userLinha);
                resposta1.add(userColuna);
            } else {
                resposta2.add(userLinha);
                resposta2.add(userColuna);
                index = index - 2;
            }
        }
    }
}
