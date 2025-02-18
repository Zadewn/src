package model;

public class Lancha extends Embarcacao{
    public void setLargura(float largura) {
        if (largura >= 3 && largura <= 20) {
            this.largura = largura;
        }
    }

    public void setComprimento(float comprimento) {
        if (comprimento >= 10 && comprimento <= 180) {
            this.comprimento = comprimento;

        }
    }
    
}