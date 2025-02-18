package controller;

import model.NavioCargueiro;
import model.ComportaException;
import model.Cruzeiro;
import model.EclusaSup;
import model.EclusaSupException;
import model.Embarcacao;
import model.Lancha;

public class EclusaSupController {

    private EclusaSup sup;

    public EclusaSupController(EclusaSup sup) {
        this.sup = sup;
    }

    public void adicionarNavio(int codigoID, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido) {
        NavioCargueiro navio = new NavioCargueiro(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido);
        sup.adicionarNavioFila(navio);
    }

    public void adicionarCruzeiro(int codigoID, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido) {
        Cruzeiro cruzeiro = new Cruzeiro(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido);
        sup.adicionarNavioFila(cruzeiro);
    }

    public void adicionarLancha(int codigoID, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido) {
        Lancha lancha = new Lancha(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido);
        sup.adicionarNavioFila(lancha);
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
            sup.passarNavio();
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
