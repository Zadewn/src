package model;

public class Lancha extends Embarcacao{
    public Lancha() {}
    public Lancha(int codigoID, double comprimento, double largura, double capacidade, String portoOrigem, String portoDestino, double tarifa, String sentido, Pessoa capitao) {
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

    @Override
    public String toString() {
        return String.format(
            "Barco: %d | Comp: %.2f | Larg: %.2f | Cap: %.2f | Origem: %s | Destino: %s | Tarifa: %.2f | Sentido: %s | Capitão %s",
            codigoID, comprimento, largura, capacidade, portoOrigem, portoDestino, tarifa, sentido, capitao.getNome()
        );
    }
    
}