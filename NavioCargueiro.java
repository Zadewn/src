
import java.util.*;

public class NavioCargueiro extends Embarcacao {
    
    private String portoOrigem;
    private String portoDestino;
    private ArrayList<Container> conteineres = new ArrayList<Container>();

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

    @SuppressWarnings("rawtypes")
    public ArrayList getConteineres() {
        return conteineres;
    }
    
    public void setLargura(float largura) {
        if (largura >= 10 && largura <= 61) {
            this.largura = largura;
        }
    }

    public void setComprimento(float comprimento) {
        if (comprimento >= 60 && comprimento <= 400) {
            this.comprimento = comprimento;

        }
    }

    public void setConteineres(Container container) {
        if (container != null) {
            conteineres.add(container);
        }
    }

    public void calcularPeso() {
        pesoAdicional += capitao.getPeso();
        if (tripulacao.isEmpty() == false) {
            for (Object pessoa : tripulacao) {
                Pessoa p = (Pessoa) pessoa;
                if(pesoAdicional + p.getPeso() <= cargaMaxima){
                    pesoAdicional += p.getPeso(); 
                }
            }
        }
        if (conteineres.isEmpty() == false) {
            for (Object container : conteineres) {
                Container c = (Container) container;
                if(pesoAdicional + c.getPeso() <= cargaMaxima){
                    pesoAdicional += c.getPeso();
                }
            }
        }
    }

}
