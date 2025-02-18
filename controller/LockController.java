package controller;

import model.CargoShip;
import model.Lock;
import model.LockException;

public class LockController {

    private Lock lock;

    public LockController(Lock lock) {
        this.lock = lock;
    }

    public void adicionarNavio(String nome, double comprimento, double largura, double capacidade, String origem, String destino, double tarifa, String sentido) {
        CargoShip navio = new CargoShip(nome, comprimento, largura, capacidade, origem, destino, tarifa, sentido);
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
            for (CargoShip navio : lock.getFilaNavios()) {
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
