
import java.util.ArrayList;

public class Eclusa{
    private float largura;
    private float comprimento;
    private float capacidadeMAX;
    private float capacidadeMIN;
    private boolean comportaBaixa;
    private boolean comportaAlta;
    private float vazao;
    private int quantidadeTuneis;
    private float preco;
    private char status; // E = Enchendo, S = secando, N = parado
    private ArrayList<Embarcacao> fila= new ArrayList<>();
    private ArrayList<Embarcacao> naviosEncaixados= new ArrayList<>();

    public ArrayList getFila(){
        return fila;
    }

    public ArrayList getNaviosEncaixados(){
        return naviosEncaixados;
    }

    public float getLargura(){
        return largura;
    }

    public float getComprimento(){
        return comprimento;
    }

    public float getCapacidadeMAX(){
        return capacidadeMAX;
    }

    public float getCapacidadeMIN(){
        return capacidadeMIN;
    }

    public float getVazao(){
        return vazao;
    }

    public int getQuantidadeTuneis(){
        return quantidadeTuneis;
    }

    public float getPreco(){
        return preco;
    }

    public char getStatus(){
        return status;
    }

    public boolean getComportaAlta(){
        return comportaAlta;
    }

    public boolean getComportaBaixa(){
        return comportaBaixa;
    }

    public void setLargura(float largura){
        if(largura > 0){
            this.largura = largura;
        }
    }

    public void setComprimento(float comprimento){
        if(comprimento > 0){
            this.comprimento = comprimento;
        }
    }

    public void setFila(Embarcacao embarcacao){
        if (embarcacao != null){
            if(embarcacao.getLargura() < largura && embarcacao.getComprimento() < comprimento){
                fila.add(embarcacao);
            }
        }
    }
    

    public void setCapacidadeMIN(float capacidadeMIN){
        if(capacidadeMIN > 0){
            this.capacidadeMIN = capacidadeMIN;
        }
    }

    public void setCapacidadeMAX(float capacidadeMAX){
        if(capacidadeMAX > 0 && capacidadeMAX > capacidadeMIN){
            this.capacidadeMAX = capacidadeMAX;
        }
    }

    public void setVazao(float vazao){
        if(vazao > 0){
            this.vazao = vazao;
        }
    }

    public void setQuantidadeTuneis(int quantidadeTuneis){
        if(quantidadeTuneis > 0){
            this.quantidadeTuneis = quantidadeTuneis;
        }
    }

    public void setPreco(float preco){
        if(preco >= 0){
            this.preco= preco;
        }
    }

    public void setStatus(char status){
        if(status == 'E' || status == 'S' || status == 'N'){
            this.status = status;
        }
    }

    public void fecharComportaAlta(){
        comportaAlta = false;
    }

    public void abrirComportaAlta(){
        comportaAlta = true;
    }

    public void fecharComportaBaixa(){
        comportaBaixa = false;
    }

    public void abrirComportaBaixa(){
        comportaBaixa = true;
    }

    public float getTempo(int canos){
        if(canos > 0 && canos <= quantidadeTuneis){
            float volume = capacidadeMAX - capacidadeMIN;
            return volume / (vazao * canos);
        }
        else return 0;
    }

    public void encaixarNavios(){
        if(fila.isEmpty() == false){
            float larguraRestante = largura;
            float comprimentoRestante = comprimento;
            for (Object navio : fila) {
                Embarcacao embarcacao = (Embarcacao) navio;
                if (embarcacao.getLargura() < larguraRestante && embarcacao.getComprimento() < comprimentoRestante){
                    fila.remove(0);
                    naviosEncaixados.add(embarcacao);
                    larguraRestante -= (embarcacao.getLargura() - 3);
                    comprimentoRestante -= (embarcacao.getComprimento() - 3);
                }else{
                    break;
                }
            }
        }
    }

    public Eclusa(){
        super();
        status = 'N';
        comportaAlta = false;
        comportaBaixa = false;
    }
  
}