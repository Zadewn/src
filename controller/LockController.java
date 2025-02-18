package controller;

import model.NavioCargueiro;
import model.Lock;
import model.LockException;

public class LockController {

    private Lock lock;

    public LockController(Lock lock) {
        this.lock = lock;
    }

    public void adicionarNavio(int codigoID, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido) {
        NavioCargueiro navio = new NavioCargueiro(codigoID, comprimento, largura, capacidade, origem, destino, tarifa, sentido);
        lock.adicionarNavioFila(navio);
    }

    public void encherEclusa() {
        try {
            lock.encher();
        } catch (LockException e) {
            System.out.println("Erro ao encher a eclusa: " + e.getMessage());
        }
    }

    public void esvaziarEclusa() {
        try {
            lock.esvaziar();
        } catch (LockException e) {
            System.out.println("Erro ao esvaziar a eclusa: " + e.getMessage());
        }
    }

    public void passarNavio() {
        try {
            lock.passarNavio();
        } catch (LockException e) {
            System.out.println("Erro ao passar navio: " + e.getMessage());
        }
    }

    public double getReceitaTotal() {
        return lock.getReceitaTotal();
    }

    public void exibirFila() {
        if (lock.getFilaNavios().isEmpty()) {
            System.out.println("Nenhum navio na fila.");
        } else {
            System.out.println("Navios na fila:");
            for (NavioCargueiro navio : lock.getFilaNavios()) {
                System.out.println("  - " + navio.toString());
            }
        }
    }

    public String getStatusEclusa() {
        return lock.getStatus().name();
    }

    public double getNivelAgua() {
        return lock.getNivelAgua();
    }
}
