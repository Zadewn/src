package model;

public class Lancha extends Embarcacao{
    public Lancha(int codigoID, double comprimento, double largura, double capacidade, String portoOrigem, String portoDestino, double tarifa, String sentido) {
        this.codigoID = codigoID;
        this.comprimento = comprimento;
        this.largura = largura;
        this.capacidade = capacidade;
        this.portoOrigem = portoOrigem;
        this.portoDestino = portoDestino;
        this.tarifa = tarifa;
        this.sentido = sentido;
    }

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