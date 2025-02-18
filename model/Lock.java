package model;

import java.util.LinkedList;
import java.util.Queue;

public class Lock {
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
    
    private Queue<NavioCargueiro> filaNavios;
    
    private double receitaTotal;

    private boolean comportaRioAberta;
    private boolean comportaMarAberta;

    public Lock(double tempoEncher, double tempoEsvaziar) {
        this.status = LockStatus.VAZIA;
        this.nivelAgua = 0.0;
        this.tempoEncher = tempoEncher;
        this.tempoEsvaziar = tempoEsvaziar;
        this.filaNavios = new LinkedList<>();
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

    public Queue<NavioCargueiro> getFilaNavios() {
        return filaNavios;
    }

    public void adicionarNavioFila(NavioCargueiro navio) {
        filaNavios.add(navio);
    }

    public void encher() throws LockException {
        if (status == LockStatus.CHEIA) {
            throw new LockException("A eclusa ja esta cheia!");
        }
        if (status == LockStatus.ENCHENDO) {
            throw new LockException("A eclusa ja esta enchendo!");
        }
        // Exemplo simples: assume que o enchimento é instantâneo
        status = LockStatus.ENCHENDO;
        nivelAgua = 100.0;
        status = LockStatus.CHEIA;
        System.out.println("Eclusa foi enchida (nivel de agua = 100%).");
    }

    // Simulação de esvaziar a eclusa
    public void esvaziar() throws LockException {
        if (status == LockStatus.VAZIA) {
            throw new LockException("A eclusa ja esta vazia!");
        }
        if (status == LockStatus.ESVAZIANDO) {
            throw new LockException("A eclusa ja esta esvaziando!");
        }
        // Exemplo simples: assume que o esvaziamento é instantâneo
        status = LockStatus.ESVAZIANDO;
        nivelAgua = 0.0;
        status = LockStatus.VAZIA;
        System.out.println("Eclusa foi esvaziada (nivel de agua = 0%).");
    }

    // Simulação de passagem do navio
    public void passarNavio() throws LockException {
        if (status != LockStatus.CHEIA) {
            throw new LockException("Nao e possível passar navio. A eclusa nao esta cheia!");
        }
        if (filaNavios.isEmpty()) {
            throw new LockException("Nao ha navios na fila para passar.");
        }

        NavioCargueiro navio = filaNavios.poll();
        this.receitaTotal += navio.getTarifa();

        System.out.println("Navio " + navio.getCodigoID() + " atravessou a eclusa.");
    }

    public void abrirComportaRio() throws ComportaException {
        if (comportaRioAberta) {
            throw new ComportaException("A comporta do Rio ja esta aberta!");
        }
        // Se a comporta do Mar estiver aberta, não permite abrir a do Rio
        if (comportaMarAberta) {
            throw new ComportaException("A comporta do Mar esta aberta! Feche-a antes de abrir a comporta do Rio.");
        }
        // Condicionalmente, você pode incluir outras regras, por exemplo:
        // só permitir abrir a comporta se a eclusa estiver em um determinado estado.
        
        comportaRioAberta = true;
        System.out.println("Comporta do Rio aberta.");
    }

    public void abrirComportaMar() throws ComportaException {
        if (comportaMarAberta) {
            throw new ComportaException("A comporta do Mar ja esta aberta!");
        }
        if (comportaRioAberta) {
            throw new ComportaException("A comporta do Rio esta aberta! Feche-a antes de abrir a comporta do Mar.");
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
