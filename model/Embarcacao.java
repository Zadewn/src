package model;
import java.util.*;

public abstract class Embarcacao {
    protected int codigoID;
    protected double comprimento; 
    protected double largura;
    protected double capacidade; 
    protected String portoOrigem;
    protected String portoDestino;
    protected double tarifa;
    protected String sentido;
    protected Pessoa capitao;
    protected double cargaMaxima; 
    protected double pesoAdicional;
    protected ArrayList<Pessoa> tripulacao = new ArrayList<>();

    @SuppressWarnings("rawtypes")
    public ArrayList getTripulacao() { return tripulacao; }
    public double getTarifa() { return tarifa; }
    public double getLargura() { return largura; }
    public double getPesoAdicional() { return pesoAdicional; }
    public double getComprimento() { return comprimento; }
    public double getCargaMaxima() { return cargaMaxima; }
    public int getCodigoID() { return codigoID; }
    public Pessoa getCapitao() { return capitao; }
    public String getSentido() { return sentido; }

    public void setLargura(double largura) { if (largura > 0) this.largura = largura; }
    public void setComprimento(double comprimento) { if (comprimento > 0) this.comprimento = comprimento; }
    public void setTripulacao(Pessoa pessoa) { if (pessoa != null) tripulacao.add(pessoa); }
    public void setCargaMaxima(double cargaMaxima) { if (cargaMaxima >= 0) this.cargaMaxima = cargaMaxima; }
    public void setCodigoID(int codigoID) { if (codigoID != 0) this.codigoID = codigoID; }
    public void setCapitao(Pessoa pessoa) { this.capitao = pessoa; }
    public void setSentido(String sentido) { if (sentido == "R" || sentido == "M") this.sentido = sentido; }

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
    }
}
