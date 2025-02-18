package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EclusaSup extends Eclusa{
    public enum EclusaSupStatus {
        VAZIA,
        ENCHENDO,
        CHEIA,
        ESVAZIANDO
    }

    private EclusaSupStatus status;
    private double nivelAgua;   
    private double tempoEncher;  
    private double tempoEsvaziar;
    private int porcentagemAtual; 
    
    private Queue<Embarcacao> filaRio;
    private Queue<Embarcacao> filaMar;
    private List<Embarcacao> naviosEncaixados;
    
    private double receitaTotal;

    private boolean comportaRioAberta;
    private boolean comportaMarAberta;

    public EclusaSup() {
        this.status = EclusaSupStatus.VAZIA;
        this.nivelAgua = 0.0;
        this.tempoEncher = getTempoEncher();
        this.tempoEsvaziar = getTempoEsvaziar();
        this.filaRio = new LinkedList<>();
        this.filaMar = new LinkedList<>();
        this.receitaTotal = 0.0;
        this.porcentagemAtual = 0;

        this.comportaRioAberta = false;
        this.comportaMarAberta = false;
    }

    public EclusaSupStatus getStatus() {
        return status;
    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    public double getTempoEncher() {
        return tempoEncher;
    }

    public double getTempoEsvaziar() {
        return tempoEsvaziar;
    }

    public double getReceitaTotal() {
        return receitaTotal;
    }

    public void adicionarReceita(double tarifa) {
        this.receitaTotal += tarifa;
    }

    public Queue<Embarcacao> getFilaRio() {
        return filaRio;
    }
    
    public Queue<Embarcacao> getFilaMar() {
        return filaMar;
    }

    public void setTempoEncher(double tempoEncher) {
        if (tempoEncher > 0) {
            this.tempoEncher = tempoEncher;
        }
    }
    
    public void setTempoEsvaziar(double tempoEsvaziar) {
        if (tempoEsvaziar > 0) {
            this.tempoEsvaziar = tempoEsvaziar;
        }
    }

    public void updatePorcentagem(int novaPorcentagem) {
        System.out.println("Nivel de agua: " + novaPorcentagem + "%");
        this.porcentagemAtual = novaPorcentagem;
    }


    public void adicionarNavioFila(Embarcacao navio) {
        if (navio.getSentido().equals("R")) {
            filaRio.add(navio);
        } else if (navio.getSentido().equals("M")) {
            filaMar.add(navio);
        }
    }

    public void passarNavio() throws EclusaSupException {
        if (!naviosEncaixados.isEmpty()) {
            Embarcacao navio = naviosEncaixados.get(0); 
            naviosEncaixados.remove(0);
            System.out.println("Navio " + navio.toString() + " passou pela eclusa.");
        } else {
            throw new EclusaSupException("Nao ha navios encaixados para passar.");
        }
    }

    public boolean podeAdicionarNavio(Embarcacao navio) {
        double larguraRestante = getLargura();
        double comprimentoRestante = getComprimento();
    
        for (Embarcacao embarcacao : naviosEncaixados) {
            larguraRestante -= (embarcacao.getLargura() - 3);  
            comprimentoRestante -= (embarcacao.getComprimento() - 3);
        }

        if (navio.getLargura() < larguraRestante && navio.getComprimento() < comprimentoRestante) {
            return true;  
        } else {
            return false;  
        }
    }

    public void encher() throws EclusaSupException {
        if (comportaRioAberta) {
            throw new EclusaSupException("Não é possível encher a eclusa com a comporta do Rio aberta!");
        }
        
        if (status == EclusaSupStatus.CHEIA) {
            throw new EclusaSupException("A eclusa ja esta cheia!");
        }
        if (status == EclusaSupStatus.ENCHENDO) {
            throw new EclusaSupException("A eclusa ja esta enchendo!");
        }

        status = EclusaSupStatus.ENCHENDO;
        System.out.println("Eclusa começando a encher...");

        while (nivelAgua < 100.0) {
            nivelAgua += 10; 
            int porcentagem = (int) (nivelAgua); 
            
            if (porcentagem != porcentagemAtual) {
                updatePorcentagem(porcentagem); 
            }

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        nivelAgua = 100.0;
        status = EclusaSupStatus.CHEIA;
        System.out.println("Eclusa foi enchida completamente (nivel de igua = 100%).");
    }

    public void esvaziar() throws EclusaSupException {
        if (comportaMarAberta) {
            throw new EclusaSupException("Nao e possivel esvaziar a eclusa com a comporta do Mar aberta!");
        }

        if (status == EclusaSupStatus.VAZIA) {
            throw new EclusaSupException("A eclusa ja esta vazia!");
        }
        if (status == EclusaSupStatus.ESVAZIANDO) {
            throw new EclusaSupException("A eclusa ja esta esvaziando!");
        }

        status = EclusaSupStatus.ESVAZIANDO;
        System.out.println("Eclusa começando a esvaziar...");

        while (nivelAgua > 0.0) {
            nivelAgua -= 10; 
            int porcentagem = (int) (nivelAgua); 

            if (porcentagem != porcentagemAtual) {
                updatePorcentagem(porcentagem);
            }

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        nivelAgua = 0.0;
        status = EclusaSupStatus.VAZIA;
        System.out.println("Eclusa foi esvaziada completamente (nivel de agua = 0%).");
    }

    public void encaixarNaviosMar() {
        if (!filaMar.isEmpty() && comportaMarAberta) {  // Verifica se a fila não está vazia e se a comporta está aberta
            double larguraRestante = getLargura();
            double comprimentoRestante = getComprimento();
            
            // Processa os navios na fila do mar
            while (!filaMar.isEmpty()) {
                Embarcacao embarcacao = filaMar.poll();  // Remove o navio da fila
    
                // Verifica se o navio cabe na eclusa
                if (embarcacao.getLargura() < larguraRestante && embarcacao.getComprimento() < comprimentoRestante) {
                    naviosEncaixados.add(embarcacao);  // Encaixa o navio
                    larguraRestante -= (embarcacao.getLargura() - 3);  // Ajusta a largura restante
                    comprimentoRestante -= (embarcacao.getComprimento() - 3);  // Ajusta o comprimento restante
                } else {
                    // Se o navio não couber, interrompe o encaixe
                    filaMar.add(embarcacao);  // Recoloca o navio de volta na fila
                    break;
                }
            }
        }
    }

    public void encaixarNaviosRio() {
        if (!filaRio.isEmpty() && comportaRioAberta) {  // Verifica se a fila não está vazia e se a comporta está aberta
            double larguraRestante = getLargura();
            double comprimentoRestante = getComprimento();
            
            // Processa os navios na fila do rio
            while (!filaRio.isEmpty()) {
                Embarcacao embarcacao = filaRio.poll();  // Remove o navio da fila
    
                // Verifica se o navio cabe na eclusa
                if (embarcacao.getLargura() < larguraRestante && embarcacao.getComprimento() < comprimentoRestante) {
                    naviosEncaixados.add(embarcacao);  // Encaixa o navio
                    larguraRestante -= (embarcacao.getLargura() - 3);  // Ajusta a largura restante
                    comprimentoRestante -= (embarcacao.getComprimento() - 3);  // Ajusta o comprimento restante
                } else {
                    // Se o navio não couber, interrompe o encaixe
                    filaRio.add(embarcacao);  // Recoloca o navio de volta na fila
                    break;
                }
            }
        }
    }

    public void abrirComportaRio() throws ComportaException {
        if (comportaRioAberta) {
            throw new ComportaException("A comporta do Rio ja esta aberta!");
        }
        if (status == EclusaSupStatus.CHEIA) {
            throw new ComportaException("A eclusa esta cheia! Esvazie antes de abrir a comporta do Rio.");
        }
        
        comportaRioAberta = true;
        System.out.println("Comporta do Rio aberta.");
    }

    public void abrirComportaMar() throws ComportaException {
        if (comportaMarAberta) {
            throw new ComportaException("A comporta do Mar ja esta aberta!");
        }
        if (status == EclusaSupStatus.VAZIA) {
            throw new ComportaException("A eclusa esta vazia! Encha antes de abrir a comporta do Mar.");
        }
        
        comportaMarAberta = true;
        System.out.println("Comporta do Mar aberta.");
    }

    public void fecharComportaRio() throws ComportaException {
        if (!comportaRioAberta) {
            throw new ComportaException("A comporta do Rio ja esta fechada!");
        }
        comportaRioAberta = false;
        System.out.println("Comporta do Rio fechada.");
    }

    public void fecharComportaMar() throws ComportaException {
        if (!comportaMarAberta) {
            throw new ComportaException("A comporta do Mar ja esta fechada!");
        }
        comportaMarAberta = false;
        System.out.println("Comporta do Mar fechada.");
    }
}
