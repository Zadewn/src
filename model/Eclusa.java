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
    private float vazao; // m³ segundo
    private int quantidadeCanos;
    private float valorApurado = 0; // salva o valorApurado diario 
    private char status; // E = Enchendo, S = secando, N = parado
    private ArrayList<Embarcacao> filaMar = new ArrayList<>();
    private ArrayList<Embarcacao> filaRio = new ArrayList<>();
    private ArrayList<Embarcacao> naviosEncaixados = new ArrayList<>();

    public ArrayList getNaviosEncaixados() { return naviosEncaixados; }

    public float getCapacidadeAtual() { return capacidadeAtual; }
    public float getLargura() { return largura; }
    public float getComprimento() { return comprimento; }
    public float getCapacidadeMAX() { return capacidadeMAX; }
    public float getCapacidadeMIN() { return capacidadeMIN; }
    public float getVazao() { return vazao; }
    public int getQuantidadeCanos() { return quantidadeCanos; }
    public float getvalorApurado() { return valorApurado; }
    public char getStatus() { return status; }
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

    public void setFilaMar(Embarcacao embarcacao) {
        if (embarcacao != null) {
            boolean existeCodigo = false;
            for (Object o : filaMar) {
                Embarcacao e = (Embarcacao) o;
                if(e.getCodigoID() == embarcacao.getCodigoID()){
                    existeCodigo = true;
                    break;
                }
            }
            if (embarcacao.getLargura() < largura && embarcacao.getComprimento() < comprimento && existeCodigo == false) {
                filaMar.add(embarcacao);
            }
        }
    }

    public void setFilaRio(Embarcacao embarcacao) {
        if (embarcacao != null) {
            boolean existeCodigo = false;
            for (Object o : filaMar) {
                Embarcacao e = (Embarcacao) o;
                if(e.getCodigoID() == embarcacao.getCodigoID()){
                    existeCodigo = true;
                    break;
                }
            }
            if (embarcacao.getLargura() < largura && embarcacao.getComprimento() < comprimento && existeCodigo == false) {
                filaRio.add(embarcacao);
            }
        }
    }

    public void removerDafilaMar(Embarcacao embarcacao){
        if (filaMar.contains(embarcacao) == true){
            filaMar.remove(embarcacao);
        }
    }

    public void removerDafilaRio(Embarcacao embarcacao){
        if (filaRio.contains(embarcacao) == true){
            filaRio.remove(embarcacao);
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

    public void receberPagamento(Embarcacao embarcacao) {
        if (embarcacao instanceof Lancha){
            valorApurado += 25;
        }else if (embarcacao instanceof Cruzeiro){
            valorApurado += 40;
        }else {
            valorApurado += 50;
        }
    }

    public void setStatus(char status) {
        if (status == 'E' || status == 'S') {
            this.status = status;
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


    public void esvaziarEclusa(int canosAbertoss){
        if(comportaMar == false && comportaRio == false && capacidadeAtual > capacidadeMIN){
            status = 'S';
            float porcentagemBruta;
            int porcentagemArredondada = 0;
            if (canosAbertoss <= quantidadeCanos && canosAbertoss > 0) {
                while (capacidadeAtual > capacidadeMIN) {
                    if (capacidadeAtual - (vazao * canosAbertoss) > capacidadeMIN) {
                        capacidadeAtual -= (vazao * canosAbertoss);
                    } else {
                        capacidadeAtual = capacidadeMIN;
                    }
                    porcentagemBruta = 100 * capacidadeAtual / capacidadeMAX;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if((int) porcentagemBruta != porcentagemArredondada){
                        porcentagemArredondada = (int) porcentagemBruta;
                        //updatePorcentagem(porcentagemArredondada);
                    }
                }
            }
        }
    }

    public void encherEclusa(int canosAbertos){
        if(comportaMar == false && comportaRio == false && capacidadeAtual < capacidadeMAX){
            status = 'E';
            float porcentagemBruta;
            int porcentagemArredondada = 0;
            if (canosAbertos <= quantidadeCanos && canosAbertos > 0) {
                while (capacidadeAtual < capacidadeMAX) {
                    if (capacidadeAtual + (vazao * canosAbertos) < capacidadeMAX) {
                        capacidadeAtual += (vazao * canosAbertos);
                    } else {
                        capacidadeAtual = capacidadeMAX;
                    }
                    porcentagemBruta = 100 * capacidadeAtual / capacidadeMAX;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if((int) porcentagemBruta != porcentagemArredondada){
                        porcentagemArredondada = (int) porcentagemBruta;
                        //updatePorcentagem(porcentagemArredondada);
                    }
                }
            }
        }
    }

    public void encaixarNaviosMar() {
        if (filaMar.isEmpty() == false && comportaMar == true) {
            float larguraRestante = largura;
            float comprimentoRestante = comprimento;
            for (Object navio : filaMar) {
                Embarcacao embarcacao = (Embarcacao) navio;
                if (embarcacao.getLargura() < larguraRestante && embarcacao.getComprimento() < comprimentoRestante) {
                    filaMar.remove(0);
                    naviosEncaixados.add(embarcacao);
                    larguraRestante -= (embarcacao.getLargura() - 3);
                    comprimentoRestante -= (embarcacao.getComprimento() - 3);
                } else {
                    break;
                }
            }
        }
    }

    public void encaixarNaviosRio() {
        if (filaRio.isEmpty() == false && comportaRio == true) {
            float larguraRestante = largura;
            float comprimentoRestante = comprimento;
            for (Object navio : filaRio) {
                Embarcacao embarcacao = (Embarcacao) navio;
                if (embarcacao.getLargura() < larguraRestante && embarcacao.getComprimento() < comprimentoRestante) {
                    filaRio.remove(0);
                    naviosEncaixados.add(embarcacao);
                    larguraRestante -= (embarcacao.getLargura() - 3);
                    comprimentoRestante -= (embarcacao.getComprimento() - 3);
                } else {
                    break;
                }
            }
        }
    }
}
