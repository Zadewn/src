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
    /*capitão
largura
comprimento
n passageiros
media peso passageiros
ID carga max*/

    public Lancha(){
        super();
    }

    public Lancha(float largura, float comprimento, int nPassageiros, float mediaPesoPassageiros, int ID, float cargaMax, String nomecapitao, char sentido){
        super(largura, comprimento, nPassageiros, mediaPesoPassageiros, ID, cargaMax, nomecapitao, sentido);
    }
}