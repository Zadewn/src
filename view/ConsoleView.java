package view;

import controller.EclusaSupController;
import model.Pessoa;

import java.util.Scanner;

public class ConsoleView {
    private EclusaSupController controller;
    private Scanner scanner;

    public ConsoleView(EclusaSupController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GESTAO DE ECLUSA ===");
            System.out.println("[1] Adicionar Lancha");
            System.out.println("[2] Adicionar Cruzeiro");
            System.out.println("[3] Adicionar Navio Cargueiro");
            System.out.println("[4] Exibir Fila de Navios");
            System.out.println("[5] Encher Eclusa");
            System.out.println("[6] Esvaziar Eclusa");
            System.out.println("[7] Passar Navio pela Eclusa");
            System.out.println("[8] Ver Receita Total");
            System.out.println("[9] Ver Status da Eclusa");
            System.out.println("[10] Abrir Comporta do Rio");
            System.out.println("[11] Abrir Comporta do Mar");
            System.out.println("[12] Fechar Comporta do Rio");
            System.out.println("[13] Fechar Comporta do Mar");
            System.out.println("[14] Modificar Eclusa");
            System.out.println("[15] Encaixar Navios no Mar");
            System.out.println("[16] Encaixar Navios no Rio");
            System.out.println("[17] Ver Tempos de Eclusa");
            System.out.println("[18] Ver Tempo de Espera na Fila do Rio");
            System.out.println("[19] Ver Tempo de Espera na Fila do Mar");
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
                    adicionarLancha();
                    break;
                case 2:
                    adicionarCruzeiro();
                    break;
                case 3:
                    adicionarNavioCargueiro();
                    break;
                case 4:
                    controller.exibirFila();
                    break;
                case 5:
                    controller.encherEclusa();
                    break;
                case 6:
                    controller.esvaziarEclusa();
                    break;
                case 7:
                    controller.passarNavio();
                    break;
                case 8:
                    System.out.printf("Receita total: %.2f\n", controller.getReceitaTotal());
                    break;
                case 9:
                    System.out.println("Status: " + controller.getStatusEclusa() + " | Nivel de agua: " + controller.getNivelAgua() + "%");
                    break;
                case 10:
                    controller.abrirComportaRio();
                    break;
                case 11:
                    controller.abrirComportaMar();
                    break;
                case 12:
                    controller.fecharComportaRio();
                    break;
                case 13:
                    controller.fecharComportaMar();
                    break;
                case 14:
                    modificarEclusa();
                    break;
                case 15:
                    controller.encaixarNaviosMar();
                    break;
                case 16:
                    controller.encaixarNaviosRio();  
                    break;
                case 17:
                    exibirTempos();
                    break;
                case 18:
                    exibirTempoFilaRio();
                    break;
                case 19:
                    exibirTempoFilaMar();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }
 
    private void adicionarLancha() {
        System.out.println("\n--- Adicionando Lancha ---");
        System.out.print("Código da Lancha: ");
        int codigoID = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Comprimento (m): ");
        double comprimento = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Largura (m): ");
        double largura = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Capacidade (pessoas): ");
        double capacidade = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Porto de Origem: ");
        String origem = scanner.nextLine();
    
        System.out.print("Porto de Destino: ");
        String destino = scanner.nextLine();
    
        System.out.print("Tarifa (valor a pagar): ");
        double tarifa = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Sentido: ");
        String sentido = scanner.nextLine();

        System.out.print("Nome do Capitão: ");
        String nomeCapitao = scanner.nextLine();

        Pessoa capitao = new Pessoa();
        capitao.setNome(nomeCapitao);
        
        controller.adicionarNavio(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido, capitao);
        System.out.println("Lancha adicionada a fila!");
    }
    
    private void adicionarCruzeiro() {
        System.out.println("\n--- Adicionando Cruzeiro ---");
        System.out.print("Código do Cruzeiro: ");
        int codigoID = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Comprimento (m): ");
        double comprimento = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Largura (m): ");
        double largura = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Capacidade (pessoas): ");
        double capacidade = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Porto de Origem: ");
        String origem = scanner.nextLine();
    
        System.out.print("Porto de Destino: ");
        String destino = scanner.nextLine();
    
        System.out.print("Tarifa (valor a pagar): ");
        double tarifa = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Sentido: ");
        String sentido = scanner.nextLine();

        System.out.print("Nome do Capitão: ");
        String nomeCapitao = scanner.nextLine();

        Pessoa capitao = new Pessoa();
        capitao.setNome(nomeCapitao);
        
        controller.adicionarNavio(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido, capitao);
        System.out.println("Cruzeiro adicionado a fila!");
    }
    
    private void adicionarNavioCargueiro() {
        System.out.println("\n--- Adicionando Navio Cargueiro ---");
        System.out.print("Código do Navio: ");
        int codigoID = Integer.parseInt(scanner.nextLine());
    
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

        System.out.print("Nome do Capitão: ");
        String nomeCapitao = scanner.nextLine();

        Pessoa capitao = new Pessoa();
        capitao.setNome(nomeCapitao);
        
        controller.adicionarNavio(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido, capitao);
        System.out.println("Navio Cargueiro adicionado a fila!");
    }

    public void modificarEclusa() {
        System.out.println("\n--- Modificar Parametros da Eclusa ---");
    
        System.out.print("Novo tempo para encher (segundos): ");
        double novoTempoEncher = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Novo tempo para esvaziar (segundos): ");
        double novoTempoEsvaziar = Double.parseDouble(scanner.nextLine());
    
        System.out.print("Nova largura (metros): ");
        float novaLargura = Float.parseFloat(scanner.nextLine());
        
        System.out.print("Novo comprimento (metros): ");
        float novoComprimento = Float.parseFloat(scanner.nextLine());
        
        System.out.print("Nova capacidade mínima (m³): ");
        float novaCapacidadeMin = Float.parseFloat(scanner.nextLine());
    
        System.out.print("Nova capacidade máxima (m³): ");
        float novaCapacidadeMax = Float.parseFloat(scanner.nextLine());
    
        System.out.print("Nova quantidade de canos: ");
        int novaQuantidadeCanos = Integer.parseInt(scanner.nextLine());
    
        controller.modificarEclusa(novoTempoEncher, novoTempoEsvaziar, novaLargura, novoComprimento, novaCapacidadeMin, novaCapacidadeMax, novaQuantidadeCanos);
        
        System.out.println("Eclusa modificada com sucesso!");
    }

    private void exibirTempos() {
        double tempoEncher = controller.getTempoEncher();
        double tempoEsvaziar = controller.getTempoEsvaziar();
        
        System.out.printf("Tempo para encher a eclusa: %.2f segundos\n", tempoEncher);
        System.out.printf("Tempo para esvaziar a eclusa: %.2f segundos\n", tempoEsvaziar);
    }
    
    private void exibirTempoFilaRio() {
        double tempoFilaRio = controller.getTempoFilaRio();
        
        System.out.printf("Tempo de espera na fila do Rio: %.2f minutos\n", tempoFilaRio);
    }
    
    private void exibirTempoFilaMar() {
        double tempoFilaMar = controller.getTempoFilaMar();
        
        System.out.printf("Tempo de espera na fila do Mar: %.2f minutos\n", tempoFilaMar);
    }
    
}
