package controller;

import model.NavioCargueiro;
import model.Pessoa;
import model.ComportaException;
import model.Cruzeiro;
import model.EclusaSup;
import model.EclusaSup.EclusaSupStatus;
import model.EclusaSupException;
import model.Embarcacao;
import model.Lancha;

public class EclusaSupController {

    private EclusaSup sup;

    public EclusaSupController(EclusaSup sup) {
        this.sup = sup;
    }

    public void adicionarNavio(int codigoID, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido, Pessoa capitao) {
        NavioCargueiro navio = new NavioCargueiro(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido, capitao);
        if (sup.podeAdicionarNavio(navio)) {
            sup.adicionarNavioFila(navio);
            sup.adicionarReceita(tarifa);
        } else {
            System.out.println("Navio nAo pode ser adicionado devido a limitaCOes de capacidade.");
        }
    }
    

    public void adicionarCruzeiro(int codigoID, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido, Pessoa capitao) {
        Cruzeiro cruzeiro = new Cruzeiro(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido, capitao);
        if (sup.podeAdicionarNavio(cruzeiro)) {
            sup.adicionarNavioFila(cruzeiro);
            sup.adicionarReceita(tarifa);
        } else {
            System.out.println("Navio nAo pode ser adicionado devido a limitaCOes de capacidade.");
        }
    }

    public void adicionarLancha(int codigoID, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido, Pessoa capitao) {
        Lancha lancha = new Lancha(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido, capitao);
        if (sup.podeAdicionarNavio(lancha)) {
            sup.adicionarNavioFila(lancha);
            sup.adicionarReceita(tarifa);
        } else {
            System.out.println("Navio nAo pode ser adicionado devido a limitaCOes de capacidade.");
        }
    }

    public void modificarEclusa(double novoTempoEncher, double novoTempoEsvaziar, float novaLargura, float novoComprimento, float novaCapacidadeMin, float novaCapacidadeMax, int novaQuantidadeCanos) {
        sup.setTempoEncher(novoTempoEncher);  
        sup.setTempoEsvaziar(novoTempoEsvaziar);
        sup.setLargura(novaLargura);
        sup.setComprimento(novoComprimento);
        sup.setCapacidadeMIN(novaCapacidadeMin);
        sup.setCapacidadeMAX(novaCapacidadeMax);
        sup.setQuantidadeCanos(novaQuantidadeCanos);
    }

    public void encherEclusa() {
        try {
            sup.encher();
        } catch (EclusaSupException e) {
            System.out.println("Erro ao encher a eclusa: " + e.getMessage());
        }
    }

    public void esvaziarEclusa() {
        try {
            sup.esvaziar();
        } catch (EclusaSupException e) {
            System.out.println("Erro ao esvaziar a eclusa: " + e.getMessage());
        }
    }

    public void passarNavio() {
        try {
            if (sup.getStatus() == EclusaSupStatus.CHEIA || sup.getStatus() == EclusaSupStatus.VAZIA) {
                if (!sup.getFilaRio().isEmpty()) {
                    Embarcacao navio = sup.getFilaRio().poll(); // Retira o navio da fila do Rio
                    sup.adicionarNavioFila(navio);
                    sup.passarNavio(); // Realiza a passagem do navio
                } else if (!sup.getFilaMar().isEmpty()) {
                    Embarcacao navio = sup.getFilaMar().poll(); // Retira o navio da fila do Mar
                    sup.adicionarNavioFila(navio);
                    sup.passarNavio(); // Realiza a passagem do navio
                } else {
                    System.out.println("Não há navios na fila para passar.");
                }
            } else {
                System.out.println("A eclusa não está pronta para a passagem de navios.");
            }
        } catch (EclusaSupException e) {
            System.out.println("Erro ao passar navio: " + e.getMessage());
        }
    }

    public double getReceitaTotal() {
        return sup.getReceitaTotal();
    }

    public void exibirFila() {
        if (sup.getFilaRio().isEmpty() && sup.getFilaMar().isEmpty()) {
            System.out.println("Nenhum navio na fila.");
        } else {
            System.out.println("Navios na fila do Rio:");
            for (Embarcacao navio : sup.getFilaRio()) {
                System.out.println("  - " + navio.toString());
            }
            System.out.println("Navios na fila do Mar:");
            for (Embarcacao navio : sup.getFilaMar()) {
                System.out.println("  - " + navio.toString());
            }
        }
    }
    public String getStatusEclusa() {
        return sup.getStatus().name();
    }

    public double getNivelAgua() {
        return sup.getNivelAgua();
    }

    public void abrirComportaRio() {
        try {
            sup.abrirComportaRio();
        } catch (ComportaException e) {
            System.out.println("Erro ao abrir comporta do Rio: " + e.getMessage());
        }
    }
    
    public void abrirComportaMar() {
        try {
            sup.abrirComportaMar();
        } catch (ComportaException e) {
            System.out.println("Erro ao abrir comporta do Mar: " + e.getMessage());
        }
    }
    
    public void fecharComportaRio() {
        try {
            sup.fecharComportaRio();
        } catch (ComportaException e) {
            System.out.println("Erro ao fechar comporta do Rio: " + e.getMessage());
        }
    }
    
    public void fecharComportaMar() {
        try {
            sup.fecharComportaMar();
        } catch (ComportaException e) {
            System.out.println("Erro ao fechar comporta do Mar: " + e.getMessage());
        }
    }
}
