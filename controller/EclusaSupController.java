package controller;

import model.NavioCargueiro;
import model.Pessoa;
import model.ComportaException;
import model.Cruzeiro;
import model.EclusaSup;
import model.EclusaSup.ComportaStatus;
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
            System.out.println("Navio nao pode ser adicionado devido a limitacoes de capacidade.");
        }
    }
    
    public void adicionarCruzeiro(int codigoID, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido, Pessoa capitao) {
        Cruzeiro cruzeiro = new Cruzeiro(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido, capitao);
        if (sup.podeAdicionarNavio(cruzeiro)) {
            sup.adicionarNavioFila(cruzeiro);
            sup.adicionarReceita(tarifa);
        } else {
            System.out.println("Navio nao pode ser adicionado devido a limitacoes de capacidade.");
        }
    }

    public void adicionarLancha(int codigoID, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido, Pessoa capitao) {
        Lancha lancha = new Lancha(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido, capitao);
        if (sup.podeAdicionarNavio(lancha)) {
            sup.adicionarNavioFila(lancha);
            sup.adicionarReceita(tarifa);
        } else {
            System.out.println("Navio nao pode ser adicionado devido a limitacoes de capacidade.");
        }
    }

    public void modificarEclusa(float novaLargura, float novoComprimento, float novaCapacidadeMin, float novaCapacidadeMax, int novaQuantidadeCanos, double vazao) {
        sup.setLargura(novaLargura);
        sup.setComprimento(novoComprimento);
        sup.setCapacidadeMIN(novaCapacidadeMin);
        sup.setCapacidadeMAX(novaCapacidadeMax);
        sup.setQuantidadeCanos(novaQuantidadeCanos);
        sup.setVazao(vazao);
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

 public void passarNavio(){
    try {
        if (sup.getStatus() == EclusaSupStatus.CHEIA || sup.getStatus() == EclusaSupStatus.VAZIA) {

            if (!sup.getFilaRio().isEmpty()) {
                Embarcacao navio = sup.getFilaRio().poll();
                sup.adicionarNavioFila(navio); 
                System.out.println("Navio da fila do Rio esta passando: " + navio);
            }

            else if (!sup.getFilaMar().isEmpty()) {
                Embarcacao navio = sup.getFilaMar().poll();
                sup.adicionarNavioFila(navio); 
                System.out.println("Navio da fila do Mar esta passando: " + navio);
            } else {
                System.out.println("Nao ha navios na fila para passar.");
            }
        } else {
            throw new EclusaSupException("A eclusa nao estA pronta para a passagem de navios.");
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

    public void encaixarNaviosMar() {
        if (comportaMarAberta()) {
            sup.encaixarNaviosMar();
            System.out.println("Navios no mar foram encaixados na eclusa.");
        } else {
            System.out.println("Nao e possível encaixar navios no mar, pois a comporta do Mar esta fechada.");
        }
    }

    public void encaixarNaviosRio() {
        if (comportaRioAberta()) {
            sup.encaixarNaviosRio();
            System.out.println("Navios no rio foram encaixados na eclusa.");
        } else {
            System.out.println("Nao e possivel encaixar navios no rio, pois a comporta do Rio esta fechada.");
        }
    }

    private boolean comportaRioAberta() {
        return sup.getComportaRioStatus() == ComportaStatus.ABERTO;
    }

    private boolean comportaMarAberta() {
        return sup.getComportaMarStatus() == ComportaStatus.ABERTO;
    }

    public double getTempoEncher() {
        return sup.getTempoEncher(); 
    }
    
    public double getTempoEsvaziar() {
        return sup.getTempoEsvaziar();
    }

    public double getTempoFilaRio() {
        double tempoPorBarco = sup.getTempoEncher(); 
        int quantidadeNaviosFilaRio = sup.getFilaRio().size();
        return tempoPorBarco * quantidadeNaviosFilaRio; 
    }
    
    public double getTempoFilaMar() {
        double tempoPorBarco = sup.getTempoEsvaziar();
        int quantidadeNaviosFilaMar = sup.getFilaMar().size(); 
        return tempoPorBarco * quantidadeNaviosFilaMar; 
    }
}
