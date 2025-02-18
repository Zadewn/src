package view;

import controller.LockController;
import java.util.Scanner;

public class ConsoleView {
    private LockController controller;
    private Scanner scanner;

    public ConsoleView(LockController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GESTAO DE ECLUSA ===");
            System.out.println("[1] Adicionar Navio a Fila");
            System.out.println("[2] Exibir Fila de Navios");
            System.out.println("[3] Encher Eclusa");
            System.out.println("[4] Esvaziar Eclusa");
            System.out.println("[5] Passar Navio pela Eclusa");
            System.out.println("[6] Ver Receita Total");
            System.out.println("[7] Ver Status da Eclusa");

            System.out.println("[8] ");
            System.out.println("[9] ");
            System.out.println("[10] ");
            System.out.println("[11] ");
            System.out.println("[12] ");
            System.out.println("[13] ");
            System.out.println("[14] ");

            System.out.println("[0] Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida! Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    adicionarNavio();
                    break;
                case 2:
                    controller.exibirFila();
                    break;
                case 3:
                    controller.encherEclusa();
                    break;
                case 4:
                    controller.esvaziarEclusa();
                    break;
                case 5:
                    controller.passarNavio();
                    break;
                case 6:
                    System.out.printf("Receita total: %.2f\n", controller.getReceitaTotal());
                    break;
                case 7:
                    System.out.println("Status: " + controller.getStatusEclusa() + " | Nível de água: " + controller.getNivelAgua() + "%");
                    break;
                case 8:

                case 9:

                case 10:

                case 11:

                case 12:

                case 13:

                case 14:


                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }

    private void adicionarNavio() {
        System.out.print("Nome do Navio: ");
        String nome = scanner.nextLine();

        System.out.print("Comprimento (m): ");
        double comprimento = Double.parseDouble(scanner.nextLine());

        System.out.print("Largura (m): ");
        double largura = Double.parseDouble(scanner.nextLine());

        System.out.print("Capacidade (ton ou conteineres): ");
        double capacidade = Double.parseDouble(scanner.nextLine());

        System.out.print("Porto de Origem: ");
        String origem = scanner.nextLine();

        System.out.print("Porto de Destino: ");
        String destino = scanner.nextLine();

        System.out.print("Tarifa (valor a pagar): ");
        double tarifa = Double.parseDouble(scanner.nextLine());

        System.out.print("Sentido do Navio: ");
        String sentido = scanner.nextLine();

        controller.adicionarNavio(nome, comprimento, largura, capacidade, origem, destino, tarifa, sentido);
        System.out.println("Navio adicionado a fila!");
    }
}
