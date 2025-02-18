package model;
import java.util.*;

public class Eclusa {

    private float largura;
    private float comprimento;
    private float capacidadeMAX;
    private float capacidadeMIN;
    private float capacidadeAtual;
    private boolean comportaRio; // Em direção ao rio, true = aberta, false = fechada
    private boolean comportaMar; // Em direção ao mar
    private float vazao; 
    private int quantidadeCanos;
    private float valorApurado;
    private ArrayList<Embarcacao> naviosEncaixados = new ArrayList<>();

    @SuppressWarnings("rawtypes")
    public ArrayList getNaviosEncaixados() { return naviosEncaixados; }

    public float getCapacidadeAtual() { return capacidadeAtual; }
    public float getLargura() { return largura; }
    public float getComprimento() { return comprimento; }
    public float getCapacidadeMAX() { return capacidadeMAX; }
    public float getCapacidadeMIN() { return capacidadeMIN; }
    public float getVazao() { return vazao; }
    public int getQuantidadeCanos() { return quantidadeCanos; }
    public float getvalorApurado() { return valorApurado; }
    public boolean getComportaMar() { return comportaMar; }
    public boolean getComportaRio() { return comportaRio; }
    
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

    public void setCapacidadeAtual(float capacidadeAtual) {
        if (capacidadeAtual <= capacidadeMAX && capacidadeAtual >= capacidadeMIN) {
            this.capacidadeAtual = capacidadeAtual;
        }
    }

    public void setVazao(float vazao) {
        if (vazao > 0) {
            this.vazao = vazao;
        }
    }

    public void setQuantidadeCanos(int quantidadeCanos) {
        if (quantidadeCanos > 0) {
            this.quantidadeCanos = quantidadeCanos;
        }
    }

    public float getTempoFilaMAX() { //Retorna o tempo maximo para esvaziar as filas
        float tempo = (capacidadeMAX - capacidadeMIN)/vazao;
        if(filaMar.size() > filaRio.size()){
            return tempo * filaMar.size();
        }else{
            return tempo * filaRio.size();
        }
    }

    public float getTempo(int canos){
        if(canos > 0 && canos <= quantidadeCanos){
            float volume = capacidadeMAX - capacidadeMIN;
            return volume / (vazao * canos);
        }
        else return 0;
    }

}
