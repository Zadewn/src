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

    public NavioTurismo(){
        super();
    }

    public NavioTurismo(float largura, float comprimento, int nPassageiros, float mediaPesoPassageiros, int ID, float cargaMax, String nomecapitao, char sentido){
        super(largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, nomecapitao, sentido);
    }
}