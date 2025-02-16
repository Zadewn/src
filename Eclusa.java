
import java.util.ArrayList;

public class Eclusa {

    private float largura;
    private float comprimento;
    private float capacidadeMAX;
    private float capacidadeMIN;
    private float capacidadeAtual;
    private boolean comportaBaixa; // Em direção ao rio, true = aberta, false = fechada
    private boolean comportaAlta; // Em direção ao mar
    private float vazao; // m³ segundo
    private int quantidadeTuneis;
    private float valorApurado = 0;//salva o valorApurado diario 
    private char status; // E = Enchendo, S = secando, N = parado
    private ArrayList<Embarcacao> filaMar = new ArrayList<>();
    private ArrayList<Embarcacao> filaRio = new ArrayList<>();
    private ArrayList<Embarcacao> naviosEncaixados = new ArrayList<>();

    public float getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public ArrayList getfilaMar() {
        return filaMar;
    }

    public ArrayList getfilaRio() {
        return filaRio;
    }

    public ArrayList getNaviosEncaixados() {
        return naviosEncaixados;
    }

    public float getLargura() {
        return largura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public float getCapacidadeMAX() {
        return capacidadeMAX;
    }

    public float getCapacidadeMIN() {
        return capacidadeMIN;
    }

    public float getVazao() {
        return vazao;
    }

    public int getQuantidadeTuneis() {
        return quantidadeTuneis;
    }

    public float getvalorApurado() {
        return valorApurado;
    }

    public char getStatus() {
        return status;
    }

    public boolean getComportaAlta() {
        return comportaAlta;
    }

    public boolean getComportaBaixa() {
        return comportaBaixa;
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

    public void setfilaMar(Embarcacao embarcacao) {
        if (embarcacao != null) {
            if (embarcacao.getLargura() < largura && embarcacao.getComprimento() < comprimento) {
                filaMar.add(embarcacao);
            }
        }
    }

    public void setfilaRio(Embarcacao embarcacao) {
        if (embarcacao != null) {
            if (embarcacao.getLargura() < largura && embarcacao.getComprimento() < comprimento) {
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

    public void setQuantidadeTuneis(int quantidadeTuneis) {
        if (quantidadeTuneis > 0) {
            this.quantidadeTuneis = quantidadeTuneis;
        }
    }

    public void setvalorApurado(Embarcacao embarcacao) {
        if (embarcacao instanceof Lancha){
            valorApurado += 25;
        }else if (embarcacao instanceof NavioTurismo){
            valorApurado += 40;
        }else {
            valorApurado += 50;
        }
    }

    public void setStatus(char status) {
        if (status == 'E' || status == 'S' || status == 'N') {
            this.status = status;
        }
    }

    public void alterarComportaAlta() {
        if(capacidadeAtual == capacidadeMAX && comportaAlta == false && status == 'N'){
            comportaAlta = true;
        }else{
            comportaAlta = false;
        }
    }

    public void alterarComportaBaixa() {
        if(capacidadeAtual == capacidadeMIN && comportaBaixa == false && status == 'N'){
            comportaBaixa = true;
        }else{
            comportaBaixa = false;
        }
    }

    public float getTempoMAX() { //Retorna o tempo maximo para esvaziar as filas
        float tempo = (capacidadeMAX - capacidadeMIN)/vazao;
        if(filaMar.size() > filaRio.size()){
            return tempo * filaMar.size();
        }else{
            return tempo * filaRio.size();
        }
    }

    public void esvaziarEclusa(int tuneisAbertos) throws ComportaAbertaException{
        if(comportaAlta == false && comportaBaixa == false && capacidadeAtual > capacidadeMIN){
            status = 'S';
            float porcentagemBruta;
            int porcentagemArredondada = 0;
            if (tuneisAbertos <= quantidadeTuneis && tuneisAbertos > 0) {
                while (capacidadeAtual > capacidadeMIN) {
                    if (capacidadeAtual - (vazao * tuneisAbertos) > capacidadeMIN) {
                        capacidadeAtual -= (vazao * tuneisAbertos);
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
                        System.out.println("a porcentagem de agua atual e " + porcentagemArredondada + "% (" + String.format("%.2f", capacidadeAtual) + "m3)");
                    }
                    if (capacidadeAtual == capacidadeMIN){
                        System.out.println("Esse nivel de agua e o minimo");
                        status = 'N';
                        break;
                    }
                }
            }
        }else{
            throw new ComportaAbertaException();
        }
    }

    public void encherEclusa(int tuneisAbertos) {
        if(comportaAlta == false && comportaBaixa == false && capacidadeAtual < capacidadeMAX){
            status = 'E';
            float porcentagemBruta;
            int porcentagemArredondada = 0;
            if (tuneisAbertos <= quantidadeTuneis && tuneisAbertos > 0) {
                while (capacidadeAtual < capacidadeMAX) {
                    if (capacidadeAtual + (vazao * tuneisAbertos) < capacidadeMAX) {
                        capacidadeAtual += (vazao * tuneisAbertos);
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
                        System.out.println("a porcentagem de agua atual e " + porcentagemArredondada + "% (" + String.format("%.2f", capacidadeAtual) + "m3)");
                    }
                    if (capacidadeAtual == capacidadeMAX){
                        System.out.println("Esse nivel de agua e o maximo");
                        status = 'N';
                        break;
                    }
                }
            }
        }
    }

    public void encaixarNaviosMar() {
        if (filaMar.isEmpty() == false && comportaAlta == true) {
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
            alterarComportaAlta();
        }
    }

    public void encaixarNaviosRio() {
        if (filaRio.isEmpty() == false && comportaBaixa == true) {
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
            alterarComportaBaixa();
        }
    }

    public Eclusa() {
        super();
        status = 'N';
        comportaAlta = false;
        comportaBaixa = false;
    }

}
