public class NavioTurismo extends Embarcacao{
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