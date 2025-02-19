package model;

public class Eclusa {
    private float largura;
    private float comprimento;
    private float capacidadeMAX;
    private float capacidadeMIN;
    private int quantidadeCanos;
    private double vazao;


    public float getLargura() { return largura; }
    public float getComprimento() { return comprimento; }
    public float getCapacidadeMAX() { return capacidadeMAX; }
    public float getCapacidadeMIN() { return capacidadeMIN; }
    public int getQuantidadeCanos() { return quantidadeCanos; }

    public double getVazao() {
        return vazao;
    }

    public void setVazao(double vazao) {
        this.vazao = vazao;
    }
    
    public void setLargura(float largura) {
        if (largura >= 5 ) {
            this.largura = largura;
        }
    }

    public void setComprimento(float comprimento) {
        if (comprimento >= 38) {
            this.comprimento = comprimento;
        }
    }

    public void setCapacidadeMIN(float capacidadeMIN) {
        if (capacidadeMIN > 0) {
            this.capacidadeMIN = capacidadeMIN;
        }
    }

    public void setCapacidadeMAX(float capacidadeMAX) {
        if (capacidadeMAX > 0 && capacidadeMAX > capacidadeMIN) {
            this.capacidadeMAX = capacidadeMAX;
        }
    }

    public void setQuantidadeCanos(int quantidadeCanos) {
        if (quantidadeCanos > 0) {
            this.quantidadeCanos = quantidadeCanos;
        }
    }
}
