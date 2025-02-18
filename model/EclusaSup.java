package model;

import java.util.LinkedList;
import java.util.Queue;

public class EclusaSup {
    public enum LockStatus {
        VAZIA,
        ENCHENDO,
        CHEIA,
        ESVAZIANDO
    }

    private LockStatus status;
    private double nivelAgua;   
    private final double tempoEncher;  
    private final double tempoEsvaziar; 
    
    private Queue<Embarcacao> filaRio;
    private Queue<Embarcacao> filaMar;
    
    private double receitaTotal;

    private boolean comportaRioAberta;
    private boolean comportaMarAberta;

    public EclusaSup(double tempoEncher, double tempoEsvaziar) {
        this.status = LockStatus.VAZIA;
        this.nivelAgua = 0.0;
        this.tempoEncher = tempoEncher;
        this.tempoEsvaziar = tempoEsvaziar;
        this.filaRio = new LinkedList<>();
        this.filaMar = new LinkedList<>();
        this.receitaTotal = 0.0;

        this.comportaRioAberta = false;
        this.comportaMarAberta = false;
    }

    public LockStatus getStatus() {
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

    public Queue<Embarcacao> getFilaRio() {
        return filaRio;
    }
    
    public Queue<Embarcacao> getFilaMar() {
        return filaMar;
    }

    public void adicionarNavioFila(Embarcacao navio) {
        if (navio.getSentido().equals("R")) {
            filaRio.add(navio);
        } else if (navio.getSentido().equals("M")) {
            filaMar.add(navio);
        }
    }

    public void encher() throws EclusaSupException {
        if (status == LockStatus.CHEIA) {
            throw new EclusaSupException("A eclusa ja esta cheia!");
        }
        if (status == LockStatus.ENCHENDO) {
            throw new EclusaSupException("A eclusa ja esta enchendo!");
        }
        // Exemplo simples: assume que o enchimento é instantâneo
        status = LockStatus.ENCHENDO;
        nivelAgua = 100.0;
        status = LockStatus.CHEIA;
        System.out.println("Eclusa foi enchida (nivel de agua = 100%).");
    }

    // Simulação de esvaziar a eclusa
    public void esvaziar() throws EclusaSupException {
        if (status == LockStatus.VAZIA) {
            throw new EclusaSupException("A eclusa ja esta vazia!");
        }
        if (status == LockStatus.ESVAZIANDO) {
            throw new EclusaSupException("A eclusa ja esta esvaziando!");
        }
        status = LockStatus.ESVAZIANDO;
        nivelAgua = 0.0;
        status = LockStatus.VAZIA;
        System.out.println("Eclusa foi esvaziada (nivel de agua = 0%).");
    }

    public void passarNavio() throws EclusaSupException {
        if (status != LockStatus.CHEIA) {
            throw new EclusaSupException("Nao e possivel passar navio. A eclusa nao esta cheia!");
        }
        
        Embarcacao navio = null;
        if (!filaRio.isEmpty()) {
            navio = filaRio.poll();
        } else if (!filaMar.isEmpty()){
            navio = filaMar.poll();
        } else {
            throw new EclusaSupException("Nao ha navios na fila para passar.");
        }
        this.receitaTotal += navio.getTarifa();
        System.out.println("Navio " + navio.getCodigoID() + " atravessou a eclusa.");
    }

    public void abrirComportaRio() throws ComportaException {
        if (comportaRioAberta) {
            throw new ComportaException("A comporta do Rio ja esta aberta!");
        }
        if (status == LockStatus.CHEIA) {
            throw new ComportaException("A eclusa esta cheia! Esvazie antes de abrir a comporta do Rio.");
        }
        
        comportaRioAberta = true;
        System.out.println("Comporta do Rio aberta.");
    }

    public void abrirComportaMar() throws ComportaException {
        if (comportaMarAberta) {
            throw new ComportaException("A comporta do Mar ja esta aberta!");
        }
        if (status == LockStatus.VAZIA) {
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
