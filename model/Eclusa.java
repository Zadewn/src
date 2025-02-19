package model;

public class Eclusa {
    private float largura;
    private float comprimento;
    private float capacidadeMAX;
    private float capacidadeMIN;
    private int quantidadeCanos;
    private double vazao;

    Eclusa eclusa = new Eclusa();

    public Eclusa() {
        this.largura = 70f; 
        this.comprimento = 500f; 
        this.capacidadeMAX = 630000f; 
        this.capacidadeMIN = 35000f; 
        this.vazao = 1050.0; 
        this.quantidadeCanos = 1;
    }

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

    public float getTempo(int canos) {
        if (canos > 0 && canos <= quantidadeCanos && vazao > 0) {
            float volume = capacidadeMAX - capacidadeMIN;
            return volume / (float) (vazao * canos);
        } else {
            return 0;
        }
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
