public class NavioTurismo extends Embarcacao{
    private String portoOrigem;
    private String portoDestino;

    public String getPortoOrigem() {
        return portoOrigem;
    }

    public String getPortoDestino() {
        return portoDestino;
    }

    public void setPortoOrigem(String portoOrigem) {
        if (portoOrigem != null) {
            this.portoOrigem = portoOrigem;
        }
    }

    public void setPortoDestino(String portoDestino) {
        if (portoDestino != null) {
            this.portoDestino = portoDestino;
        }
    }

    public void setLargura(float largura) {
        if (largura >= 14 && largura <= 65) {
            this.largura = largura;
        }
    }

    public void setComprimento(float comprimento) {
        if (comprimento >= 104 && comprimento <= 365 ) {
            this.comprimento = comprimento;

        }
    }
}