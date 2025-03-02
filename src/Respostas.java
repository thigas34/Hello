import java.util.*;

public class Respostas {

    public static int userLinha;
    public static int userColuna;
    public static List<Integer> resposta1 = new ArrayList<>();
    public static List<Integer> resposta2 = new ArrayList<>();
    public static int turno = 1;

    public static Player player1 = new Player(Configuracoes.player1, 0, "vermelho");
    public static Player player2 = new Player(Configuracoes.player2, 0, "azul");

    public static void jogo() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while (true) {
            Tabuleiro.mostrartabuleiro();
            System.out.println("Vez de " + (turno == 1 ? player1.nome : player2.nome));

            index = index + 1;
            int tentativas = 0;
            while (true) {
                if (index == 1) {
                    System.out.println("DIGITE A POSIÇÃO DA PRIMEIRA CARTA QUE DESEJA REVELAR:");
                } else {
                    System.out.println("DIGITE A POSIÇÃO DA SEGUNDA CARTA QUE DESEJA REVELAR:");
                }
                System.out.print("Linha: ");
                userLinha = sc.nextInt();
                System.out.print("Coluna: ");
                userColuna = sc.nextInt();

                boolean validacaoPosicao = userLinha > Configuracoes.tamanhoTabuleiro
                        || userColuna > Configuracoes.tamanhoTabuleiro || userColuna == 0 || userLinha == 0;
                boolean cartaJaAcertada = Tabuleiro.celulasAcertadas[userLinha - 1][userColuna - 1];

                boolean validacaoPosicaoJaSelecionada = index == 2 && resposta1.get(0) == userLinha
                        && resposta1.get(1) == userColuna;

                if (validacaoPosicao) {
                    tentativas++;
                    System.out.println("Posição da carta inválida, por favor, insira uma posição válida.");
                    if (tentativas >= 3) {
                        System.out.println("Você errou 3 vezes. Perdeu a vez!");
                        break;
                    }
                    continue;
                } else if (cartaJaAcertada) {
                    tentativas++;
                    System.out
                            .println("A carta da posição informada já está virada, por favor, escolha outra posição.");
                    if (tentativas >= 3) {
                        System.out.println("Você errou 3 vezes. Perdeu a vez!");
                        break;
                    }
                } else if (validacaoPosicaoJaSelecionada) {
                    tentativas++;
                    System.out.println(
                            "A carta da posição informada já foi selecionada nesta rodada, por favor, escolha outra posição.");
                    if (tentativas >= 3) {
                        System.out.println("Você errou 3 vezes. Perdeu a vez!");
                        break;
                    }
                } else {
                    break;
                }
            }

            if (tentativas >= 3) {
                turno = (turno == 1) ? 2 : 1;
                index = 0;
                continue;
            }

            if (index == 1) {
                resposta1.clear();
                resposta2.clear();
                resposta1.add(userLinha);
                resposta1.add(userColuna);
                Tabuleiro.corResposta1 = Tabuleiro.matrizCores[userLinha - 1][userColuna - 1];
            } else {
                resposta2.add(userLinha);
                resposta2.add(userColuna);

                Tabuleiro.corResposta2 = Tabuleiro.matrizCores[userLinha - 1][userColuna - 1];

                Tabuleiro.verificarPontos();
                index = index - 2;
            }
        }
    }
}
