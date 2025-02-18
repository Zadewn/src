package CODIGAO;

import java.util.*;

public class NavioCargueiro1 extends Embarcacao {
    
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

    public NavioCargueiro1(){
        super();
    }

    public NavioCargueiro1(float largura, float comprimento, int nPassageiros, float mediaPesoPassageiros, int nConteineres, float mediaPesoConteineres, int ID, float cargaMax, String nomecapitao, char sentido){
        this.setLargura(largura);
        this.setComprimento(comprimento);
        this.setCodigoID(codigoID);
        this.setCargaMaxima(cargaMax);
        this.setSentido(sentido);
        this.setCapitao(new Pessoa(nomecapitao, mediaPesoPassageiros));
        for (int i = 0; i < nPassageiros; i++) {
            tripulacao.add(new Pessoa(mediaPesoPassageiros));
        }
        for (int i = 0; i < nConteineres; i++) {
            conteineres.add(new Container(mediaPesoPassageiros));
        }
    }

}
