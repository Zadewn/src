package model;

import java.util.ArrayList;

public class NavioCargueiro extends Embarcacao{
    private ArrayList<Container> conteineres = new ArrayList<Container>();

    public NavioCargueiro() {}
    public NavioCargueiro(int codigoID, double comprimento, double largura, double capacidade, String portoOrigem, String portoDestino, double tarifa, String sentido, Pessoa capitao) {
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

    @SuppressWarnings("rawtypes")                                                   
    public ArrayList getConteineres() { return conteineres; }
    public int getCodigoID() { return codigoID; }
    public double getComprimento() { return comprimento; }
    public double getLargura() { return largura; }
    public double getCapacidade() { return capacidade; }
    public String getPortoOrigem() { return portoOrigem; }
    public String getPortoDestino() { return portoDestino; }
    public double getTarifa() { return tarifa; }
    public String getSentido() { return sentido; }

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

    @Override
    public String toString() {
        return String.format(
            "Navio: %d | Comp: %.2f | Larg: %.2f | Cap: %.2f | Origem: %s | Destino: %s | Tarifa: %.2f | Sentido: %s | Capitão %s",
            codigoID, comprimento, largura, capacidade, portoOrigem, portoDestino, tarifa, sentido, capitao.getNome()
        );
    }
}
