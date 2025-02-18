package model;

public class Cruzeiro extends Embarcacao{

    public Cruzeiro(int codigoID, double comprimento, double largura, double capacidade, String portoOrigem, String portoDestino, double tarifa, String sentido, Pessoa capitao) {
        this.codigoID = codigoID;
        this.comprimento = comprimento;
        this.largura = largura;
        this.capacidade = capacidade;
        this.portoOrigem = portoOrigem;
        this.portoDestino = portoDestino;
        this.tarifa = tarifa;
        this.sentido = sentido;
        this.capitao = capitao;
    }

    public String getPortoOrigem() {
        return portoOrigem;
    }

    public String getPortoDestino() {
        return portoDestino;
    }

    @Override
    public String toString() {
        return String.format(
            "Navio: %d | Comp: %.2f | Larg: %.2f | Cap: %.2f | Origem: %s | Destino: %s | Tarifa: %.2f | Sentido: %s",
            codigoID, comprimento, largura, capacidade, portoOrigem, portoDestino, tarifa, sentido
        );
    }
}