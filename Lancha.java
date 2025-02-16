public class Lancha extends Embarcacao{
    public void setLargura(float largura) {
        if (largura > 0) {
            this.largura = largura;
        }
    }

    public void setComprimento(float comprimento) {
        if (comprimento >= 10) {
            this.comprimento = comprimento;

        }
    }
}