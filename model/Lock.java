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
    private double nivelAgua;          // 0 a 100 (percentual), se quiser simplificar
    private final double tempoEncher;  // tempo (em minutos, por exemplo) para encher 0% -> 100%
    private final double tempoEsvaziar; // tempo (em minutos) para esvaziar 100% -> 0%
    
    // Fila de navios aguardando para atravessar a eclusa
    private Queue<CargoShip> filaNavios;
    
    // Poderia ter capacidade máxima de navios por vez, etc.
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

    public Queue<CargoShip> getFilaNavios() {
        return filaNavios;
    }

    public void adicionarNavioFila(CargoShip navio) {
        filaNavios.add(navio);
    }

    // Simulação de encher a eclusa
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

        CargoShip navio = filaNavios.poll();
        this.receitaTotal += navio.getTarifa();

        System.out.println("Navio " + navio.getNome() + " atravessou a eclusa.");
    }
}
