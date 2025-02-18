package model;

public class Cruzeiro extends Embarcacao{

    public Cruzeiro(int codigoID, double comprimento, double largura, double capacidade, String portoOrigem, String portoDestino, double tarifa, String sentido) {
        this.codigoID = codigoID;
        this.comprimento = comprimento;
        this.largura = largura;
        this.capacidade = capacidade;
        this.portoOrigem = portoOrigem;
        this.portoDestino = portoDestino;
        this.tarifa = tarifa;
        this.sentido = sentido;
    }

    public String getPortoOrigem() {
        return portoOrigem;
    }

    public String getPortoDestino() {
        return portoDestino;
    }

}