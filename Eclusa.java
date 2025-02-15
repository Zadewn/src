
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
    private float valor = 0;//salva o valor diario 
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

    public float getvalor() {
        return valor;
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
        if (largura > 0) {
            this.largura = largura;
        }
    }

    public void setComprimento(float comprimento) {
        if (comprimento > 0) {
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

    public void setvalor(Embarcacao embarcacao) {
        if (embarcacao instanceof Lancha){
            valor += 25;
        }else if (embarcacao instanceof NavioTurismo){
            valor += 40;
        }else {
            valor += 50;
        }
    }

    public void setStatus(char status) {
        if (status == 'E' || status == 'S' || status == 'N') {
            this.status = status;
        }
    }

    public void fecharComportaAlta() {
        comportaAlta = false;
    }

    public void abrirComportaAlta() {
        if(capacidadeAtual == capacidadeMAX){
            comportaAlta = true;
        }
    }

    public void fecharComportaBaixa() {
        comportaBaixa = false;
    }

    public void abrirComportaBaixa() {
        if(capacidadeAtual == capacidadeMIN){
            comportaBaixa = true;
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

    public void esvaziarEclusa(int tuneisAbertos) {
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
                        Thread.sleep(1000); // 1000 milissegundos = 1 segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();//Alterar isso para caso de erro
                    }
                    if((int) porcentagemBruta != porcentagemArredondada){
                        porcentagemArredondada = (int) porcentagemBruta;
                        System.out.println("a porcentagem de agua atual e " + porcentagemArredondada + "%");
                    }
                    if (capacidadeAtual == capacidadeMIN){
                        System.out.println("Esse nivel de agua e o minimo");
                        status = 'N';
                        break;
                    }
                }
            }
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
                        Thread.sleep(1000); // 1000 milissegundos = 1 segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();//Alterar isso para caso de erro
                    }
                    if((int) porcentagemBruta != porcentagemArredondada){
                        porcentagemArredondada = (int) porcentagemBruta;
                        System.out.println("a porcentagem de agua atual e " + porcentagemArredondada + "%");
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
            fecharComportaBaixa();
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
            fecharComportaBaixa();
        }
    }

    public Eclusa() {
        super();
        status = 'N';
        comportaAlta = false;
        comportaBaixa = false;
    }

}
