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

    public Lock(double tempoEncher, double tempoEsvaziar) {
        this.status = LockStatus.VAZIA;
        this.nivelAgua = 0.0;
        this.tempoEncher = tempoEncher;
        this.tempoEsvaziar = tempoEsvaziar;
        this.filaNavios = new LinkedList<>();
        this.receitaTotal = 0.0;
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

    public void abrirComportaRio() throws LockException {
        if (capacidade
        }
    }

    void ComportaAbertaException extends Exception {
        public ComportaAbertaException(){
            super("ERRO!! Uma ou mais comportas abertas");
        }
    }
}
