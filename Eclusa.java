public class Eclusa{
    private float largura;
    private float comprimento;
    private float capacidadeMAX;
    private float capacidadeMIN;
    private float vazao;
    private int quantidadeCanos;
    private float preco;
    private char status; // E = Enchendo, S = secando, N = parado

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

    public int getQuantidadeCanos(){
        return quantidadeCanos;
    }

    public float getPreco(){
        return preco;
    }

    public char getStatus(){
        return status;
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

    public void setQuantidadeCanos(int quantidadeCanos){
        if(quantidadeCanos > 0){
            this.quantidadeCanos = quantidadeCanos;
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

    public float getTempo(int canos){
        if(canos > 0 && canos <= quantidadeCanos){
            float volume = capacidadeMAX - capacidadeMIN;
            return volume / (vazao * canos);
        }
        else return 0;
    }
  
}