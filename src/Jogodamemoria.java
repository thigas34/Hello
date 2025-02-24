import javax.swing.*;
import java.util.Scanner;

public class Jogodamemoria extends JFrame {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Manga Rosa Memory Game =====");

        while (true) {
            System.out.println("1.Iniciar");
            System.out.println("2.Pontuação Participantes");
            System.out.println("3.Regras do jogo");
            System.out.println("4.Sair");
            System.out.print("Digite sua opção: ");

            int comand = sc.nextInt();
            sc.nextLine(); // Consome a quebra de linha

            switch (comand) {
                case 1:
                    Configuraçoes.mostrarConfiguraçoes();
                    Respostas.jogo();
                    break;
                case 2:
                    System.out.println("Pontuações ainda não implementadas...");
                    break;
                case 3:
                    System.out.println("As regras do jogo serão adicionadas em breve...");
                    break;
                case 4:
                    System.out.println("Jogo finalizado. Até mais!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
